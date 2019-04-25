package by.peshkur.jdbc.oneToMany;

import by.peshkur.jdbc.oneToMany.model.Course;
import by.peshkur.jdbc.oneToMany.model.Instructor;
import by.peshkur.jdbc.oneToMany.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

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

            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + instructor);

            System.out.println("Cources: " + instructor.getCourses());


            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
