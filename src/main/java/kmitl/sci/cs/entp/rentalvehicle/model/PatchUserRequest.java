package kmitl.sci.cs.entp.rentalvehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchUserRequest {

	@JsonProperty("first_name")
	private String firstname;
	@JsonProperty("last_name")
	private String lastname;
	private String email;

	public PatchUserRequest(){
        
    }
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}