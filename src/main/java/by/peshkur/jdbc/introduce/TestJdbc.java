package by.peshkur.jdbc.introduce;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl2 = "jdbc:postgresql://localhost:5432/hb_student_tracker";

        String user = "admin";
        String pass = "password";

        try {
            System.out.println("Connecting to database" + jdbcUrl2);

            Connection myConn = DriverManager.getConnection(jdbcUrl2, user, pass);
            System.out.println("Connection success");


        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }
}
