package by.peshkur.jdbc.crud;

import by.peshkur.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            displayStudents(students);


            students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            System.out.println("\n\nStudents who las name of Doe");

            displayStudents(students);


            System.out.println();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
