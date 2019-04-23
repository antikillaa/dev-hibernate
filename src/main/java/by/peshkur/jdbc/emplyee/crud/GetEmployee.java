package by.peshkur.jdbc.emplyee.crud;

import by.peshkur.jdbc.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetEmployee {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
//            List employees = session.createQuery("from Employee").getResultList();

            List<Employee> employees = session.createQuery("from Employee e where e.company = 'Epam'").getResultList();

            for (Employee employee : employees) {
                System.out.println("\n\n" + employee);

            }
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
