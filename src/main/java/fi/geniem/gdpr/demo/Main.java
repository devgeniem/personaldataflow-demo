package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.personaldataflow.PersonalData;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

public class Main {

	public static final String foo1 = "bar";
	
	@PersonalData
	public static final String foo2 = "bar";
	
	public static final PersonalDataModel foo3 = new PersonalDataModel();
	
	public static void main(String[] args){
		
		//WARN
		PersonalDataModel foo = new PersonalDataModel();
		
		//OK
		safeMethod(foo);

		//WARN
		unsafeMethod(foo);
	}
	
	
	private static void unsafeMethod(PersonalDataModel foo /*WARN */){
		
	}
	
	@PersonalDataHandler
	private static void safeMethod(PersonalDataModel foo /*OK*/){
		//OK
		PersonalDataModel bar = new PersonalDataModel();
		bar.getIdentityNumber();
	}
	
}
