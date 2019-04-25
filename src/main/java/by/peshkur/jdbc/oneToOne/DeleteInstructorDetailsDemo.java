package by.peshkur.jdbc.oneToOne;

import by.peshkur.jdbc.oneToOne.model.Instructor;
import by.peshkur.jdbc.oneToOne.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailsDemo {

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
            int id = 3;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Search the instructor...");
            instructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting: " + instructorDetail);
            session.delete(instructorDetail);

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
