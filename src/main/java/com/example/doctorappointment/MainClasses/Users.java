package com.example.doctorappointment.MainClasses;
public class Users {

    private String email;
    private String hashedpassword;
    private String salt;    

    public Users(String email, String password, String salt) {
        setEmail(email);
        setHashedPassword(password);
        setSalt(salt);
    }
    public Users() {}

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedpassword;
    }

    public void setHashedPassword(String password) {
        this.hashedpassword = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String name) {
        this.salt = name;
    }       

    // Methods
    void logIn(){
        System.out.println("Login called");
    }

    void logOut(){
        System.out.println("Logout called");
    }
}
