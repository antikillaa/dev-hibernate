package by.peshkur.jdbc.oneToMany;

import by.peshkur.jdbc.oneToOne.model.Course;
import by.peshkur.jdbc.oneToOne.model.Instructor;
import by.peshkur.jdbc.oneToOne.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 4;

            Course course = session.get(Course.class, id);

            System.out.println("Deleting course: " + course);

            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
