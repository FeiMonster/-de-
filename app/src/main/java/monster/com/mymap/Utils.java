package monster.com.mymap;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ASUS on 2017/3/2.
 */
public class Utils {
    public static void showToast(Context context, CharSequence text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }
}
