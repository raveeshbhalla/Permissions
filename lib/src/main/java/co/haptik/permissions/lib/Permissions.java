package co.haptik.permissions.lib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by Raveesh on 14/10/15.
 */
public class Permissions {

    /**
     * Returns whether or not an app has been granted a particular permission
     * @param context Context of the app
     * @param permission Permission to search for
     * @return True if permission has been granted, false if not
     */
    public static boolean havePermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED ? true : false;
    }
}
