package by.peshkur.jdbc.emplyee;

import by.peshkur.jdbc.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Employee employee = new Employee("Soul", "Alex", "Andersen");
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
