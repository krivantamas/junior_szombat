package streams;

public class Employee {

    private int id;
    private String name;
    private int salary;
    private Organization organization;

    public Employee(int id, String name, int salary, Organization organization) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.organization = organization;
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.organization = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", organization=" + organization +
                '}';
    }

    public void increaseSalary(int amount) {
        salary += amount;
    }
}

