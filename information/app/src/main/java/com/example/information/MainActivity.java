package com.example.information;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;


    //전적검색 스크롤
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final DrawerLayout drawer = findViewById(R.id.drawer);
        findViewById(R.id.Menubtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.END);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

//pc맵 버튼
        Button Pcmap = (Button) findViewById(R.id.Pcmap);
        Pcmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Maps.class);
                startActivity(intent);
            }
        });

        //게임정보 버튼
        Button game_info = (Button) findViewById(R.id.game_info);
        game_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Gameinfo.class);
                startActivity(intent);
            }
        });

//        커뮤니티 버튼
        Button Cummunity = (Button) findViewById(R.id.Cummunity);
        Cummunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cummunity.class);
                startActivity(intent);
            }
        });

        Button notice_btn = findViewById(R.id.notice_btn);
        notice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NOtice.class);
                startActivity(intent);
            }
        });

//        전적검색 버튼
        ImageButton opgg = (ImageButton) findViewById(R.id.opgg);
        opgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OPGG.class);
                startActivity(intent);
            }
        });
        ImageButton fow = (ImageButton) findViewById(R.id.fow);
        fow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FOW.class);
                startActivity(intent);
            }
        });
        ImageButton dak = (ImageButton) findViewById(R.id.dak);
        dak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DAK.class);
                startActivity(intent);
            }
        });


//      나사렛피시방 정보 버튼
        RelativeLayout Infobtn = (RelativeLayout) findViewById(R.id.Infobtn);
        Infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), information.class);
                startActivity(intent);
            }
        });
        //나사렛피시방 자리현황
        Button seat_1 = (Button) findViewById(R.id.seat_1);
        seat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Seat_information.class);
                startActivity(intent);
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference count_available = database.getReference().child("seat_information");
        count_available.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                TextView SeatCount = findViewById(R.id.Seatcount);
                String str = "0";
                int temp= 0;
                for (DataSnapshot dataSnapshot: datasnapshot.getChildren()){
                    if (dataSnapshot.getValue().equals(str)) {
                        temp += 1;
                    }
                    SeatCount.setText(String.valueOf(temp));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

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

//        이벤트 이미지 슬라이드
        int images[] = {
                R.drawable.event4,
                R.drawable.event2,
                R.drawable.event9,
                R.drawable.event6,
                R.drawable.event5
        };
        v_fllipper = findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }
    }
    // 이미지 슬라이더 구현 메서드
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(5000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);

    }
}
