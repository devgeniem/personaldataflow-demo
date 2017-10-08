package fi.geniem.gdpr.demo.subjects;

import fi.geniem.gdpr.personaldataflow.PersonalDataEndpoint;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

public class ServiceWithoutPersonalDataHandler {

	public void methodWithNoAnnotations(Object ob){
	    ob.toString();
	}

	@PersonalDataHandler
	public void methodWithHandlerAnnotation(Object ob){
	    ob.toString();
    };

    @PersonalDataEndpoint
    public void methodWithEndpointAnnotation(Object ob){
        ob.toString();
    };
}
