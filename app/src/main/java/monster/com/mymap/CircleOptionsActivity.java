package monster.com.mymap;

import android.graphics.Color;
import android.os.Bundle;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;

/**
 * Created by ASUS on 2017/3/2.
 */

public class CircleOptionsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CircleOptions options = new CircleOptions();
        options.center(contry).radius(5000).stroke(new Stroke(20,0x55FF0000)).fillColor(Color.BLUE);
        map.addOverlay(options);
    }
}

