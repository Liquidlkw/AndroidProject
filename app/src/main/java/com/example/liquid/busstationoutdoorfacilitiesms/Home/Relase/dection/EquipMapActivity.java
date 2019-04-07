package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

import java.util.ArrayList;
import java.util.List;

public class EquipMapActivity extends AppCompatActivity {

    private LocationClient mlocationclient;
    /**
     * Hello World!
     */
    private TextView mTvPosition;
    private List<String> permissionList;
    private MapView mBaidumap;
    private BaiduMap Baidu;
    private boolean isFirstLocate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册定位监听器，当获取到位置信息时就会回调这个监听器
        mlocationclient = new LocationClient(getApplicationContext());
        mlocationclient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_equip_map);
        initView();
        Baidu =mBaidumap.getMap();
        Baidu.setMyLocationEnabled(true);
        requestpermission();


    }

    private void requestpermission() {
        permissionList = new ArrayList<>();
        checkandaddpermission(Manifest.permission.ACCESS_FINE_LOCATION);
        checkandaddpermission(Manifest.permission.READ_PHONE_STATE);
        checkandaddpermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(EquipMapActivity.this, permissions, 1);
        } else {
            requsetLocation();
        }
    }

    private void navigateTo(BDLocation location){
        if(isFirstLocate)
        {
            LatLng latLng =new LatLng(location.getLatitude(),location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(latLng);
            Baidu.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            Baidu.animateMapStatus(update);
            isFirstLocate=  false ;
        }

        MyLocationData.Builder builder = new MyLocationData.Builder();
        builder.latitude(location.getLatitude());
        builder.longitude(location.getLongitude());
        MyLocationData locationData = builder.build();
        Baidu.setMyLocationData(locationData);


    }

    private void requsetLocation() {
        initLocation();//实时跟新当前位置
        mlocationclient.start();//开启定位
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);//设置更新时间
        option.setIsNeedAddress(true);//设置可以获取当前位置的详细位置
        mlocationclient.setLocOption(option);
    }

    private void checkandaddpermission(String permission) {
        if (ContextCompat.checkSelfPermission
                (EquipMapActivity.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(permission);
        }
    }

    private void initView() {

        mTvPosition = (TextView) findViewById(R.id.tv_position);

        mBaidumap = (MapView) findViewById(R.id.baidumap);
    }

    /*
    定位监听器
     */
    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation bdLocation) {

            if(bdLocation.getLocType() ==BDLocation.TypeGpsLocation||bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                navigateTo(bdLocation);
            }

            /*
            更新UI定位信息
             */
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    StringBuilder currentPosition = new StringBuilder();
                    currentPosition.append("纬度：").append(bdLocation.getLatitude()).append("\n");
                    currentPosition.append("经度：").append(bdLocation.getLongitude()).append("\n");
                    currentPosition.append("国家：").append(bdLocation.getCountry()).append("\n");
                    currentPosition.append("省：").append(bdLocation.getProvince()).append("\n");
                    currentPosition.append("市：").append(bdLocation.getCity()).append("\n");
                    currentPosition.append("区：").append(bdLocation.getDistrict()).append("\n");
                    currentPosition.append("街道：").append(bdLocation.getStreet()).append("\n");
                    currentPosition.append("定位方式：");
                    if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                        currentPosition.append("GPS");
                    }

                    if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                        currentPosition.append("网络");
                    }
                    mTvPosition.setText(currentPosition);
                }
            });



        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBaidumap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBaidumap.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mlocationclient.stop();//在活动被销毁的时候停止定位，节省电量
        mBaidumap.onDestroy();
        Baidu.setMyLocationEnabled(false);
    }
}
