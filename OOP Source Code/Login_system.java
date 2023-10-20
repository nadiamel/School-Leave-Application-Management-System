import java.util.ArrayList;
public class Login_system
{
    private ArrayList<Staff> staff_list;
    private ArrayList<Admin> admin_list;
    private Staff logStaff;
    private Admin logAdmin;
    
    public Login_system() {
        staff_list = new ArrayList<>();
        admin_list = new ArrayList<>();
        //initializes it to null 
        //as it indicate that no staff account is currently logged in
        this.logStaff=null;
        this.logAdmin=null;
    }
    
    public boolean staffLogin(String username, String password) {
        //Perform staff login verification 
        //to check whether username and password match with current login account
        for (Staff staff : staff_list) {
            if (staff.getUsername().equals(username) && staff.getPassword().equals(password)) {
                logStaff=staff;
                return true;
            }
        }
        return false;
    }
    
    public boolean adminLogin(String username, String password) {
        //Perform staff login verification 
        //to check whether username and password match with current login account
        for (Admin admin : admin_list) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                logAdmin=admin;
                return true;
            }
        }
        return false;
    }
    
    public Staff getStaffAccount() {
        return logStaff;
    }
    
    public Admin getAdminAccount() {
        return logAdmin;
    }
    
    public void addStaff(Staff staff) {
        staff_list.add(staff);
    }
    
    public void addAdmin(Admin admin) {
        admin_list.add(admin);
    }
    
    public Admin getAdminByUsername(String username) {
        for (Admin admin : admin_list) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        
        }
        return null;
    }
    
    public void setAdminAccount(Admin admin) {
        logAdmin = admin;
    }
}
