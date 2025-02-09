import java.util.*;

// User class to store user information
class User {
    private String name;
    private String email;
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void displayUser() {
        System.out.println("User Registered: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}

// Appointment class to manage appointment scheduling
class Appointment {
    private static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] OPEN_HOURS = {8, 20, 20, 20, 20, 17}; // Closing times per day
    
    private String day;
    private int hour;
    
    public Appointment(String day, int hour) {
        this.day = day;
        this.hour = hour;
    }
    
    public boolean isValid() {
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equalsIgnoreCase(day) && hour >= 8 && hour <= OPEN_HOURS[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void displayAppointment() {
        System.out.println("Appointment scheduled on " + day + " at " + hour + ":00.");
    }
}

// Main program
public class CommunityGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Community Garden Program!");
        
        while (true) {
            System.out.println("1. Register  2. Schedule Appointment  3. Make a Donation  4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                User user = new User(name, email, phone);
                user.displayUser();
            } else if (choice == 2) {
                System.out.print("Enter Day (Monday-Saturday): ");
                String day = scanner.nextLine();
                System.out.print("Enter Hour (8-20 Mon-Fri, 8-17 Sat): ");
                int hour = scanner.nextInt();
                
                Appointment appt = new Appointment(day, hour);
                if (appt.isValid()) {
                    appt.displayAppointment();
                } else {
                    System.out.println("Invalid appointment time. Please try again.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Donation Type (Money/Gardening Material): ");
                String donation = scanner.nextLine();
                System.out.println("Thank you for your " + donation + " donation!");
            } else if (choice == 4) {
                System.out.println("Exiting program. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
