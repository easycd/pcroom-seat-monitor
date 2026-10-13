package com.example.information;

import android.Manifest;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.widget.CompassView;
import com.naver.maps.map.widget.LocationButtonView;
import com.naver.maps.map.widget.ScaleBarView;
import com.naver.maps.map.widget.ZoomControlView;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "Maps";
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private FusedLocationSource mLocationSource;
    private NaverMap mNaverMap;

    // 마커를 찍을 데이터
   // private ArrayList<PlaceInfo> mPlaceInfoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);



        // 지도 객체 생성
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map_fragment);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }

        // getMapAsync를 호출하여 비동기로 onMapReady 콜백 메서드 호출
        // onMapReady에서 NaverMap 객체를 받음
        mapFragment.getMapAsync(this);

        // 위치를 반환하는 구현체인 FusedLocationSource 생성
        mLocationSource = new FusedLocationSource(this, PERMISSION_REQUEST_CODE);

        //하단 메뉴바
        ImageButton homebtn = (ImageButton) findViewById(R.id.homebtn);
        ImageButton eventbtn = (ImageButton) findViewById(R.id.eventbtn);
        ImageButton favoritebtn = (ImageButton) findViewById(R.id.favoritebtn);
        ImageButton backbtn = (ImageButton) findViewById(R.id.backbtn);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        eventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), event.class);
                startActivity(intent);
            }
        });

        favoritebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), favorite.class);
                startActivity(intent);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Log.d( TAG, "onMapReady");

        // NaverMap 객체 받아서 NaverMap 객체에 위치 소스 지정
        mNaverMap = naverMap;
        mNaverMap.setLocationSource(mLocationSource);

        Marker marker1 = new Marker();
        Marker marker2 = new Marker();
        Marker marker3 = new Marker();
        Marker marker4 = new Marker();
        Marker marker5 = new Marker();
        Marker marker6 = new Marker();
        marker1.setPosition(new LatLng(36.7971961, 127.118137));
        marker2.setPosition(new LatLng(36.7982552, 127.1187767));
        marker3.setPosition(new LatLng(36.7978486, 127.1205776));
        marker4.setPosition(new LatLng(36.796411, 127.121151));
        marker5.setPosition(new LatLng(36.7941818, 127.1211933));
        marker6.setPosition(new LatLng(36.7982142, 127.1179218));
        marker1.setMap(naverMap);marker2.setMap(naverMap);marker3.setMap(naverMap);marker4.setMap(naverMap);marker5.setMap(naverMap);marker6.setMap(naverMap);
        marker1.setCaptionText("나사렛 피시방");marker2.setCaptionText("WOW 피시방");marker3.setCaptionText("피씨토랑");marker4.setCaptionText("아이센스");marker5.setCaptionText("아프리카 피시방");marker6.setCaptionText("맥스피씨");
        marker1.setCaptionOffset(15);marker2.setCaptionOffset(15);marker3.setCaptionOffset(15);marker4.setCaptionOffset(15);marker5.setCaptionOffset(15);marker6.setCaptionOffset(15);
        marker1.setCaptionTextSize(16);marker2.setCaptionTextSize(16);marker3.setCaptionTextSize(16);marker4.setCaptionTextSize(16);marker5.setCaptionTextSize(16);marker6.setCaptionTextSize(16);
        marker1.setSubCaptionText("1200원");marker2.setSubCaptionText("1000원");marker3.setSubCaptionText("1400원");marker4.setSubCaptionText("1400원");marker5.setSubCaptionText("1300원");marker6.setSubCaptionText("1400원");
        marker1.setSubCaptionHaloColor(Color.rgb(248, 155, 0));marker2.setSubCaptionHaloColor(Color.rgb(248, 155, 0));marker3.setSubCaptionHaloColor(Color.rgb(248, 155, 0));marker4.setSubCaptionHaloColor(Color.rgb(248, 155, 0));marker5.setSubCaptionHaloColor(Color.rgb(248, 155, 0));marker6.setSubCaptionHaloColor(Color.rgb(248, 155, 0));
        marker1.setSubCaptionTextSize(12);marker2.setSubCaptionTextSize(12);marker3.setSubCaptionTextSize(12);marker4.setSubCaptionTextSize(12);marker5.setSubCaptionTextSize(12);marker6.setSubCaptionTextSize(12);

                // UI 컨트롤 재배치
        UiSettings uiSettings = mNaverMap.getUiSettings();
        uiSettings.setCompassEnabled(false); // 기본값 : true
        uiSettings.setScaleBarEnabled(false); // 기본값 : true
        uiSettings.setZoomControlEnabled(false); // 기본값 : true
        uiSettings.setLocationButtonEnabled(false); // 기본값 : false
        uiSettings.setLogoGravity(Gravity.RIGHT|Gravity.BOTTOM);

        CompassView compassView = findViewById(R.id.compass);
        compassView.setMap(mNaverMap);
        ScaleBarView scaleBarView = findViewById(R.id.scalebar);
        scaleBarView.setMap(mNaverMap);
        ZoomControlView zoomControlView = findViewById(R.id.zoom);
        zoomControlView.setMap(mNaverMap);
        LocationButtonView locationButtonView = findViewById(R.id.location);
        locationButtonView.setMap(mNaverMap);

        // 권한확인. 결과는 onRequestPermissionsResult 콜백 매서드 호출
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // request code와 권한획득 여부 확인
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mNaverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
    }
}
