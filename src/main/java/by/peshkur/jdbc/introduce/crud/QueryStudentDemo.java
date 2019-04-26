package by.peshkur.jdbc.introduce.crud;

import by.peshkur.jdbc.introduce.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object...");

            Student student = new Student("Daffy", "Duck", "duffy@luv.com");

            session.beginTransaction();

            System.out.println("Saving the Student...");
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();


            System.out.println("Saved Student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting Student with id: " + student.getId());

            Student student1 = session.get(Student.class, student.getId());

            System.out.println("Get complite: " + student1);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
