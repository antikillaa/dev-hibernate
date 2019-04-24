package by.peshkur.jdbc.oneToOne;

import by.peshkur.jdbc.oneToOne.model.Instructor;
import by.peshkur.jdbc.oneToOne.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new instructor object...");

            session.beginTransaction();
            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Search the instructor...");

            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
