package dbinteract;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDB{
    private Connection connection;
    private static final String[] student_columns = {
            "student_id",
            "first_name",
            "last_name",
            "email",
            "enrollment_date"
    };

    public StudentDB(Connection connection){
        this.connection = connection;
        if(connection == null) {
            System.out.println("Connection is null!");
        }
    }



    /// The following are the required functions being implemented

    //Retrieves and displays all records from the students table
    public void getAllStudents(){
        if(connection != null){
            try{
                ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM students ORDER BY student_id ASC");
                while(rs.next()){
                    printResultEntry(rs, student_columns);
                }
            }catch(SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
    }

    //Inserts a new student record into the students table
    public boolean addStudent(String first_name, String last_name, String email, String enrollment_date){
        if(connection != null){
            try{
                return connection.createStatement().execute("INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES ('"+first_name+"', '"+last_name+"', '"+email+"', '"+enrollment_date+"')");
            }catch(SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
        return false;
    }

    //Updates the email address for a student with the specified student_id
    public boolean updateStudentEmail(int student_id, String new_email){
        if(connection != null){
            try{
                return connection.createStatement().execute("UPDATE students SET email = '"+new_email+"' WHERE student_id = "+student_id);
            }catch(SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
        return false;
    }

    //Deletes the record of the student with the specified student_id
    public boolean deleteStudent(int student_id){
        if(connection != null){
            try{
                return connection.createStatement().execute("DELETE FROM students WHERE student_id = "+student_id);
            }catch(SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
        return false;
    }


    //customized function(s)

    //Get student ID by email
    public int getStudentID(String email){
        if(connection != null){
            try{
                ResultSet rs = connection.createStatement().executeQuery("SELECT student_id FROM students WHERE email = '"+email+"'");
                if(rs.next()){
                    return rs.getInt("student_id");
                }
            }catch(SQLException e){
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
        return -1;
    }



    //Helper function(s)

    private void printResultEntry(ResultSet rs, String[] columns) throws SQLException {
        for(String col : columns){
            System.out.print(rs.getString(col) + " \t");
        }
        System.out.println();
    }
}