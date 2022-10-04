
package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//... imports class definition...
public class Physician extends User implements HIPAACompliantUser{
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an ID
    public Physician(Integer id) {
    	super(id);
    }
//    Checks if Pin is Valid
    @Override
    public boolean assignPin(int pin) {
    	String str = Integer.toString(pin);
    	int size = str.length();
    	if(size != 4) {
    		return false;
    	}
    	return true;
    }
//    Checks if the access authorized is valid
    @Override
    public boolean accessAuthorized(Integer confirmedAurthID) {
    	if(id != confirmedAurthID) {
    		return false;
    	}
    	return true;
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }



	
    

}
