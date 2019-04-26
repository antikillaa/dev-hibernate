package by.peshkur.jdbc.introduce;

import by.peshkur.jdbc.introduce.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object...");

            Student student = new Student("Paul", "Wall", "paul@luv.com");

            session.beginTransaction();

            System.out.println("Saving the Student...");

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
