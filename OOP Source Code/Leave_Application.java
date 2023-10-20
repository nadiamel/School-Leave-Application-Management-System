import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Leave_Application {   
    public static void displayStaffMenu() {
        System.out.println ("\n<<<< Staff Interface >>>>>");
        System.out.println ("Please choose the following choices");
        System.out.println ("1) Make a Leave application ");
        System.out.println ("2) View your application status");
        System.out.println ("3) Return to previous interface");
        System.out.print("\nYour choice: ");
    }
    
    public static void displayAdminMenu() {
        System.out.println ("\n<<<< Admin Interface >>>>>");
        System.out.println ("Please choose the following choices");
        System.out.println ("1) Process pending Leave application");
        System.out.println ("2) View applications processed");
        System.out.println ("3) Return to previous interface");
        System.out.print("\nYour choice: ");
    }
    
    public static void main (String []args) {
        Scanner input=new Scanner (System.in);
        int choice = 0;
        Staff staff = new Staff();
        
        Login_system login = new Login_system();
        
        login.addStaff(new Staff("Nadia Syafiqah", "020704010740", "01112789289", "Female", "naddysyaf@gmail.com", "Accountant", new Address("Jalan Pelangi", "Johor Bahru", "Johor"), "nadiamel", "1234"));
        login.addAdmin(new Admin("Ali","AD01", "HR", "Management", "ali01", "5678"));
        
        //while user does not enter 3, program wont exit
        while (choice !=3 ) {
            System.out.println("----------------------------------------------------");
            System.out.println(" Employee's Leave Application System Main Interface ");
            System.out.println("----------------------------------------------------");
            System.out.println ("Please choose the following choices");
            System.out.println ("1) Staff Interface");
            System.out.println ("2) Admin Interface");
            System.out.println ("3) Exit");
            System.out.print("\nYour choice: ");
            choice=input.nextInt();
            input.nextLine();
            System.out.print("\n");
            
             switch (choice) {
                case 1:
                    Staff_login(login, input);
                    break;
                case 2:
                    Admin_login(login, input);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        input.close();
    }
    
    public static void Staff_login(Login_system login, Scanner input) {
        String username, password;
        
        System.out.print("Enter username: ");
        username = input.nextLine();
        System.out.print("Enter password: ");
        password = input.nextLine();
        
        if (login.staffLogin(username, password)) {
            System.out.println("Successfully login!");
            handleStaffInterface(login, input);
        }
        else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
    
    public static void Admin_login(Login_system login, Scanner input) {
        String username, password;
        
        System.out.print("Enter username: ");
        username = input.nextLine();
        System.out.print("Enter password: ");
        password = input.nextLine();
        
        if (login.adminLogin(username, password)) {
            System.out.println("Successfully login!");
            handleAdminInterface(login, input);
        }
        else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
    
    public static void handleStaffInterface(Login_system login, Scanner input) {
        int userChoice=0;
        boolean exitStaffInterface=false;
        
        
        while (!exitStaffInterface) {
            displayStaffMenu();
            userChoice=input.nextInt();
            input.nextLine();
            
            switch(userChoice) {
                case 1:
                    //To check if staff is login in
                    if (login.getStaffAccount() != null) {
                        makeLeaveApplication(login.getStaffAccount(), login.getAdminAccount(), input);
                    } 
                    else {
                        System.out.println("You need to login as staff first!");
                    }
                    break;
                
                case 2:
                    if (login.getStaffAccount() != null) {
                        viewApplicationStatus(login.getStaffAccount());
                    }
                    else {
                        System.out.println("You need to login as staff first!");
                    }
                    break;
                
                case 3:
                    exitStaffInterface=true;
                    System.out.println("Returning to the previous interface...");
                   break;
                   
                   default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void makeLeaveApplication(Staff staff, Admin admin, Scanner input) {
        System.out.println("\n");
        System.out.println(" -------------------------- ");
        System.out.println("   Make Leave Application   ");
        System.out.println(" -------------------------- ");
        System.out.println("  <<<<Application Info>>>> ");
        String app_date,app_time;
        
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        DateFormat timeFormat=new SimpleDateFormat("hh.mm aa");
        app_date=dateFormat.format(new Date()).toString();
        app_time=timeFormat.format(new Date()).toString();
        
        System.out.println("\n");
        System.out.println("Application Date: " +app_date);
        System.out.println("Application Time: " +app_time);
    
        System.out.print("Enter Duration (days): ");
        String duration = input.nextLine();
        
        System.out.print("Enter Reason for applying leave: ");
        String reason = input.nextLine();
        
        // Choose application type
        System.out.println("\n");
        System.out.println("Please select either one of the following types of application:");
        System.out.println("1) Medical leave application");
        System.out.println("2) Annual leave application");
        System.out.print("\nYour choice : ");
        int choice = input.nextInt();
        input.nextLine();
        System.out.println("\n");
        
        Application application;
        
        switch(choice) {
            case 1:
                System.out.print("Enter Medical Issue: ");
                String medicalIssue=input.nextLine();
                
                System.out.print("Enter Medical Certificate No.: ");
                String medicalCertNo=input.nextLine();
                
                application = new Medical_leave(Application.generateApplicationID(), app_date, app_time, duration, reason, medicalIssue, medicalCertNo);
                break;
            
            case 2:
                System.out.print("Enter Type of Leave: ");
                String typeOfLeave = input.nextLine();
            
                application = new Annual_leave(Application.generateApplicationID(), app_date, app_time, duration, reason, typeOfLeave);
                break;
                
                default:
                System.out.println("Invalid choice. Application type not recognized.");
                return;
        }
        
        // Assign the staff to the application
        application.setStaff(staff);
        //The application will be added to staff's list applications
        staff.addApplication(application);
        application.setStatus(0);
        application.aHandler(admin);
        // Add the application to the admin's list
        //admin.addApplication(application);
        System.out.println("\nLeave application submitted successfully.");
    }
    
     public static void viewApplicationStatus(Staff staff) {
        ArrayList<Application> application=staff.getApplications();
        
        if (application.isEmpty()) {
            System.out.println("You have no pending leave applications");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("               Application Status               ");
            for (Application app : application) {
                if (app.getStaff().equals(staff)) {
                    app.displayApplicationInfo();
                    System.out.println("Application ID: " + app.getApplicationID());
                    System.out.println("Application Date & Time: " + app.getApplicationDateTime());
                    System.out.println("Duration: " + app.getDuration() + " days");
                    //System.out.println("Status: " + Application.getStatusString(app.getStatus()));
                    System.out.println("------------------------------------------------");
                }
            }
        }
    }
    
    public static void handleAdminInterface(Login_system login, Scanner input) {
        int userChoice=0;
        boolean exitAdminInterface=false;
        
        while(!exitAdminInterface) {
            displayAdminMenu();
            userChoice=input.nextInt();
            input.nextLine();
            
            switch(userChoice) {
                case 1:
                    //To check if admin is login in
                    if (login.getAdminAccount() != null) {
                        processPendingApplications(login.getAdminAccount(), input);
                    }
                    else {
                        System.out.println("You need to login as admin first!");
                    }
                    break;
                
                case 2:
                    if (login.getAdminAccount() != null) {
                        viewProcessedApplications(login.getAdminAccount());
                    }
                    else {
                        System.out.println("You need to login as admin first!");
                    }
                    break;
                
                case 3:
                    exitAdminInterface=true;
                    System.out.println("Returning to the previous interface...");
                    break;
                    
                    default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void processPendingApplications(Admin admin, Scanner input){
        ArrayList<Application> applications = admin.getApplications();
        //int count = 0;
        
        if (applications.isEmpty()) {
            System.out.println("There are no pending leave applications.");
        }
        else {
            System.out.println("Pending Leave Applications:");
            for (Application app : applications) {
                if (app.getStatus() == 0) { // Pending status
                    System.out.println("Application ID: " + app.getApplicationID());
                    System.out.println("Applicant Name: " + app.getStaff().getStaff_name());
                    System.out.println("Application Date & Time: " + app.getApplicationDateTime());
                    System.out.println("Reason: " + app.getReason());
                    System.out.println("----------------------------------");

                    System.out.println("Approve? (Y/N)");
                    String choice = input.nextLine();

                    if (choice.equalsIgnoreCase("Y")) {
                        app.setStatus(1); // Set status as Approved
                        System.out.println("Application approved.");
                    } 
                    else {
                        app.setStatus(-1); // Set status as Rejected
                        System.out.println("Application rejected.");
                    }
                    
                    //count++;
                    admin.addApplication(app);
                }
            }
        }
    }
    
    public static void viewProcessedApplications(Admin admin) {
        ArrayList<Application> applications = admin.getApplications();

        if (applications.isEmpty()) {
            System.out.println("There are no processed leave applications.");
        } 
        else {
            System.out.println("Processed Leave Applications:");
        }
        
        admin.displayApplicationList();
    }
    
    
}
    