package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.demo.subjects.ServiceWithPersonalDataHandler;
import fi.geniem.gdpr.demo.subjects.ServiceWithoutPersonalDataHandler;
import fi.geniem.gdpr.demo.subjects.UserModel;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

/**
 * This class produces warnings for different cases of
 * @PersonalData method calls
 */
public class MethodsDemo {

    /**
     * This method has @PersonalDataHandler,
     * but it is still not allowed to call other unsafe methods
     */
    @PersonalDataHandler
    public void demoMethodCallWarnings(){
        UserModel model = new UserModel();

        /*
         *  No warnings for method calls below:
         */
        methodWithPersonalDataHandler(model);
        new ServiceWithPersonalDataHandler().methodWithNoAnnotations(model);
        new ServiceWithoutPersonalDataHandler().methodWithHandlerAnnotation(model);
        new ServiceWithoutPersonalDataHandler().methodWithEndpointAnnotation(model);

        /*
         *  All of these should warn:
         */
        methodWithNoAnnotations(model);
        methodWithNoAnnotations(new UserModel());// <-TODO
        new ServiceWithoutPersonalDataHandler().methodWithNoAnnotations(model);
    }

	private static void methodWithNoAnnotations(Object object){
        object.toString();
	}
	
	@PersonalDataHandler
	private static void methodWithPersonalDataHandler(UserModel paramInSafe){
        paramInSafe.getIdentityNumber();
	}
	
}
