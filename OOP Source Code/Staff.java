import java.util.ArrayList;
public class Staff {
    private String staff_name, staff_IcNo, staff_gender, staff_phoneNo, staff_email, staff_job;
    private String username, password;
    private Address staff_address;
    private ArrayList<Application> applications;
    
    public Staff (){
        applications = new ArrayList<>();
    }
    
    //Constructor
    public Staff (String staff_name, String staff_IcNo, String staff_phoneNo, String staff_gender, String staff_email, String staff_job, Address staff_address, String username, String password){
        this.staff_name = staff_name;
        this.staff_IcNo = staff_IcNo;
        this.staff_phoneNo = staff_phoneNo;
        this.staff_gender = staff_gender;
        this.staff_email = staff_email;
        this.staff_job = staff_job;
        this.staff_address = staff_address;
        this.username = username;
        this.password = password;
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }
    
    public void addApplication(Application application) {
        if (applications == null) {
            applications = new ArrayList<>();
        }
        applications.add(application);
    }
    
    //mutators : to set the value
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    //mutators : to set the value
    public void setStaff_IcNo(String staff_IcNo) {
        this.staff_IcNo = staff_IcNo;
    }

    //mutators : to set the value
    public void setStaff_phoneNo(String staff_phoneNo) {
        this.staff_phoneNo = staff_phoneNo;
    }

    //mutators : to set the value
    public void setStaff_email(String staff_email) {
        this.staff_email = staff_email;
    }

    //mutators : to set the value
    public void setStaff_job(String staff_job) {
        this.staff_job = staff_job;
    }
    
    //mutators : to set the value
    public void setStaff_address(Address staff_address) {
        this.staff_address = staff_address;
    }

    //mutators : to set the value
    public void setStaff_gender(String staff_gender){
        if (staff_gender.toUpperCase().equals("M"))
        {
            this.staff_gender="Male";
        }
        else if (staff_gender.toUpperCase().equals("F"))
        {
            this.staff_gender="Female";
        }
    }

    //accessors : to retrive/return value
    public String getStaff_name() {
        return staff_name;
    }

    public String getStaff_IcNo() 
    { 
        return staff_IcNo; 
    }

    public String getStaff_phoneNo() {
        return staff_phoneNo;
    }

    public String getStaff_email() {
        return staff_email;
    }

    public String getStaff_job() {
        return staff_job;
    }
    
    public String getStaff_address() {
        return staff_address.getAddress();
    }

    public String getStaff_gender() {
        return staff_gender;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
