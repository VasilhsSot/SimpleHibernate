package cb;

public class Employee {
//variables=====================================================================
    private String firstName;
    private String lastName;
    private int id;
    private int salary;

//constructors==================================================================
    public Employee () {}
    
    public Employee(String fname, String lname, int salary){
        this.firstName=fname;
        this.lastName=lname;
        this.salary=salary;
    }

//setters & getters=============================================================
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

}//~class
