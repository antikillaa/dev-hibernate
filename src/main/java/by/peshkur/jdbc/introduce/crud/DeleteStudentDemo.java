package by.peshkur.jdbc.introduce.crud;

import by.peshkur.jdbc.introduce.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try {
/*            int studentId = 1;
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);
            session.getTransaction().commit();
            System.out.println("Done!");*/


            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int studentId = 1;
            Student myStudent = session.get(Student.class, studentId);
            session.createQuery("delete from Student where id=2").executeUpdate();
            session.beginTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
