package tcom.hieulv.foodcustomer.data.repository;

import tcom.hieulv.foodcustomer.data.AppRepository;
import tcom.hieulv.foodcustomer.data.preference.PreferenceHelper;

public class Home1Repository extends AppRepository {
    public Home1Repository(PreferenceHelper preferenceHelper) {
        super(preferenceHelper);
    }

    @Override
    public void logOut() {


    }

}
