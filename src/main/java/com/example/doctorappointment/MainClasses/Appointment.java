package com.example.doctorappointment.MainClasses;
public class Appointment {

	private String date;
	private String startTime;
	private String endTime;	
    private long patientAMKA;
    private long doctorAMKA;
    private int isAvailable;

    // Constructor
    public Appointment(String date, String startTime, String endTime, long patientAMKA, long doctorAMKA, int isAvailable) {
        setDate(date);
        setStartTime(startTime);
        setEndTime(endTime);
        setPatientAMKA(patientAMKA);
        setDoctorAMKA(doctorAMKA);
        setAvailable(isAvailable);    
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getPatientAMKA() {
        return patientAMKA;
    }

    public void setPatientAMKA(long patientAMKA) {
        this.patientAMKA = patientAMKA;
    }

    public long getDoctorAMKA() {
        return doctorAMKA;
    }

    public void setDoctorAMKA(long doctorAMKA) {
        this.doctorAMKA = doctorAMKA;
    }

    public int isAvailable() {
        return isAvailable;
    }

    public void setAvailable(int available) {
        isAvailable = available;
    }
  

    // Methods
    void printAppointment(){
        System.out.println("Appointment print_Appointment called");
    }
}
