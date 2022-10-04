package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//... imports class definition...
    
public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{
    // Inside class:
	
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents= new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.role = role;
    }
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
//	to check the how many security incidents
    
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	
    	return this.getSecurityIncidents();
    }
    
//    to check the authorizer
    
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id != confirmedAuthID) {
			authIncident();
    		return false;
    	}
    	return true;
	}
//	to check the pin and if it is valid
    
	@Override
	public boolean assignPin(int pin) {
		String str = Integer.toString(pin);
    	int size = str.length();
    	if(size >= 6) {
    		return true;
    	}
    	return false;
	}
    
    // TO DO: Setters & Getters

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}