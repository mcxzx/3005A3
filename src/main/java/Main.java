/*
    Example of connect to the database and invoke the assignment required functions

        Zhihao Xu
        101306742
*/

import java.sql.Connection;
import java.sql.DriverManager;

//This imports the specifically implemented package
import dbinteract.StudentDB;

public class Main{
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/a3_q1_demo";
        String user = "postgres";
        String password = "Slices";//"admin";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if(connection != null){
                System.out.println("Connected to the database!\n\n");


                /// The following are code to invoke the specified functions

                //Create the StudentDB object corresponding to the connection
                StudentDB db = new dbinteract.StudentDB(connection);



                //test with required functions
                db.getAllStudents();
                System.out.println("\n\n");

                String email = "K(E,k)@example.com";
                db.addStudent("Elieenberg", "McLane", email, "1913-09-30");
                db.getAllStudents();
                System.out.println("\n\n");

                int new_student_id = db.getStudentID(email);//custom implemented function, not required in specification
                System.out.println("New student ID for email '"+email+"' is : " + new_student_id + "\n\n");

                db.updateStudentEmail(new_student_id, "K(E⊕F,k)@example.com");
                db.getAllStudents();
                System.out.println("\n\n");

                db.deleteStudent(new_student_id);
                db.getAllStudents();
                System.out.println("\n\n");


            }else{
                System.out.println("Failed to make connection!");
            }

        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
