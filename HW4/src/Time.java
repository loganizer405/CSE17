public class Time {
    int hours;
    int minutes;

    Time() {
        hours = 0;
        minutes = 0;
    }

    Time(String time) throws InvalidTimeException {
        if (!time.matches("[0-2][0-9]:[0-5][0-9]"))
            throw new InvalidTimeException("Invalid time format!");
        if (Integer.parseInt(time.substring(0, 2)) > 23 || Integer.parseInt(time.substring(0, 2)) < 0)
            throw new InvalidTimeException("Invalid hours!");
        if (Integer.parseInt(time.substring(3, 5)) > 59 || Integer.parseInt(time.substring(3, 5)) < 0)
            throw new InvalidTimeException("Invalid minutes!");
        minutes = Integer.parseInt(time.substring(0, 2));
        hours = Integer.parseInt(time.substring(3, 5));
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String toString() {
        String str = "";
        if (hours < 10) //if single digits hours add leading zero
            str = "0";
        str += hours + ":";
        if (minutes < 10) //if single digits minutes add leading zero
            str += "0";
        str += minutes;
        return str;
    }

    public boolean equals(Object obj) {
        return obj instanceof Time && minutes == ((Time) obj).minutes && hours == ((Time) obj).hours;
    }
}
