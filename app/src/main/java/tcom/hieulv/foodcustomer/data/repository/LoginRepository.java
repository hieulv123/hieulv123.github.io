package tcom.hieulv.foodcustomer.data.repository;

import tcom.hieulv.foodcustomer.data.AppRepository;
import tcom.hieulv.foodcustomer.data.preference.PreferenceHelper;

public class LoginRepository extends AppRepository {
    public LoginRepository(PreferenceHelper preferenceHelper) {
        super(preferenceHelper);
    }

    @Override
    public void logOut() {

    }
}
