/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docfile;

import Validation.Validation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DocFile {

    public void readFile(String fName) {
        String code;
        String name;
        int quantity;
        Date expirationDate = null;
        double price;
        Date lastInjectedDate = null;

        String content = "";
        try (FileReader f = new FileReader(fName); BufferedReader br = new BufferedReader(f)) {
            while ((content = br.readLine()) != null) {
                String[] b = content.split(",");

                if (b.length <= 1) {
                    continue;
                }
                code = b[0].split("=")[1].trim();
                name = b[1].split("=")[1].trim();
                quantity = Integer.parseInt(b[2].split("=")[1].trim());
                expirationDate = Validation.validStringToDate(b[3].split("=")[1].trim());
                price = Double.parseDouble(b[4].split("=")[1].trim());
                lastInjectedDate = Validation.validStringToDate(b[5].split("=")[1].trim());
                //vaccines.add(new Vaccine(code,name,quantity,expirationDate,price,lastInjectedDate));
            }
        } catch (Exception ex) {
            System.out.println("error");

        }
    }
//     public void loadData(String fName) {
//        String content = "";
//        try (FileReader f = new FileReader(fName); BufferedReader br = new BufferedReader(f)) {
//            while ((content = br.readLine()) != null) {
//                String[] b = content.split(",");
//
//                if (b.length <= 1) {
//                    continue;
//                }
//                String id = Validation.checkEmpId(b[0]);
//                LocalDate d = Validation.checkValidLocalDate(b[2]);
//                if (d != null&& id!=null) {
//                  /*this o day la danh sach khi extend*/  this.add(new Patient(b[0], b[1], d, b[3]));
//
//                }
//
//            }
//        } catch (Exception ex) {
//
//        }
//    }
    
    //CACH 2 DOC FILE
    
    //    private void loadData(String fname) {
//        File file = new File(fname);
//        try {
//            Object[] lines = new BufferedReader(new FileReader(file)).lines().toArray();
//            for(var line : lines){
//                
//                String[] row = line.toString().split(",");
//                if (row.length<=1) {
//                    continue;
//                    
//                }
//                
//                 String id = val.checkEmpId(row[0]);
//                Date d = val.checkValidDate(row[2]);
//                
//                if((id != null) && (d != null)){
//                    employees.add(new Employee(val.checkEmpId(row[0]),row[1], d, Float.parseFloat(row[3]), Integer.parseInt(row[4])));
//                    }
//                
//                
//            }
//        }catch (Exception ioException){
//            System.out.println("Error.");
//        }
//    }
    
}
