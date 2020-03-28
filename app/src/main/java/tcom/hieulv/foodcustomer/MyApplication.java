package tcom.hieulv.foodcustomer;

import android.app.Application;
import android.util.DisplayMetrics;

import tcom.hieulv.foodcustomer.data.AppRepository;
import tcom.hieulv.foodcustomer.data.preference.PreferenceHelper;
import tcom.hieulv.foodcustomer.data.repository.Home1Repository;
import tcom.hieulv.foodcustomer.data.repository.Home2Repository;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;

public class MyApplication extends Application {
    public static String BASE_URL = "http://demo-food.sky-demo.net/api/app/";
    public static String LOGO_URL;
    public static String BASE_IMAGE_URL;
    private static MyApplication instance = null;
    public int screenWidthInPx;
    public int screenHeightInPx;
    private static AppRepository appRepository;
    private PreferenceHelper preferenceHelper;
    private Home1Repository home1Repository;

    public Home2Repository getHome2Repository() {
        return home2Repository;
    }

    private Home2Repository home2Repository;

    public Home1Repository getHome1Repository() {

        return home1Repository;
    }

    private LoginRepository loginRepository;


    public static MyApplication getInstance() {
        return instance;
    }

    public int screenHeightInDp;
    public int screenWidthInDp;
    public float screenDensity;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenDensity = displayMetrics.density;
        screenWidthInPx = displayMetrics.widthPixels;
        screenHeightInPx = displayMetrics.heightPixels;
        screenWidthInDp = (int) (displayMetrics.widthPixels / displayMetrics.density);
        screenHeightInDp = (int) (displayMetrics.heightPixels / displayMetrics.density);
        preferenceHelper = new PreferenceHelper(this);
        loginRepository = new LoginRepository(preferenceHelper);
        home1Repository = new Home1Repository(preferenceHelper);

    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    public void setLoginRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public AppRepository getAppRepository() {
        return appRepository;
    }

    public void setHome1Repository(Home1Repository home1Repository) {
        this.home1Repository = home1Repository;
    }
}
