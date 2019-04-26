package by.peshkur.jdbc.manyToMany;

import by.peshkur.jdbc.manyToMany.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 1;

            Student student = session.get(Student.class, id);

            System.out.println("\nLoaded student: " + student);
            System.out.println("\nLoaded courses: " + student.getCourses());

            Course course1 = new Course("Rubik's Cube - How to speed Cube");
            Course course2 = new Course("Atari 2600 - Game Development");

            course1.addStudent(student);
            course2.addStudent(student);

            System.out.println("\nSaving courses ...");

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
