package cb;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
//variables=====================================================================
    private static SessionFactory factory;
    
//methods=======================================================================
    
    public static Integer addEmployee(String fname, String lname, int salary) {
        Session session= factory.openSession();
        Transaction tx= null;
        Integer employeeID= null;
        
        try {
            tx=session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID= (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();        
        }
        return employeeID;
    }
    
    //Method to READ all the employees.
    public static void listEmployees(){
        Session session = factory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<?> employees= session.createQuery("FROM Employee").list();
            for (Iterator<?> iterator= employees.iterator(); iterator.hasNext();) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First name: "+employee.getFirstName());
                System.out.print(" Last Name: "+employee.getLastName());
                System.out.println(" Salary: "+employee.getSalary());
            }tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

//main==========================================================================
    public static void main (String args[]){
        try {
            factory= new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." +ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        //Add new employee records in database.
        Integer empID1= Main.addEmployee("Zara", "Ali", 1000);
        Integer empID2= Main.addEmployee("Daisy","das", 5000);
        Integer empID3= Main.addEmployee("John","Paul", 10000);
        
        //list down all the employee.
        System.out.println("List of inserted employees:");
        Main.listEmployees();
        
        /*Update employee's records
            Main.updateEmployee(empID1, 5000);
          Delete an employee from the database.
            Main.deleteEmployee(empID2);
        */
    }//~main    
}//~class
