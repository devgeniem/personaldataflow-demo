package fi.geniem.gdpr.demo.subjects;

import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

@PersonalDataHandler
public class ServiceWithPersonalDataHandler {

	public void methodWithNoAnnotations(Object ok){
		ok.toString();
	}
}
