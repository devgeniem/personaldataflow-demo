package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.personaldataflow.PersonalData;

@PersonalData
public class PersonalDataModel {

	private String name;
	
	private String identityNumber;
	
	public int foo = 0;
	
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
	
}
