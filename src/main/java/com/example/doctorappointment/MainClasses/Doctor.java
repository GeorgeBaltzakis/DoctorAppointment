package com.example.doctorappointment.MainClasses;
public class Doctor extends Users{

	private String name;
    private String surname;
    private int adminUserId;
    private final long AMKA;
    private String specialty;
    

    // Constructor
    public Doctor(String username, String hashedpassword, String salt, String name, String surname, int adminUserId, long AMKA,String specialty) {
        super(username, hashedpassword, salt);
        setName(name);
        setSurname(surname);
        setAdminUserId(adminUserId);
        setSpecialty(specialty);
        this.AMKA = AMKA;
    }
    public Doctor() {
    	this.AMKA = -1;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(int adminUserId) {
        this.adminUserId = adminUserId;
    }

    public long getAMKA() {
        return AMKA;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    // Methods
    void emptyDaysOfMonths(){
        System.out.println("Doctor: enter Empty Days of Months called");
    }

    void printAppointments(){
        System.out.println("Doctor: print Appointments called");
    }

}
