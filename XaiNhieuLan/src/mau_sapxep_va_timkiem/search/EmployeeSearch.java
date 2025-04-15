/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mau_sapxep_va_timkiem.search;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EmployeeSearch {
 
   
    public static void main(String[] args) {
        EmployeeList el = new EmployeeList();
       
        el.addNewEmp(new Employee("1", "Alice", 5000, "IT", 95.5f, 5500));
        el.addNewEmp(new Employee("2", "Bob", 4000, "HR", 87.0f, 4500));
        el.addNewEmp(new Employee("3", "Charlie", 4500, "IT", 92.3f, 5000));
        el.addNewEmp(new Employee("4", "David", 3500, "HR", 80.4f, 4000));
        

        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("Menu Tim Kiem:");
            System.out.println("1. Tim kiem theo phong ban");
            System.out.println("2. Tim kiem theo luong");
            System.out.println("3. Tim kiem theo diem nang suat");
            System.out.println("4. Tim kiem theo thu nhap hang thang");
            System.out.println("0. Thoat");
            System.out.print("Chon mot tuy chon: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng mới
            ArrayList<Employee> rs = new ArrayList();
            switch (option) {
                case 1 -> {
                    System.out.print("Nhap phong ban: ");
                    String department = scanner.nextLine();
                    rs =el.searchEmployees(e->e.getDepartment().equals(department));
                }
                case 2 -> {
                    System.out.print("Nhap luong toi thieu: ");
                    double minSalary = scanner.nextDouble();
                   rs =el.searchEmployees( employee -> employee.getSalary() >= minSalary);
                }
                case 3 -> {
                    System.out.print("Nhap nang suat toi thieu: ");
                    float minProductivityScore = scanner.nextFloat();
                    rs =el.searchEmployees( employee -> employee.getProductivityScore() >= minProductivityScore);
                }
                case 4 -> {
                    System.out.print("thu nhap toi thieu: ");
                    double minMonthlyIncome = scanner.nextDouble();
                    rs=el.searchEmployees(employee -> employee.getMonthlyIncome() >= minMonthlyIncome);
                }
                
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
            
            el.displayAll(rs);
            
            
           
        }
        
         
        
        
    }
  
}


