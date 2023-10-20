public class Address{
    private String staff_street;
    private String staff_city;
    private String staff_state;

    //constructor
    Address (String staff_street, String staff_city, String staff_state){
        this.staff_street = staff_street;
        this.staff_city = staff_city;
        this.staff_state = staff_state;
    }

    //mutators : to set the value
    public void setAddress(String staff_street, String staff_city, String staff_state){
        this.staff_street = staff_street;
        this.staff_city = staff_city;
        this.staff_state = staff_state;
    }

    //accessors : to retrive/return value
    public String getAddress(){
        return staff_street + ", " + staff_city + ", " + staff_state;
    }
}