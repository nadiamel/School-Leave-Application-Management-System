public class Medical_leave extends Application{
    private String medical;
    private String med_cert_no;
    
    //constructor
    public Medical_leave(String applicationID, String app_date, String app_time, String duration, String reason, String medicalIssue, String medicalCertNo){
        super(app_date, app_time, duration, reason);
        this.applicationID = generateApplicationID();
        this.medical=medicalIssue;
        this.med_cert_no=medicalCertNo;
    }
    
    public String getMedical(){
        return medical;
    }
    
    public String getMed_cert_no(){
        return med_cert_no;
    }
    
    public void displayApplicationInfo(){
        System.out.println("------------------------------------------------");
        System.out.println("            Medical Leave Application            ");
        System.out.println("------------------------------------------------");
        
        System.out.println("Name: "+staff.getStaff_name());
        System.out.println("IC No: "+staff.getStaff_IcNo());
        System.out.println("Address: "+staff.getStaff_address());
        System.out.println("Gender: "+staff.getStaff_gender());
        System.out.println("Phone No: "+staff.getStaff_phoneNo());
        System.out.println("Email: "+staff.getStaff_email());
        System.out.println("Job: "+staff.getStaff_job());
        System.out.println("Medical Issue: "+getMedical()+"\tMedical Certification No.: "+getMed_cert_no());
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

            System.out.println("\nProcessed by: "+handler.getAdmin_name());
            System.out.println("\nPosition:  "+handler.getAdmin_position());
            System.out.println("\nDepartment: "+handler.getAdmin_department());
        }

    }
    
    /*public String getStatusString() {
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
        */
    
}