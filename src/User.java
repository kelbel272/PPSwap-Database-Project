

public class User {
    protected int id;
    protected String userID;
    protected String password;
    protected String fname;
    protected String lname;
    protected String birthdate;
    protected String street;
    protected String unit;
    protected String city;
    protected String state;
    protected String zipcode;
    public boolean valid;
 
    public User() {
    }
 
    public User(int id) {
        this.id = id;
    }
 
    public User(int id, String userID, String password, String fname, String lname, String birthdate, String street, String unit, String city, String state, String zipcode) {
        this(userID, password, fname, lname, birthdate, street, unit, city, state, zipcode);
        this.id = id;
    }
     
    public User(String userID, String password, String fname, String lname, String birthdate, String street, String unit, String city, String state, String zipcode) {
        this.userID = userID;
        this.password = password;
    	this.fname = fname;
        this.lname = lname;
        this.birthdate = birthdate;
        this.street = street;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserID() {
    	return userID;
    }
    
    public void setUserID(String userID) {
    	this.userID = userID;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
 
    public String getFirstName() {
        return fname;
    }
 
    public void setFirstName(String fname) {
        this.fname = fname;
    }
    
    public String getLastName() {
        return lname;
    }
 
    public void setLastName(String lname) {
        this.lname = lname;
    }
    
    public String getBirthdate() {
        return fname;
    }
 
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void getStreet(String street) {
        this.street = street;
    }
 
    public String getUnit() {
        return unit;
    }
    
    public void getUnit(String unit) {
        this.unit = unit;
    }
 
    public String getCity() {
        return city;
    }
    
    public void getCity(String city) {
        this.city = city;
    }
 
    public String getState() {
        return state;
    }
    
    public void getState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return city;
    }
    
    public void getZip(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public boolean isValid() {
    	return valid;
    }
    
    public void setValid(boolean valid) {
    	this.valid = valid;
    }
}
    
    