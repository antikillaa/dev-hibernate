package by.peshkur.jdbc.oneToMany;

import by.peshkur.jdbc.oneToMany.model.Course;
import by.peshkur.jdbc.oneToMany.model.Instructor;
import by.peshkur.jdbc.oneToMany.model.InstructorDetail;
import by.peshkur.jdbc.oneToMany.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateReviewDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

//            int id = 3;

            Course course = new Course("Pacman - How to score million points");

//            Course course = session.get(Course.class, id);

            course.addReview(new Review("Shit!"));
            course.addReview(new Review("Not bad"));
            course.addReview(new Review("Thank you!"));

            session.save(course);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
