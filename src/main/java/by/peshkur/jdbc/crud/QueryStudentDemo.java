package by.peshkur.jdbc.crud;

import by.peshkur.jdbc.model.Student;
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
            System.out.println("Creating new student object...");

            Student student = new Student("Daffy", "Duck", "duffy@luv.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(student);
            session.save(student);

            session.getTransaction().commit();


            System.out.println("Saved student. Generated id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + student.getId());

            Student student1 = session.get(Student.class, student.getId());

            System.out.println("Get complite: " + student1);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
