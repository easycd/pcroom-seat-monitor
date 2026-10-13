package com.example.information;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Seat_information extends AppCompatActivity {

    ViewFlipper v_fllipper;
    TextView seat_available, seat_unavailable;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16,
            btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25, btn_26, btn_27, btn_28, btn_29, btn_30,
            btn_31, btn_32, btn_33, btn_34, btn_35, btn_36, btn_37, btn_38, btn_39, btn_40, btn_41, btn_42, btn_43, btn_44,
            btn_45, btn_46, btn_47, btn_48, btn_49, btn_50, btn_51, btn_52, btn_53, btn_54, btn_55, btn_56, btn_57, btn_58,
            btn_59, btn_60;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_information);
        btn_1 = findViewById(R.id.btn_1); btn_2 = findViewById(R.id.btn_2); btn_3 = findViewById(R.id.btn_3); btn_4 = findViewById(R.id.btn_4); btn_5 = findViewById(R.id.btn_5); btn_6 = findViewById(R.id.btn_6); btn_7 = findViewById(R.id.btn_7); btn_8 = findViewById(R.id.btn_8); btn_9 = findViewById(R.id.btn_9); btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11); btn_12 = findViewById(R.id.btn_12); btn_13 = findViewById(R.id.btn_13); btn_14 = findViewById(R.id.btn_14); btn_15 = findViewById(R.id.btn_15); btn_16 = findViewById(R.id.btn_16); btn_17 = findViewById(R.id.btn_17); btn_18 = findViewById(R.id.btn_18); btn_19 = findViewById(R.id.btn_19); btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21); btn_22 = findViewById(R.id.btn_22); btn_23 = findViewById(R.id.btn_23); btn_24 = findViewById(R.id.btn_24); btn_25 = findViewById(R.id.btn_25); btn_26 = findViewById(R.id.btn_26); btn_27 = findViewById(R.id.btn_27); btn_28 = findViewById(R.id.btn_28); btn_29 = findViewById(R.id.btn_29); btn_30 = findViewById(R.id.btn_30);
        btn_31 = findViewById(R.id.btn_31); btn_32 = findViewById(R.id.btn_32); btn_33 = findViewById(R.id.btn_33); btn_34 = findViewById(R.id.btn_34); btn_35 = findViewById(R.id.btn_35); btn_36 = findViewById(R.id.btn_36); btn_37 = findViewById(R.id.btn_37); btn_38 = findViewById(R.id.btn_38); btn_39 = findViewById(R.id.btn_39); btn_40 = findViewById(R.id.btn_40);
        btn_41 = findViewById(R.id.btn_41); btn_42 = findViewById(R.id.btn_42); btn_43 = findViewById(R.id.btn_43); btn_44 = findViewById(R.id.btn_44); btn_45 = findViewById(R.id.btn_45); btn_46 = findViewById(R.id.btn_46); btn_47 = findViewById(R.id.btn_47); btn_48 = findViewById(R.id.btn_48); btn_49 = findViewById(R.id.btn_49); btn_50 = findViewById(R.id.btn_50);
        btn_51 = findViewById(R.id.btn_51); btn_52 = findViewById(R.id.btn_52); btn_53 = findViewById(R.id.btn_53); btn_54 = findViewById(R.id.btn_54); btn_55 = findViewById(R.id.btn_55); btn_56 = findViewById(R.id.btn_56); btn_57 = findViewById(R.id.btn_57); btn_58 = findViewById(R.id.btn_58); btn_59 = findViewById(R.id.btn_59); btn_60 = findViewById(R.id.btn_60);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference btn1 = database.getReference().child("seat_information").child("seat_01");DatabaseReference btn2 = database.getReference().child("seat_information").child("seat_02");DatabaseReference btn3 = database.getReference().child("seat_information").child("seat_03");DatabaseReference btn4 = database.getReference().child("seat_information").child("seat_04");DatabaseReference btn5 = database.getReference().child("seat_information").child("seat_05");
        DatabaseReference btn6 = database.getReference().child("seat_information").child("seat_06");DatabaseReference btn7 = database.getReference().child("seat_information").child("seat_07");DatabaseReference btn8 = database.getReference().child("seat_information").child("seat_08");DatabaseReference btn9 = database.getReference().child("seat_information").child("seat_09");DatabaseReference btn10 = database.getReference().child("seat_information").child("seat_10");
        DatabaseReference btn11 = database.getReference().child("seat_information").child("seat_11");DatabaseReference btn12 = database.getReference().child("seat_information").child("seat_12");DatabaseReference btn13 = database.getReference().child("seat_information").child("seat_13");DatabaseReference btn14 = database.getReference().child("seat_information").child("seat_14");DatabaseReference btn15 = database.getReference().child("seat_information").child("seat_15");
        DatabaseReference btn16 = database.getReference().child("seat_information").child("seat_16");DatabaseReference btn17 = database.getReference().child("seat_information").child("seat_17");DatabaseReference btn18 = database.getReference().child("seat_information").child("seat_18");DatabaseReference btn19 = database.getReference().child("seat_information").child("seat_19");DatabaseReference btn20 = database.getReference().child("seat_information").child("seat_20");
        DatabaseReference btn21 = database.getReference().child("seat_information").child("seat_21");DatabaseReference btn22 = database.getReference().child("seat_information").child("seat_22");DatabaseReference btn23 = database.getReference().child("seat_information").child("seat_23");DatabaseReference btn24 = database.getReference().child("seat_information").child("seat_24");DatabaseReference btn25 = database.getReference().child("seat_information").child("seat_25");
        DatabaseReference btn26 = database.getReference().child("seat_information").child("seat_26");DatabaseReference btn27 = database.getReference().child("seat_information").child("seat_27");DatabaseReference btn28 = database.getReference().child("seat_information").child("seat_28");DatabaseReference btn29 = database.getReference().child("seat_information").child("seat_29");DatabaseReference btn30 = database.getReference().child("seat_information").child("seat_30");
        DatabaseReference btn31 = database.getReference().child("seat_information").child("seat_31");DatabaseReference btn32 = database.getReference().child("seat_information").child("seat_32");DatabaseReference btn33 = database.getReference().child("seat_information").child("seat_33");DatabaseReference btn34 = database.getReference().child("seat_information").child("seat_34");DatabaseReference btn35 = database.getReference().child("seat_information").child("seat_35");
        DatabaseReference btn36 = database.getReference().child("seat_information").child("seat_36");DatabaseReference btn37 = database.getReference().child("seat_information").child("seat_37");DatabaseReference btn38 = database.getReference().child("seat_information").child("seat_38");DatabaseReference btn39 = database.getReference().child("seat_information").child("seat_39");DatabaseReference btn40 = database.getReference().child("seat_information").child("seat_40");
        DatabaseReference btn41 = database.getReference().child("seat_information").child("seat_41");DatabaseReference btn42 = database.getReference().child("seat_information").child("seat_42");DatabaseReference btn43 = database.getReference().child("seat_information").child("seat_43");DatabaseReference btn44 = database.getReference().child("seat_information").child("seat_44");DatabaseReference btn45 = database.getReference().child("seat_information").child("seat_45");
        DatabaseReference btn46 = database.getReference().child("seat_information").child("seat_46");DatabaseReference btn47 = database.getReference().child("seat_information").child("seat_47");DatabaseReference btn48 = database.getReference().child("seat_information").child("seat_48");DatabaseReference btn49 = database.getReference().child("seat_information").child("seat_49");DatabaseReference btn50 = database.getReference().child("seat_information").child("seat_50");
        DatabaseReference btn51 = database.getReference().child("seat_information").child("seat_51");DatabaseReference btn52 = database.getReference().child("seat_information").child("seat_52");DatabaseReference btn53 = database.getReference().child("seat_information").child("seat_53");DatabaseReference btn54 = database.getReference().child("seat_information").child("seat_54");DatabaseReference btn55 = database.getReference().child("seat_information").child("seat_55");
        DatabaseReference btn56 = database.getReference().child("seat_information").child("seat_56");DatabaseReference btn57 = database.getReference().child("seat_information").child("seat_57");DatabaseReference btn58 = database.getReference().child("seat_information").child("seat_58");DatabaseReference btn59 = database.getReference().child("seat_information").child("seat_59");DatabaseReference btn60 = database.getReference().child("seat_information").child("seat_60");

        btn1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_5.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_6.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_7.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_8.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_9.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_10.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btn11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_11.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_11.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_12.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_12.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_13.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_13.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_14.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_14.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn15.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_15.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_15.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn16.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_16.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_16.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn17.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_17.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_17.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn18.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_18.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_18.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn19.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_19.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_19.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn20.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_20.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_20.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btn21.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_21.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_21.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_22.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_22.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn23.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_23.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_23.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn24.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_24.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_24.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn25.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_25.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_25.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn26.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_26.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_26.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn27.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_27.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_27.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn28.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_28.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_28.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn29.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_29.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_29.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn30.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_30.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_30.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btn31.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_31.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_31.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn32.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_32.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_32.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn33.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_33.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_33.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn34.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_34.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_34.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn35.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_35.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_35.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn36.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_36.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_36.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn37.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_37.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_37.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn38.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_38.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_38.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn39.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_39.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_39.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn40.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_40.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_40.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btn41.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_41.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_41.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn42.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_42.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_42.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn43.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_43.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_43.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn44.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_44.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_44.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn45.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_45.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_45.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn46.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_46.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_46.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn47.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_47.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_47.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn48.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_48.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_48.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn49.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_49.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_49.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn50.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_50.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_50.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btn51.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_51.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_51.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn52.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_52.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_52.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn53.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_53.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_53.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn54.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_54.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_54.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn55.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_55.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_55.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn56.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_56.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_56.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn57.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_57.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_57.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn58.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_58.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_58.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn59.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_59.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_59.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btn60.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String value = datasnapshot.getValue().toString();
                int number = Integer.parseInt(value);
                if (number == 1){
                    btn_60.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_off));
                }else {
                    btn_60.setBackgroundDrawable(getResources().getDrawable(R.drawable.seat_btn_style));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

//        사용가능 사용중 count 코드
        DatabaseReference count_available = database.getReference().child("seat_information");
        seat_available = findViewById(R.id.seat_available);
        seat_unavailable = findViewById(R.id.seat_unavailable);

        count_available.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                seat_available = findViewById(R.id.seat_available);
                seat_unavailable = findViewById(R.id.seat_unavailable);
                String value = datasnapshot.getValue().toString();
                String str = "1";
                int temp= 0;
                int temp1 = 0;
                for (DataSnapshot dataSnapshot: datasnapshot.getChildren()){
                    if (dataSnapshot.getValue().equals(str)) {
                        temp += 1;
                    }else {
                        temp1 +=1;
                    }
                    seat_unavailable.setText(String.valueOf(temp));
                    seat_available.setText(String.valueOf(temp1));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


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

//        favoritebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), favorite.class);
//                startActivity(intent);
//            }
//        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        int images[] = {
                R.drawable.event4,
                R.drawable.event2,
                R.drawable.event9,
                R.drawable.event6,
                R.drawable.event5
        };
        v_fllipper = findViewById(R.id.image_slide_seat);

        for(int image : images) {
            fllipperImages(image);
        }
    }
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

