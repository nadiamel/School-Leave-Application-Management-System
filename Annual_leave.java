public class Annual_leave extends Application{
    private String type_leave;
    
    public Annual_leave(String applicationID, String app_date, String app_time, String duration, String reason, String typeOfLeave){
        super(app_date, app_time, duration, reason);
        this.applicationID = generateApplicationID();
        this.type_leave = typeOfLeave;
        status=0;
    }
    
    public String getTypeleave(){
        return type_leave;
    }

    public void displayApplicationInfo(){
        System.out.println("\n------------------------------------- ");
        System.out.println("        Annual Leave Application      ");
        System.out.println(" ------------------------------------- ");
        
        System.out.println("Name: "+staff.getStaff_name());
        System.out.println("ICNo: "+staff.getStaff_IcNo());
        System.out.println("Address: "+staff.getStaff_address());
        System.out.println("Gender: "+staff.getStaff_gender()+"\t\t\tPhone No: "+staff.getStaff_phoneNo());
        System.out.println("Email: "+staff.getStaff_email()+"\t\t\tJob: "+staff.getStaff_job());
        System.out.println("Application ID: "+applicationID);
        System.out.println("Application Date & Time: "+getApplicationDateTime());
        System.out.println("Type of Leave: "+getTypeleave());
        System.out.println("Reason: "+getReason());
        String app_status="";
               
        switch (getStatus())
        {
            case -1: app_status="Rejected";
                     break;
                     
            case 0: app_status="Pending";
                    break;
            
            case 1: app_status="Approved";
                    break;
        }
        
        System.out.println("\nStatus: "+app_status);
        
        if (!app_status.equals("Pending"))
        {
            System.out.println("\nProcessed by "+handler.getAdmin_name());
            System.out.println("\nPosition: "+handler.getAdmin_position());
            System.out.println("\nDepartment: "+handler.getAdmin_department());
        }
    }
    
    public String getStatusString() {
        String statusString;
        switch (getStatus()) {
            case -1:
                statusString = "Rejected";
                break;
            case 0:
                statusString = "Pending";
                break;
            case 1:
                statusString = "Approved";
                break;
            default:
                statusString = "Unknown";
                break;
        }
        return statusString;
    }
}