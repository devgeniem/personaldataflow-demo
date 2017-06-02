package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

@PersonalDataHandler
public class SafeHandlerService {

	public void thisIsSafe(Object ok){
		ok.toString();
	}
}
