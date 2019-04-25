package by.peshkur.jdbc.eagerVsLazy;

import by.peshkur.jdbc.oneToMany.model.Course;
import by.peshkur.jdbc.oneToMany.model.Instructor;
import by.peshkur.jdbc.oneToMany.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses "
                                    + "where i.id=:theInstructorId",
                            Instructor.class);

            query.setParameter("theInstructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("luv Instructor: " + instructor);

            session.getTransaction().commit();

            session.close();
            System.out.println("luv Cources: " + instructor.getCourses());

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
