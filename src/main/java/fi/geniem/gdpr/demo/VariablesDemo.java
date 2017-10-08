package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.demo.subjects.ExtendedUserModel;
import fi.geniem.gdpr.demo.subjects.UserModel;
import fi.geniem.gdpr.personaldataflow.PersonalData;
import fi.geniem.gdpr.personaldataflow.PersonalDataEndpoint;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * This class produces warnings for different cases of
 * @PersonalData variables
 */
public class VariablesDemo {

    @PersonalData
    public static final String ANNOTATION_ON_VALUE = "demo";

    public static final UserModel VALUE_WITH_PERSONALDATA_CLASS = new UserModel();

    public static final String NO_WARNING = "demo";

    /**
     * Basic cases where a variable has personal data -- warnings for each
     */
    public void methodWithoutHandlerAnnotation(){
        UserModel model = new UserModel();
        Object genericType = new UserModel();// <-TODO
        ExtendedUserModel extendingPersonalData = new ExtendedUserModel();// <-TODO
        UserModel[] array = new UserModel[]{};// <-TODO
        List<UserModel> list = new ArrayList<UserModel>();// <-TODO
        ((UserModel) model).getIdentityNumber();// <-TODO
    }

    /**
     * @PersonalDataEndpoint should warn if it actually knows the types
     */
    @PersonalDataEndpoint
    public void methodWithEndpointAnnotation(){
        UserModel model = new UserModel();
        Object genericType = new UserModel();
        ExtendedUserModel extendingPersonalData = new ExtendedUserModel();
        UserModel[] array = new UserModel[]{};
        List<UserModel> list = new ArrayList<UserModel>();
        ((UserModel) model).getIdentityNumber();
    }

    /**
     * These cases would produce warnings, but the method is annotated
     */
    @PersonalDataHandler
    public void methodWithHandlerAnnotation(){
        UserModel model = new UserModel();
        Object genericType = new UserModel();
        ExtendedUserModel extendingPersonalData = new ExtendedUserModel();
        UserModel[] array = new UserModel[]{};
        List<UserModel> list = new ArrayList<UserModel>();
        ((UserModel) model).getIdentityNumber();
    }

    @PersonalDataHandler
    private class VariablesDemo2 {

        /**
         * These cases would produce warnings, but the class is annotated
         */
        public void methodWithoutHandlerAnnotation(){
            UserModel model = new UserModel();
            Object genericType = new UserModel();
            ExtendedUserModel extendingPersonalData = new ExtendedUserModel();
            UserModel[] array = new UserModel[]{};
            List<UserModel> list = new ArrayList<UserModel>();
            ((UserModel) model).getIdentityNumber();
        }

    }
}
