/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;


public class Validation {
    public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";
    final static Scanner scanner = new Scanner(System.in);
    public static int getInt() {
        return getInt(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(int minRange, int maxRange) {
        return getInt(null, minRange, maxRange);
    }

    public static int getInt(String msg) {
        return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter again...");
            }
        } while (value < minRange || value > maxRange);
        return value;
    }

    public static float getFloat() {
        return getFloat(null, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static float getFloat(float minRange, float maxRange) {
        return getFloat(null, minRange, maxRange);
    }

    public static float getFloat(String msg) {
        return getFloat(msg, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static float getFloat(String msg, float minRange, float maxRange) {
        if (minRange > maxRange) {
            float temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        float value = Float.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                value = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter again...");
            }
        } while (value < minRange || value > maxRange);
        return value;
    }

    public static String getString(String msg, String pattern) {
        String value = null;
        do {
            value = getString(msg);
        } while (!value.matches(pattern));

        return value;
    }

    public static String getString(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }
            value = scanner.nextLine().replaceAll("\\s+", " ").trim();
            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }
            System.err.println("Please enter again...");
        }
        return value;
        
    }
    
    
    
    
    public Date checkValidDate(String msg) {
        while (true) {
            try {
                return validStringToDate(msg);
            } catch (ParseException ex) {
                System.out.println(msg+"Invalid date. Date format: dd/mm/yyyy");
                return null;
            }
        }
    }

    
    
    public  static Date validStringToDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.parse(date);
    }

    public static String showDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }
    
    
     public static Date inputDate(String msg) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); 

        while (true) {
            try {
                System.out.print(msg);
                String input = scanner.nextLine();
                Date date = dateFormat.parse(input);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter date in yyyy-MM-dd format.");
            }
        }
    }
     
     
     
     //check id
    public String checkEmpId(String input) throws Exception {
        String temp = input.trim();
        if (temp == null || temp.length() != 6) {
            return null;
        }
        String mnv = "MNV";
        String subStr = temp.substring(0, 3);
        if (!mnv.equals(subStr)) {
            return null;
        }
        String subStr1 = temp.substring(3, 6);
        for (int i = 0; i < subStr1.length(); i++) {
            if (subStr1.charAt(i) < '0' || subStr1.charAt(i) > '9') {
                return null;
            }
        }
        if (temp == null) {
            throw new Exception("ID employee is wrong");
        }
        return temp;
    }
    
    //checkid c2
//    public static String checkId(String id) {
//        String temp = id.trim();
//        if (temp.matches("KH\\d{2}")) {
//            return temp;
//        } else {
//            return null;
//        }
//    }
    
    public static LocalDateTime convertDateTime(String formattedDateTime) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT); // Đảm bảo rằng DATE_FORMAT bao gồm ngày, tháng, năm, giờ và phút

    LocalDateTime dateTime = LocalDateTime.parse(formattedDateTime, dateTimeFormatter);
    return dateTime;
}
    public static LocalDateTime inputLocalDateTime(String msg) {
    while (true) {
        try {
            String input = getString(msg);
            LocalDateTime dateTime = convertDateTime(input);
            return dateTime;
        } catch (Exception e) {
            System.out.println("Invalid date/time format or date/time does not exist!");
        }
    }
}

    public static LocalDate convertDate(String formattedDate) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        LocalDate date = LocalDate.parse(formattedDate,dateTimeFormatter);
        return date;
    }

    public static LocalDate inputLocalDate(String msg) {
        while (true) {
            try {
                String input = getString(msg);
                LocalDate date = convertDate(input);
                return date;
            } catch (Exception e) {
                System.out.println("Invalid date format or date not exist!");
            }
        }
    }
    public static LocalDate checkValidLocalDate(String dateStr) {
        while (true) {
            try {
                return validStringToLocalDate(dateStr);
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date: " + dateStr + ". Date format: " + DATE_FORMAT);
                return null;
            }
        }
    }

    // Phương thức chuyển đổi chuỗi thành LocalDate
    public static LocalDate validStringToLocalDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(dateStr, formatter);
    }

    // Phương thức hiển thị LocalDate dưới dạng chuỗi
    public static String showLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return date.format(formatter);
    }
}
