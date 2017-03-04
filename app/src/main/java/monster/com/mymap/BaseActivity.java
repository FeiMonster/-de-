package monster.com.mymap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

/**
 * Created by ASUS on 2017/3/1.
 */

public class BaseActivity extends Activity {
    protected BaiduMap map ;
    protected LatLng contry = new LatLng(20.5493610000,109.8705030000);
    protected MapView mMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.bmapView);
         map = mMapView.getMap();//得到地图管理器
//        mMapView.showScaleControl(false);
//        mMapView.showZoomControls(false);
        float maxZoomLevel = map.getMaxZoomLevel();
        Log.e("tag","maxZoomLevel:"+maxZoomLevel);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(contry);
        map.setMapStatus(mapStatusUpdate);
    }

    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();

    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

