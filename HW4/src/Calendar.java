import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Calendar {
    private Appointment[] appointments;

    Calendar() {
        appointments = new Appointment[0];
    }

    Calendar(int capacity, String filename) {
        appointments = new Appointment[capacity];
        appointments = readAppointmentsFromFile(filename);
    }

    public Appointment[] readAppointmentsFromFile(String filename) {
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new FileInputStream(filename)); //initialize scanner
            //assuming all went well, read file
            for (int i = 0; fileScanner.hasNextLine(); i++) { //run for each line in file
                String str = fileScanner.nextLine();
                if (!str.equals("")) { //if line is not blank
                    String[] line = str.split(",");
                    if (!(line.length <= 1)) {
                        try {
                            appointments[i] = new Appointment(line[0].trim(), line[1].trim(), line[2].trim(), line[3].trim());
                        }
                        catch (Exception e) {
                            System.out.println("error?: " + e.getMessage());
                        }
                    }
                }
                else
                    appointments[i] = null;
            }
            fileScanner.close(); //close scanner
            return appointments;
        }
        catch (FileNotFoundException e) {
            //print to file
            saveCalendarToFile(filename);
            return appointments;
        }
    }

    public void saveCalendarToFile(String filename) {
        try {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(filename)); //initialize writer, this creates the file if not already there
            for (Appointment app : appointments) {
                if (app == null)
                    fileWriter.println("");
                else //print appointment with commas between values
                    fileWriter.println(app.getEvent() + ", " + app.getDate() + ", " + app.getTime() + ", " + app.getEvent());
            }
            fileWriter.close(); //close writer
        }
        catch (Exception e) {
            //if file not found? should not occur since file is created above
            System.out.println("error: " + e.getMessage());
        }
    }

    public boolean addAppointment(Appointment app) {
        int i;
        for (i = 0; i < appointments.length; i++) {
            if (appointments[i] == null) { //find first i where there is no appointment
                break;
            }
        }
        if (i == appointments.length) //if got to end of calendar, failed to add
            return false;
        //else
        appointments[i] = app;
        return true;
    }

    public void removeAppointment(Appointment app) {
        int i;
        for (i = 0; i < appointments.length; i++) {
            if (appointments[i].equals(app)) { //if match, remove and exit method
                appointments[i] = null;
                return;
            }
        }
    }

    public Appointment findAppointment(String event) {
        for (Appointment app : appointments) {
            if (app != null && app.getEvent().equals(event)) //if found, return appointment
                return app;
        }
        return null;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Appointment app : appointments)
            if (app != null) //if not blank, add to string builder
                str.append(app.toString());
        return str.toString();
    }
}
