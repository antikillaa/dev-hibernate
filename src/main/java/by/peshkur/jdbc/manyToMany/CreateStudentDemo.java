package by.peshkur.jdbc.manyToMany;

import by.peshkur.jdbc.manyToMany.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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

            Course course = new Course("Pacman - How to score million points");

            session.save(course);

            Student student1 = new Student("Stanislav", "Peshkur", "abc@luvcode.com");
            Student student2 = new Student("John", "Doe", "john@luvcode.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);


            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
