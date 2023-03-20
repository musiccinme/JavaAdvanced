package Exam.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity){
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee){
        if (this.employees.size() < capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        int oldest = 0;
        Employee employeeToReturn = new Employee("", oldest, "");
        for (Employee employee : employees) {
            if(employee.getAge() > oldest){
                oldest = employee.getAge();
                employeeToReturn = employee;
            }
        }
        return employeeToReturn;
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        String name = String.format("Employees working at Cafe %s", this.name);
        builder.append(name).append(System.lineSeparator());
        for (Employee employee : employees) {
            String dataEmployee = employee.toString();
            builder.append(dataEmployee).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
