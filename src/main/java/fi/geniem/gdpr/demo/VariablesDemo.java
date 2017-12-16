package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.demo.subjects.ExtendedUserModel;
import fi.geniem.gdpr.demo.subjects.InterfaceImpl;
import fi.geniem.gdpr.demo.subjects.InterfaceWithPersonalData;
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

    /*
     * Static variables get warnings (no @PersonalDataHandler on class)
     */
    @PersonalData
    public static final String ANNOTATION_ON_VALUE = "demo";
    public static final UserModel VALUE_WITH_PERSONALDATA_CLASS = new UserModel();
    public static final List<UserModel> VALUE_WITH_PERSONALDATA_LIST = new ArrayList<UserModel>();
    public static final UserModel[] VALUE_WITH_PERSONALDATA_ARRAY = new UserModel[]{};

    public static final String NO_WARNING = "demo";

    /**
     * Basic cases where a variable has personal data -- warnings for each
     */
    public void methodWithoutHandlerAnnotation(){
        UserModel model = new UserModel();
        Object genericType = new UserModel();
        ExtendedUserModel extendingPersonalData = new ExtendedUserModel();
        ExtendedUserModel[] extendingPersonalDataArray = new ExtendedUserModel[]{};
        UserModel[] array = new UserModel[]{};
        List<UserModel> list = new ArrayList<>();
        ((UserModel) genericType).processPersonalData();

        //no warning: annotations are not inherited from interfaces
        InterfaceImpl implementsPersonalDataInterface = new InterfaceImpl();
    }

    /**
     * @PersonalDataEndpoint should warn if it actually uses the types
     */
    @PersonalDataEndpoint
    public void methodWithEndpointAnnotation(){
        UserModel model = new UserModel();
        Object genericType = new UserModel();
        ExtendedUserModel extendingPersonalData = new ExtendedUserModel();
        UserModel[] array = new UserModel[]{};
        List<UserModel> list = new ArrayList<UserModel>();
        ((UserModel) genericType).processPersonalData();

        //no warning
        InterfaceImpl implementsPersonalDataInterface = new InterfaceImpl();
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
        List<UserModel> list = new ArrayList<>();
        ((UserModel) genericType).processPersonalData();
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
            InterfaceImpl implementsPersonalDataInterface = new InterfaceImpl();
            UserModel[] array = new UserModel[]{};
            List<UserModel> list = new ArrayList<UserModel>();
            ((UserModel) genericType).processPersonalData();
        }
    }
}
