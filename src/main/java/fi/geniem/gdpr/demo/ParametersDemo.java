package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.demo.subjects.UserModel;
import fi.geniem.gdpr.personaldataflow.PersonalDataEndpoint;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;
import java.util.List;

public class ParametersDemo {

    // This will warn.
    public void methodWithNoAnnotations(UserModel model, String okParam){
        model.getIdentityNumber();
    }

    // This will warn.
    public void methodWithNoAnnotations2(List<UserModel> models){

    }

    // This will warn.
    @PersonalDataEndpoint
    public void methodWithEndpoint(UserModel model){
        model.getIdentityNumber();
    }

    // This will warn.
    public void methodWithNoAnnotations3(UserModel[] models, String okParam){
    }

    // This is fine.
    @PersonalDataHandler
    public void methodWithHandler(UserModel model){
        model.getIdentityNumber();
    }

    //This is fine -- class has @PersonalDataHandler annotation.
    @PersonalDataHandler
    private class PersonalDataHandlerClass {
        public void methodWithNoAnnotations(UserModel model){
            model.getIdentityNumber();
        }
    }

}
