package model;

public class Patient {

    private int patientId;
    private String name;
    private String dob;
    private String phone;
    private String email;
    private String address;
    private String bloodGroup;

    // Getters and setters
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getDob() { 
    	return dob; 
    }
    public void setDob(String dob) { 
    	this.dob = dob;
    }

    public String getPhone() { 
    	return phone; 
    }
    public void setPhone(String phone) { 
    	this.phone = phone; 
    }

    public String getEmail() { 
    	return email; 
    }
    public void setEmail(String email) { 
    	this.email = email; 
    }

    public String getAddress() { 
    	return address; 
    }
    public void setAddress(String address) { 
    	this.address = address; 
    }

    public String getBloodGroup() { 
    	return bloodGroup; 
    }
    public void setBloodGroup(String bloodGroup) { 
    	this.bloodGroup = bloodGroup; 
    }
}
