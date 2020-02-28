import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    Date() {
        day = 0;
        month = 0;
        year = 0;
    }

    Date(String date) throws InvalidDateException {
        //check format
        if (!date.trim().matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9]"))
            throw new InvalidDateException("Invalid date format!"); //throw exception
        day = Integer.parseInt(date.substring(0, 2));
        month = Integer.parseInt(date.substring(3, 5));
        year = Integer.parseInt(date.substring(6, 8));
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        String str = "";
        if (day < 10) //if day single digits add leading zero
            str += "0";
        str += day + "/";
        if (month < 10) //if month single digits add leading zero
            str += "0";
        str += month + "/";
        if (year < 10) //if year single digits add leading zero
            str += "0";
        str += year;
        return str;
    }

    public boolean equals(Object obj) {
        return obj instanceof Date && day == ((Date) obj).getDay() && month == ((Date) obj).getMonth() && year == ((Date) obj).getYear();
    }
}
