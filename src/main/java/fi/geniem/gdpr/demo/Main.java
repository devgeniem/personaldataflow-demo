package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.personaldataflow.PersonalData;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

public class Main {

	public static final String foo1 = "bar";
	
	@PersonalData
	public static final String foo2 = "bar";
	
	public static void main(String[] args){
		
		//WARN: personalData in unsafe method
		PersonalDataModel foo = new PersonalDataModel();
		
		//OK
		safeMethod(foo);

		unsafeMethod(foo);
	}
	
	
	private static void unsafeMethod(PersonalDataModel foo /*WARN: personalData parameter in unsafe */){
		
	}
	
	@PersonalDataHandler
	private static void safeMethod(PersonalDataModel foo){
		
		//OK
		PersonalDataModel bar = new PersonalDataModel();
		
		bar.getIdentityNumber();
	}
	
}
