package fi.geniem.gdpr.demo.subjects;

import fi.geniem.gdpr.personaldataflow.PersonalData;

/**
 * No warning for constructing this class -- personal data can contain personal data
 */
@PersonalData
public class WrappedPersonalData {

	private UserModel data;

	public WrappedPersonalData(UserModel data){
		this.data = data;
	}

}
