package by.peshkur.jdbc.oneToOne;

import by.peshkur.jdbc.oneToOne.model.Instructor;
import by.peshkur.jdbc.oneToOne.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new instructor object...");

            Instructor instructor = new Instructor("Chad", "Darby", "darby@pax.com");
            InstructorDetail instructorDetail =
                    new InstructorDetail("http://pax.com/youtube", "Codding");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving the instructor...");

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
