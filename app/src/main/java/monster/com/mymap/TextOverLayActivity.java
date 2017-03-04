package monster.com.mymap;

import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextOptions;

/**
 * Created by ASUS on 2017/3/3.
 */

public class TextOverLayActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextOptions options = new TextOptions();
        options.position(contry).text("我是飞哥的家乡").fontSize(50).fontColor(0XFF000000).bgColor(0X55FF0000).rotate(30);
        //postion:位置  text:文本  fontSize：文字大小  fonColor：文本颜色 bgColor:背景颜色  rptate:旋转角度
        map.addOverlay(options);
    }
}
