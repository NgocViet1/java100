/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mau_sapxep_va_timkiem.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class EmployeeList {
      List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
      
    
       
    //neu bi lam array list
//    public static ArrayList<Employee> searchEmployees(List<Employee> employees, Predicate<Employee> criteria) {
//        return employees.stream()
//                .filter(criteria)
//                .collect(Collectors.toCollection(ArrayList::new));
//    }
    
    

    public ArrayList<Employee> searchEmployees(Predicate<Employee> criteria) {
        ArrayList<Employee> rs = new ArrayList<>();
        employees.forEach(e -> {
            if (criteria.test(e)) {
                rs.add(e);
            }
        }
        );
        return rs;
    }
//      public void search(Predicate<Employee> predicate){
//        ArrayList<Employee> list = new ArrayList<>();
//
//        for (Employee employee : employees ) {
//            if (predicate.test(employee)) {
//                list.add(employee);
//            }
//        }
//          System.out.println("Search result: ");
//        if (!list.isEmpty()) {
//            list.forEach(s->System.out.println(s));
//        }
//        else{
//             System.err.println("List Empty.");
//        }
//        
//        
//    }
    
    public void displayAll(ArrayList<Employee> list){
         int total = list.size();
        if(total <= 0){
            System.out.println("Sorry. Nothing to print!");
            return;
        }
        
        list.forEach(System.out::println);
    }
    

     public void addNewEmp(Employee e){
        employees.add(e);
     }
    
}
