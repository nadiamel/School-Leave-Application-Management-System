public abstract class Application{
    private static int nextApplicationID=1;
    
    protected Staff staff;
    protected Admin handler;
    protected String applicationID;
    protected String application_date;
    protected String application_time;
    protected String duration;
    protected String reason;
    protected int status;
    
    Application(String application_date, String application_time, String duration, String reason){
        this.applicationID = generateApplicationID(); //calling the method of generateApplicationID()
        this.application_date = application_date;
        this.application_time = application_time;
        this.duration = duration;
        this.reason = reason;
        this.status=0;
    }
    
    public static String generateApplicationID() {
        String applicationID="APP" + String.format("%04d", nextApplicationID);
        nextApplicationID++; //for increment the ID
        return applicationID;
    }
    
    public void aHandler(Admin handler){
        this.handler = handler;
    }
        
    public Staff getStaff()
    {
        return staff;
    }
    
    public String getApplicationID () {
        return applicationID;
    }
    
    public String getApplicationDateTime(){
        return application_date+", "+application_time;
    }

    public String getDuration(){
        return duration;
    }
    
    public String getReason(){
        return reason;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public static String getStatusString(int status) {
        if (status == 1) {
            return "Approved";
        } else if (status == -1) {
            return "Rejected";
        } else {
            return "Pending";
        }
    }
    

    public void setStaff(Staff staff){ 
        this.staff = staff; 
    }
    
    public void setStatus(int status){
        this.status=status;
    }
    
    public abstract void displayApplicationInfo();
    
    /*public static String getStatusString(int status) {
        String statusString;
        switch (status) {
            case -1:
                statusString = "Pending";
                break;
            case 0:
                statusString = "Approved";
                break;
            case 1:
                statusString = "Rejected";
                break;
            default:
                statusString = "Unknown";
                break;
        }
        return statusString;
    }*/
}