package monster.com.mymap;

import android.os.Bundle;

import com.baidu.location.Poi;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

import mapapi.overlayutil.IndoorPoiOverlay;

/**
 * Created by ASUS on 2017/3/4.
 */

public class SearchInBoundActivity extends BaseActivity implements OnGetPoiSearchResultListener {

    private PoiBoundSearchOption param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PoiSearch poiSearch = PoiSearch.newInstance();
        poiSearch.searchInBound(getSearchParams());
        poiSearch.setOnGetPoiSearchResultListener(this);
    }

    private PoiBoundSearchOption getSearchParams() {
        param = new PoiBoundSearchOption();
        // 指定搜索范围，由一个西南点和一个东北点组成的范围
        LatLngBounds bounds = new LatLngBounds.Builder().include(new LatLng(20.9201190000,110.1030910000))
                .include(new LatLng(0.5608850000,109.8536620000)).build();
        param.bound(bounds);	// 指定搜索范围
        param.keyword("加油站");	// 指定搜索什么内容
        return param;

    }

    @Override
    //获取兴趣的点的信息
    public void onGetPoiResult(PoiResult result) {
    }

    @Override
    public void onGetPoiDetailResult(PoiDetailResult result) {

    }

    @Override
    public void onGetPoiIndoorResult(PoiIndoorResult result) {
        if(result == null || result.error == SearchResult.ERRORNO.NO_ERROR){
            Utils.showToast(SearchInBoundActivity.this,"没有搜索到结果");
            return;
        }
        IndoorPoiOverlay poiOverlay = new IndoorPoiOverlay(map){
            @Override
            public boolean onPoiClick(int index) {
                return true;
            }
        };
        poiOverlay.setData(result);
        poiOverlay.addToMap();
        poiOverlay.zoomToSpan();

    }

}