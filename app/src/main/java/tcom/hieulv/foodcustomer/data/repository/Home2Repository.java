package tcom.hieulv.foodcustomer.data.repository;

import tcom.hieulv.foodcustomer.data.AppRepository;
import tcom.hieulv.foodcustomer.data.preference.PreferenceHelper;

public class Home2Repository extends AppRepository {
    public Home2Repository(PreferenceHelper preferenceHelper) {
        super(preferenceHelper);
    }

    @Override
    public void logOut() {

    }
}
