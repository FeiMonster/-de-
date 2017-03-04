package monster.com.mymap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

/**
 * Created by ASUS on 2017/3/3.
 */

public class MarkerOverLayActivity extends BaseActivity {

    private MarkerOptions options;
    private View pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMarker();
        map.setOnMarkerClickListener(mOnMarkerClickListener);
    }
    BaiduMap.OnMarkerDragListener markerDragListener = new BaiduMap.OnMarkerDragListener() {
        @Override
        public void onMarkerDrag(Marker marker) {
            mMapView.updateViewLayout(pop,getMapViewLayoutParams(marker.getPosition()));//更新位置

        }

        @Override
        public void onMarkerDragEnd(Marker marker) {
            mMapView.updateViewLayout(pop,getMapViewLayoutParams(marker.getPosition()));//更新位置

        }

        @Override
        public void onMarkerDragStart(Marker marker) {
            mMapView.updateViewLayout(pop,getMapViewLayoutParams(marker.getPosition()));//更新位置

        }
    };
        BaiduMap.OnMarkerClickListener mOnMarkerClickListener  =new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(pop == null){
                    pop = View.inflate(MarkerOverLayActivity.this, R.layout.pop,null);
                    MapViewLayoutParams param = getMapViewLayoutParams(marker.getPosition());
                    mMapView.addView(pop,param);
                }else{
                    mMapView.updateViewLayout(pop,getMapViewLayoutParams(marker.getPosition()));//更新位置
                }
                    TextView tv_title = (TextView) findViewById(R.id.tv_title);
                tv_title.setText(marker.getTitle());
                return true;
            }
        };

    //创建一个布局方法
    private MapViewLayoutParams getMapViewLayoutParams(LatLng position) {
        MapViewLayoutParams.Builder buider = new MapViewLayoutParams.Builder();
        buider.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
        buider.position(position);//设置标志的位置
        buider.yOffset(-40);//设置view往上偏移
        return buider.build();
    }

    private void initMarker() {
        options = new MarkerOptions();
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_eat);
        options.title("美丽向党村").position(contry).draggable(true).icon(icon);
        map.addOverlay(options);
        options = new MarkerOptions();
        BitmapDescriptor icon2 = BitmapDescriptorFactory.fromResource(R.drawable.icon_eat);
        options.title("向东").position(new LatLng(contry.latitude,contry.longitude+0.01)).draggable(true).icon(icon2);
        map.addOverlay(options);
        options = new MarkerOptions();
        BitmapDescriptor icon3 = BitmapDescriptorFactory.fromResource(R.drawable.icon_eat);
        options.title("向北").position(new LatLng(contry.latitude+0.01,contry.longitude)).draggable(true).icon(icon3);
        map.addOverlay(options);
        options = new MarkerOptions();
        BitmapDescriptor icon4 = BitmapDescriptorFactory.fromResource(R.drawable.icon_eat);
        options.title("向西南").position(new LatLng(contry.latitude-0.01,contry.longitude-0.01)).draggable(true).icon(icon4);
        map.addOverlay(options);
    }
}
