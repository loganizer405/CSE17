import java.util.Scanner;

public class CalendarManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calendar calendar = new Calendar(30, "appointments.txt");
        int operation;
        Appointment app;
        do {
            operation = getOperation(input);
            switch (operation) {
                case 1: //view appointment
                    input.nextLine(); //skip line
                    System.out.print("Enter event: ");
                    app = calendar.findAppointment(input.nextLine());
                    System.out.println(app == null ? "Appointment not found." : app.toString()); //return appt not found or print attributes of appt
                    break;
                case 2: //view all appointments
                    System.out.println("Event\t\t\tDate\t\tTime\tLocation");
                    System.out.println(calendar.toString());
                    break;
                case 3: //add new appointment
                    input.nextLine(); //skip line
                    while (true) { //run until successfully added
                        try {
                            System.out.print("Enter event: ");
                            String event = input.nextLine();
                            System.out.print("Enter date (format MM/DD/YY): ");
                            String date = input.nextLine();
                            System.out.print("Enter time (format 24hr, HH:MM): ");
                            String time = input.nextLine();
                            System.out.print("Enter location: ");
                            String loc = input.nextLine();
                            app = new Appointment(event, date, time, loc); //will throw exception if wrong format
                            if (calendar.addAppointment(app))
                                System.out.println("Appointment added successfully.");
                            else
                                System.out.println("Calendar full, cannot add more appointments.");
                            break; //if all finishes, exit do-while loop

                        }
                        catch (InvalidDateException | InvalidTimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 4: //update appointment
                    input.nextLine(); //skip line
                    System.out.print("Enter event: ");
                    app = calendar.findAppointment(input.nextLine());
                    if (app == null) {
                        System.out.println("Appointment not found.");
                        break;
                    }
                    while (true) { //run until successfully updated
                        try {
                            System.out.print("Enter new event: ");
                            String event = input.nextLine();
                            System.out.print("Enter new date (format MM/DD/YY): ");
                            String date = input.nextLine();
                            System.out.print("Enter new time (format 24hr, HH:MM): ");
                            String time = input.nextLine();
                            System.out.print("Enter new location: ");
                            String loc = input.nextLine();
                            calendar.removeAppointment(app); //remove old
                            if (calendar.addAppointment(new Appointment(event, date, time, loc))) //will throw exception if wrong format
                                System.out.println("Appointment updated successfully.");
                            else //this should not happen since one is deleted but just in case
                                System.out.println("Calendar full, cannot add more appointments.");
                            break; //if all finishes, exit do-while loop
                        }
                        catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 5: //remove appointment
                    input.nextLine(); //skip line
                    System.out.print("Enter event: ");
                    app = calendar.findAppointment(input.nextLine());
                    if (app == null) {
                        System.out.println("Appointment not found.");
                        break;
                    }
                    //if found
                    calendar.removeAppointment(app);
                    System.out.println("Appointment removed successfully.");
                    break;
                case 6: //save and exit
                    System.out.println("Saving and exiting program...");
                    calendar.saveCalendarToFile("appointments.txt");
                    break;
            }
        } while (operation != 6);
    }

    public static int getOperation(Scanner input) {
        int op;
        while (true) { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: View appointment");
            System.out.println("2: View all appointments");
            System.out.println("3: Add new appointment");
            System.out.println("4: Update existing appointment");
            System.out.println("5: Remove existing appointment");
            System.out.println("6: Exit program");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 6) break;  //if within bounds break the loop
                else
                    System.out.println("Invalid operation (1-6)");
            }
            else {
                input.nextLine();
                System.out.println("Invalid operation (must be integer)");
            }
        }
        return op;
    }
}
