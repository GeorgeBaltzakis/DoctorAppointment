package com.example.doctorappointment.MainClasses;
public class Patient extends Users{

	private String name;	
	private String surname;
	private final long AMKA;

    // Constructor	
    public Patient(String email, String hashedpassword, String salt, String name, String surname, long AMKA) {
        super(email, hashedpassword, salt);
        setName(name);
        setSurname(surname);
        this.AMKA = AMKA;
    }
    public Patient() {
    	this.AMKA = -1;
    }

    //Getters and Setters
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
    public long getAMKA() {
        return AMKA;
    }
}
