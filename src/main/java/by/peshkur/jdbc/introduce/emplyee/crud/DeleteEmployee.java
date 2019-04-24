package by.peshkur.jdbc.introduce.emplyee.crud;

import by.peshkur.jdbc.introduce.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Random;

public class DeleteEmployee {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Integer> employees = session.createQuery("select e.id from Employee e").getResultList();

            Random random = new Random();
            int randomNumber = random.nextInt(employees.size());
            randomNumber = employees.get(randomNumber);

            // now get a new session and start transaction
            session = factory.getCurrentSession();

            // retrieve employee based on the id: primary key
            System.out.println("\nGetting employee with id: " + randomNumber);

            Employee myEmployee = session.get(Employee.class, randomNumber);

            // delete the employee
            System.out.println("Deleting employee: " + myEmployee);
            session.delete(myEmployee);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
