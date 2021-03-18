package GymSystem;

import java.time.format.DateTimeFormatter;

public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year){
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }
    String date = day + "/" + month + "/" + year;

    public static void validDate (String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            formatter.parse(date);
            System.out.println("Valid date");
        }
        catch (Exception e){
            System.out.println("Invalid Date");
        }

    }
}
