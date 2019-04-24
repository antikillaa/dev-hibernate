package by.peshkur.jdbc.oneToOne;

import by.peshkur.jdbc.oneToOne.model.Instructor;
import by.peshkur.jdbc.oneToOne.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructor {

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
            int id = 2;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Instructor Detail: " + instructorDetail);

            System.out.println("the associated instructor: " + instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
