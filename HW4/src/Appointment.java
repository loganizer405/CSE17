public class Appointment {
    private String event;
    private Date date;
    private Time time;
    private String location;

    Appointment() {
        event = "";
        date = new Date();
        time = new Time();
        location = "";
    }

    Appointment(String event, String date, String time, String location) throws InvalidTimeException, InvalidDateException {
        this.event = event;
        this.date = new Date(date);
        this.time = new Time(time);
        this.location = location;
    }

    public String getEvent() {
        return event;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public Time getTime() {
        return time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String toString() {
        //returns formatted string
        return String.format("%15s\t%8s\t%5s\t%15s\n", event, date, time, location);
    }

    public boolean equals(Object obj) {
        return obj instanceof Appointment && event.equals(((Appointment) obj).getEvent())
                && date == ((Appointment) obj).getDate()
                && time == ((Appointment) obj).getTime()
                && location.equals(((Appointment) obj).getLocation());
    }
}
