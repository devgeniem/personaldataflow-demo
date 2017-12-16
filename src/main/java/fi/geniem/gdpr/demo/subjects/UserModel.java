package fi.geniem.gdpr.demo.subjects;

import fi.geniem.gdpr.personaldataflow.PersonalData;

@PersonalData
public class UserModel {

	private String name;
	
	private String identityNumber;
	
	public UserModel innerUser;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public void processPersonalData(){

	};
}
