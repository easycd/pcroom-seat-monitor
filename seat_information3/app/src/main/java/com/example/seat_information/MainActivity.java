package com.example.seat_information;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.seat_information.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();



    ToggleButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16,
            btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25, btn_26, btn_27, btn_28, btn_29, btn_30,
            btn_31, btn_32, btn_33, btn_34, btn_35, btn_36, btn_37, btn_38, btn_39, btn_40, btn_41, btn_42, btn_43, btn_44,
            btn_45, btn_46, btn_47, btn_48, btn_49, btn_50, btn_51, btn_52, btn_53, btn_54, btn_55, btn_56, btn_57, btn_58, btn_59, btn_60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        타이틀 바 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        하단 메뉴바 제거
        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled = ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i("Is on?", "Turning immersive mode mode off. ");
        } else {
            Log.i("Is on?", "Turning immersive mode mode on.");
        }
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);



        btn_1 = (ToggleButton) findViewById(R.id.btn_1);
        btn_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_01").setValue("1");
                    btn_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_01").setValue("0");
                    btn_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_2 = (ToggleButton) findViewById(R.id.btn_2);
        btn_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_02").setValue("1");
                    btn_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_02").setValue("0");
                    btn_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_3 = (ToggleButton) findViewById(R.id.btn_3);
        btn_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_03").setValue("1");
                    btn_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_03").setValue("0");
                    btn_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_4 = (ToggleButton) findViewById(R.id.btn_4);
        btn_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_04").setValue("1");
                    btn_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_04").setValue("0");
                    btn_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_5 = (ToggleButton) findViewById(R.id.btn_5);
        btn_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_05").setValue("1");
                    btn_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_05").setValue("0");
                    btn_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_6 = (ToggleButton) findViewById(R.id.btn_6);
        btn_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_06").setValue("1");
                    btn_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_06").setValue("0");
                    btn_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_7 = (ToggleButton) findViewById(R.id.btn_7);
        btn_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_07").setValue("1");
                    btn_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_07").setValue("0");
                    btn_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_8 = (ToggleButton) findViewById(R.id.btn_8);
        btn_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_08").setValue("1");
                    btn_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_08").setValue("0");
                    btn_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_9 = (ToggleButton) findViewById(R.id.btn_9);
        btn_9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_09").setValue("1");
                    btn_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_09").setValue("0");
                    btn_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_10 = (ToggleButton) findViewById(R.id.btn_10);
        btn_10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_10").setValue("1");
                    btn_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_10").setValue("0");
                    btn_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });

        btn_11 = (ToggleButton) findViewById(R.id.btn_11);
        btn_11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_11").setValue("1");
                    btn_11.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_11").setValue("0");
                    btn_11.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_12 = (ToggleButton) findViewById(R.id.btn_12);
        btn_12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_12").setValue("1");
                    btn_12.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_12").setValue("0");
                    btn_12.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_13 = (ToggleButton) findViewById(R.id.btn_13);
        btn_13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_13").setValue("1");
                    btn_13.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_13").setValue("0");
                    btn_13.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_14 = (ToggleButton) findViewById(R.id.btn_14);
        btn_14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_14").setValue("1");
                    btn_14.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_14").setValue("0");
                    btn_14.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_15 = (ToggleButton) findViewById(R.id.btn_15);
        btn_15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_15").setValue("1");
                    btn_15.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_15").setValue("0");
                    btn_15.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_16 = (ToggleButton) findViewById(R.id.btn_16);
        btn_16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_16").setValue("1");
                    btn_16.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_16").setValue("0");
                    btn_16.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_17 = (ToggleButton) findViewById(R.id.btn_17);
        btn_17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_17").setValue("1");
                    btn_17.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_17").setValue("0");
                    btn_17.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_18 = (ToggleButton) findViewById(R.id.btn_18);
        btn_18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_18").setValue("1");
                    btn_18.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_18").setValue("0");
                    btn_18.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_19 = (ToggleButton) findViewById(R.id.btn_19);
        btn_19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_19").setValue("1");
                    btn_19.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_19").setValue("0");
                    btn_19.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_20 = (ToggleButton) findViewById(R.id.btn_20);
        btn_20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_20").setValue("1");
                    btn_20.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_20").setValue("0");
                    btn_20.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });

        btn_21 = (ToggleButton) findViewById(R.id.btn_21);
        btn_21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_21").setValue("1");
                    btn_21.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_21").setValue("0");
                    btn_21.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_22 = (ToggleButton) findViewById(R.id.btn_22);
        btn_22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_22").setValue("1");
                    btn_22.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_22").setValue("0");
                    btn_22.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_23 = (ToggleButton) findViewById(R.id.btn_23);
        btn_23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_23").setValue("1");
                    btn_23.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_23").setValue("0");
                    btn_23.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_24 = (ToggleButton) findViewById(R.id.btn_24);
        btn_24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_24").setValue("1");
                    btn_24.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_24").setValue("0");
                    btn_24.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_25 = (ToggleButton) findViewById(R.id.btn_25);
        btn_25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_25").setValue("1");
                    btn_25.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_25").setValue("0");
                    btn_25.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_26 = (ToggleButton) findViewById(R.id.btn_26);
        btn_26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_26").setValue("1");
                    btn_26.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_26").setValue("0");
                    btn_26.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_27 = (ToggleButton) findViewById(R.id.btn_27);
        btn_27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_27").setValue("1");
                    btn_27.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_27").setValue("0");
                    btn_27.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_28 = (ToggleButton) findViewById(R.id.btn_28);
        btn_28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_28").setValue("1");
                    btn_28.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_28").setValue("0");
                    btn_28.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_29 = (ToggleButton) findViewById(R.id.btn_29);
        btn_29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_29").setValue("1");
                    btn_29.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_29").setValue("0");
                    btn_29.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_30 = (ToggleButton) findViewById(R.id.btn_30);
        btn_30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_30").setValue("1");
                    btn_30.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_30").setValue("0");
                    btn_30.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });

        btn_31 = (ToggleButton) findViewById(R.id.btn_31);
        btn_31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_31").setValue("1");
                    btn_31.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_31").setValue("0");
                    btn_31.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_32 = (ToggleButton) findViewById(R.id.btn_32);
        btn_32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_32").setValue("1");
                    btn_32.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_32").setValue("0");
                    btn_32.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_33 = (ToggleButton) findViewById(R.id.btn_33);
        btn_33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_33").setValue("1");
                    btn_33.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_33").setValue("0");
                    btn_33.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_34 = (ToggleButton) findViewById(R.id.btn_34);
        btn_34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_34").setValue("1");
                    btn_34.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_34").setValue("0");
                    btn_34.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_35 = (ToggleButton) findViewById(R.id.btn_35);
        btn_35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_35").setValue("1");
                    btn_35.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_35").setValue("0");
                    btn_35.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_36 = (ToggleButton) findViewById(R.id.btn_36);
        btn_36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_36").setValue("1");
                    btn_36.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_36").setValue("0");
                    btn_36.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_37 = (ToggleButton) findViewById(R.id.btn_37);
        btn_37.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_37").setValue("1");
                    btn_37.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_37").setValue("0");
                    btn_37.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_38 = (ToggleButton) findViewById(R.id.btn_38);
        btn_38.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_38").setValue("1");
                    btn_38.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_38").setValue("0");
                    btn_38.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_39 = (ToggleButton) findViewById(R.id.btn_39);
        btn_39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_39").setValue("1");
                    btn_39.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_39").setValue("0");
                    btn_39.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });

        btn_40 = (ToggleButton) findViewById(R.id.btn_40);
        btn_40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_40").setValue("1");
                    btn_40.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_40").setValue("0");
                    btn_40.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_41 = (ToggleButton) findViewById(R.id.btn_41);
        btn_41.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_41").setValue("1");
                    btn_41.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_41").setValue("0");
                    btn_41.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_42 = (ToggleButton) findViewById(R.id.btn_42);
        btn_42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_42").setValue("1");
                    btn_42.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_42").setValue("0");
                    btn_42.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_43 = (ToggleButton) findViewById(R.id.btn_43);
        btn_43.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_43").setValue("1");
                    btn_43.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_43").setValue("0");
                    btn_43.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_44 = (ToggleButton) findViewById(R.id.btn_44);
        btn_44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_44").setValue("1");
                    btn_44.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_44").setValue("0");
                    btn_44.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_45 = (ToggleButton) findViewById(R.id.btn_45);
        btn_45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_45").setValue("1");
                    btn_45.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_45").setValue("0");
                    btn_45.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_46 = (ToggleButton) findViewById(R.id.btn_46);
        btn_46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_46").setValue("1");
                    btn_46.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_46").setValue("0");
                    btn_46.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_47 = (ToggleButton) findViewById(R.id.btn_47);
        btn_47.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_47").setValue("1");
                    btn_47.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_47").setValue("0");
                    btn_47.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_48 = (ToggleButton) findViewById(R.id.btn_48);
        btn_48.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_48").setValue("1");
                    btn_48.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_48").setValue("0");
                    btn_48.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_49 = (ToggleButton) findViewById(R.id.btn_49);
        btn_49.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_49").setValue("1");
                    btn_49.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_49").setValue("0");
                    btn_49.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });


        btn_50 = (ToggleButton) findViewById(R.id.btn_50);
        btn_50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_50").setValue("1");
                    btn_50.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_50").setValue("0");
                    btn_50.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_51 = (ToggleButton) findViewById(R.id.btn_51);
        btn_51.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_51").setValue("1");
                    btn_51.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_51").setValue("0");
                    btn_51.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_52 = (ToggleButton) findViewById(R.id.btn_52);
        btn_52.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_52").setValue("1");
                    btn_52.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_52").setValue("0");
                    btn_52.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_53 = (ToggleButton) findViewById(R.id.btn_53);
        btn_53.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_53").setValue("1");
                    btn_53.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_53").setValue("0");
                    btn_53.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_54 = (ToggleButton) findViewById(R.id.btn_54);
        btn_54.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_54").setValue("1");
                    btn_54.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_54").setValue("0");
                    btn_54.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_55 = (ToggleButton) findViewById(R.id.btn_55);
        btn_55.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_55").setValue("1");
                    btn_55.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_55").setValue("0");
                    btn_55.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_56 = (ToggleButton) findViewById(R.id.btn_56);
        btn_56.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_56").setValue("1");
                    btn_56.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_56").setValue("0");
                    btn_56.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_57 = (ToggleButton) findViewById(R.id.btn_57);
        btn_57.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_57").setValue("1");
                    btn_57.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_57").setValue("0");
                    btn_57.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_58 = (ToggleButton) findViewById(R.id.btn_58);
        btn_58.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_58").setValue("1");
                    btn_58.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_58").setValue("0");
                    btn_58.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_59 = (ToggleButton) findViewById(R.id.btn_59);
        btn_59.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_59").setValue("1");
                    btn_59.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_59").setValue("0");
                    btn_59.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
        btn_60 = (ToggleButton) findViewById(R.id.btn_60);
        btn_60.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference.child("seat_information").child("seat_60").setValue("1");
                    btn_60.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                } else {
                    databaseReference.child("seat_information").child("seat_60").setValue("0");
                    btn_60.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
        });
    }
}