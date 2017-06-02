package fi.geniem.gdpr.demo;

import java.util.ArrayList;
import java.util.List;

import fi.geniem.gdpr.personaldataflow.PersonalData;
import fi.geniem.gdpr.personaldataflow.PersonalDataEndpoint;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

public class Main {

	@PersonalData
	public static final String foo1 = "as";
		
	public static final UserModel foo2 = new UserModel();
	
	//TODO: warn
	public static final UserModel[] foo3 = new UserModel[]{};
	
	//TODO: warn
	public static final List<UserModel> foo4 = new ArrayList<UserModel>();
	
	public static final String safe = "ok";
	
	public static void main(String[] args){
		
		UserModel personalDataObject = new UserModel();
				
		safeMethod(personalDataObject);
		unsafeMethod(personalDataObject);
		
		genericUnsafeMethod(personalDataObject);
		genericUnsafeMethod(new UserModel());
		genericUnsafeMethod("this is ok");
		
		new SafeHandlerService().thisIsSafe(personalDataObject);
		new UnsafeHandlerService().thisShouldWarn(personalDataObject);
		
		saveToDatabase(personalDataObject);
		saveToDatabase2(personalDataObject);
	}
	
	
	private static void unsafeMethod(UserModel unsafeParam){
		unsafeParam.getIdentityNumber();
	}
	
	private static void genericUnsafeMethod(Object object){
		object.toString();
	}
	
	@PersonalDataHandler
	private static void safeMethod(UserModel paramInSafe){
		UserModel bar = new UserModel();
		bar.getIdentityNumber();
	}
	
	@PersonalDataEndpoint
	public static void saveToDatabase(Object obj){
		obj.toString();
	}
	
	@PersonalDataEndpoint
	public static void saveToDatabase2(UserModel notAllowed){
	}
	
}
