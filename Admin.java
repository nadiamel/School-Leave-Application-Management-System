import java.util.ArrayList;

public class Admin {
    private String admin_name, admin_ID, admin_position, admin_department;
    private String username, password;
    private ArrayList<Application> applications;

    public Admin (String admin_name, String admin_ID, String admin_position, String admin_department, String username, String password){
        this.admin_name = admin_name;
        this.admin_ID = admin_ID;
        this.admin_position = admin_position;
        this.admin_department = admin_department;
        applications = new ArrayList<Application>();
        this.username = username;
        this.password = password;
    }

    //accessors : to retrive/return value
    public String getAdmin_name() {
        return admin_name;
    }
    
    //accessors : to retrive/return value
    public String getAdmin_ID() {
        return admin_ID;
    }

    //accessors : to retrive/return value
    public String getAdmin_position() {
        return admin_position;
    }

    //accessors : to retrive/return value
    public String getAdmin_department() {
        return admin_department;
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    //method that can add application
    public void addApplication(Application application){
        applications.add(application);
    }

    //method to display the list
    public void displayApplicationList(){
        System.out.println ("Admin name: " + admin_name);
        System.out.println ("Admin ID: " + admin_ID);
        System.out.println ("Admin position: "+ admin_position);
        System.out.println ("Admin department: "+ admin_department + "\n");
        
        if (applications.size()==0)
        {
            System.out.println("There is no applications processed by you...");
        }
        
        else
        {
            System.out.printf("%-5s%-20s%-20s%-30s%-20s%-30s%-30s%-10s%n","No.","Name","IC No","App Type","App ID","Purpose","App Date Time","Status");

            String status="";
            String application_type="";
            
            for (int i = 0; i<applications.size(); i++){
                
                switch ((applications.get(i)).getStatus())
                {
                    case -1: status="Rejected";
                        break;
                    case 0: status="Pending";
                        break;
                    case 1: status="Approved";
                        break;
                }
                
                //to checks if the object at index i is 
                //an instance of the Medical_leave class or any of its subclasses
                if (applications.get(i) instanceof Medical_leave)
                {
                    application_type="Medical Leave";
                }
                else
                {
                    application_type="Annual Leave";
                }
            
                System.out.printf("%-5d%-20s%-20s%-30s%-20s%-30s%-30s%-10s%n",(i+1),((applications.get(i)).getStaff()).getStaff_name(),
                ((applications.get(i)).getStaff()).getStaff_IcNo(),
                application_type,(applications.get(i)).getApplicationID(),
                (applications.get(i)).getReason(),(applications.get(i)).getApplicationDateTime(),status);
            }
        }
    }
}
