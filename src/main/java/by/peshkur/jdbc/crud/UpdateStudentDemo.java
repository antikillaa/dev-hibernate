package by.peshkur.jdbc.crud;

import by.peshkur.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();

            System.out.println("\nGetting student with id " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            student.setFirstName("Stasi4");

            session.getTransaction().commit();

            //Bulk update

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update Student s set s.email='foooo@gmail.com'").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }

}
