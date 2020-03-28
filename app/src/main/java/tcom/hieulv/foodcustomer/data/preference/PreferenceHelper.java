package tcom.hieulv.foodcustomer.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    public static final String KEY_TOKEN = "pref_token";
    public static final String KEY_TOKEN_EXPIRED = "pref_token_expired";
    private final static String PREF_FILE = "ISO_POS_PREF";
    private final SharedPreferences settings;
    private final SharedPreferences.Editor editor;
    private Context context;

    public PreferenceHelper(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(PREF_FILE, 0);
        editor = settings.edit();
    }

    /**
     * Set a string shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setSharedPreferenceString(String key, String value){
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Set a integer shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setSharedPreferenceInt(String key, int value){
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Set a Boolean shared preference
     * @param key - Key to set shared preference
     * @param value - Value for the key
     */
    public void setSharedPreferenceBoolean(String key, boolean value){
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Get a string shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public String getSharedPreferenceString(String key, String defValue){
        return settings.getString(key, defValue);
    }

    /**
     * Get a integer shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public int getSharedPreferenceInt(String key, int defValue){
        return settings.getInt(key, defValue);
    }

    /**
     * Get a boolean shared preference
     * @param key - Key to look up in shared preferences.
     * @param defValue - Default value to be returned if shared preference isn't found.
     * @return value - String containing value of the shared preference if found.
     */
    public boolean getSharedPreferenceBoolean(String key, boolean defValue){
        return settings.getBoolean(key, defValue);
    }

    public String getToken() {
        return settings.getString(KEY_TOKEN, "");
    }

    public void setToken(String token) {
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    public long getTokenExpired() {
        return settings.getLong(KEY_TOKEN_EXPIRED, 0L);
    }

    public void setTokenExpired(long tokenExpired) {
        editor.putLong(KEY_TOKEN_EXPIRED, tokenExpired);
        editor.apply();
    }

}
