package co.haptik.permissions.lib;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raveesh on 14/10/15.
 */
public class Permissions {

    /**
     * Returns whether or not an app has been granted a particular permission
     *
     * @param context    Context of the app
     * @param permission Permission to search for
     * @return True if permission has been granted, false if not
     */
    public static boolean havePermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED ? true : false;
    }

    /**
     * Requests permissions as required. If a permission is already granted, it is not requested
     *
     * @param activity    Activity requesting permission
     * @param permissions Permissions to be requested
     * @param requestCode Request code
     * @return Permissions that are requested, with those granted removed from request
     */
    public static String[] requestPermissions(Activity activity, String[] permissions, int requestCode) {
        List<String> finalPermissions = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (!havePermission(activity, permissions[i])) {
                finalPermissions.add(permissions[i]);
            }
        }
        String[] finalArray = Arrays.copyOf(finalPermissions.toArray(), finalPermissions.size(), String[].class);
        if (finalArray.length > 0) {
            /**
             * If length is 0, the request would crash
             */
            ActivityCompat.requestPermissions(activity, finalArray, requestCode);
        }
        return finalArray;
    }

    /**
     * Request a single permission. Does so only if not only granted to save you the hassle
     *
     * @param activity Activty requesting permission
     * @param permission Permission string
     * @param requestCode Request code
     * @return True if request is made, false if not (in case permission is already granted)
     */
    public static boolean requestPermission(Activity activity, String permission, int requestCode){
        String[] permissions = requestPermissions(activity, new String[]{permission}, requestCode);
        if (permissions.length > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
