/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mau_sapxep_va_timkiem.search;

  public class Employee {
    private String id;
    private String name;
    private double salary;
    private String department;
    private float productivityScore;
    private double monthlyIncome;

    // Constructor, getters, and setters
    public Employee(String id, String name, double salary, String department, float productivityScore, double monthlyIncome) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.productivityScore = productivityScore;
        this.monthlyIncome = monthlyIncome;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public float getProductivityScore() {
        return productivityScore;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + ", productivityScore=" + productivityScore + ", monthlyIncome=" + monthlyIncome + '}';
    }
    
    
}

