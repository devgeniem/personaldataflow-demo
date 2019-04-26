package fi.geniem.gdpr.demo;

import fi.geniem.gdpr.demo.subjects.ExtendedUserModel;
import fi.geniem.gdpr.demo.subjects.UserModel;
import fi.geniem.gdpr.personaldataflow.PersonalDataHandler;
import fi.geniem.gdpr.personaldataflow.PersonalDataEndpoint;
import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    @PersonalDataHandler
    public void demo() {
        UserModel m = new UserModel();
        saveToDatabase(m);
        endpointSaveToDatabase(m);

        List<ExtendedUserModel> models = new ArrayList<>();
        models = genericListMethod(models);
        models = genericPersonalDataListMethod(models);

        UserModel model = get("id", UserModel.class);

        UserModel model2 = endpointGet("id", UserModel.class);
    }

    public void saveToDatabase(Object model) {

    }

    @PersonalDataEndpoint
    public void endpointSaveToDatabase(Object model) {

    }

    public <T> List<T> genericListMethod(List<T> models) {
        return models;
    }

    @PersonalDataEndpoint
    public <T extends ExtendedUserModel> List<T> genericPersonalDataListMethod(List<T> models) {
        return models;
    }

    public <T> T get(String id, Class<T> clazz) {
        return null;
    }

    @PersonalDataEndpoint
    public <T> T endpointGet(String id, Class<T> clazz) {
        return null;
    }
}
