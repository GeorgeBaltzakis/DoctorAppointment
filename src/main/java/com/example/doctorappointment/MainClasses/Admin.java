package com.example.doctorappointment.MainClasses;
public class Admin extends Users{

	private int userid;
    
	// Constructor
    public Admin(String username, String hashedpassword, String salt, int userid) {
        super(username, hashedpassword, salt);  
        setUserid(userid);
    }
    public Admin() {}

    // Getters and Setters
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    /*// Pass Certification
    private void passCertification(String pass){
        if (!pass.equals(adminPass)) {
            System.out.println("Admin: Wrong Pass");
        } else {
            System.out.println("Admin: Correct pass");
        }
    }

    // Methods
    void createDoctors(){
        System.out.println("Admin: create Doctors called");
    }*/
}
