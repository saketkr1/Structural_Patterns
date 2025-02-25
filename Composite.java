

/*
The Composite Pattern is a structural design pattern that enables the composition of objects
into tree structures to represent part-whole hierarchies.
The Composite Pattern allows clients to treat individual objects and compositions of objects uniformly.
 */

import java.util.ArrayList;
import java.util.List;

interface OrganisationComponent {
    String getName();
    int getHours();
}

class Employee implements OrganisationComponent {
    private String name;
    private int hours;

    public Employee(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHours() {
        return hours;
    }
}

class Department implements OrganisationComponent {
    private String name;
    private List<OrganisationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

   @Override
    public int getHours() {
        int totalHours = 0;
        for (OrganisationComponent component: components) {
            totalHours += component.getHours();
        }
        return totalHours;
    }

    public void addComponent(OrganisationComponent component) {
        components.add(component);
    }
}

public class Composite {
    public static void main(String[] args) {
        OrganisationComponent employee1 = new Employee("John", 40);
        OrganisationComponent employee2 = new Employee("Jane", 30);

        Department department1 = new Department("Engineering");
        department1.addComponent(employee1);
        department1.addComponent(employee2);

        OrganisationComponent employee3 = new Employee("Alice", 20);
        OrganisationComponent employee4 = new Employee("Bob", 25);

        Department department2 = new Department("Marketing");
        department2.addComponent(employee3);
        department2.addComponent(employee4);

        Department company = new Department("Company");
        company.addComponent(department1);
        company.addComponent(department2);

        System.out.println("Total hours worked by the company: " + company.getHours());
    }
}
