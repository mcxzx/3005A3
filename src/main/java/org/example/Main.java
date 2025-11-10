package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/a2_db";
        String user = "postgres";
        String password = "Slices";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection != null){
                System.out.println("Connected to the database!");

                Statement stmt = connection.createStatement();
                stmt.executeQuery("SELECT * FROM public.publishers\n" +
                        "ORDER BY publisher_id ASC ");
                ResultSet resultSet = stmt.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getString("publisher_name"));
                }



            }else{
                System.out.println("Failed to make connection!");
            }

        }catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}