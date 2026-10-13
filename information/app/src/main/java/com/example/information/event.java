package com.example.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class event extends AppCompatActivity {

    Button Ing, End;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);



        Ing = (Button) findViewById(R.id.Ing);
        End = (Button) findViewById(R.id.End);

        Ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Eventlist eventlist = new Eventlist();
                transaction.replace(R.id.eventframe, eventlist);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Endevent endevent = new Endevent();
                transaction.replace(R.id.eventframe, endevent);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

//하단 네비게이션 바
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
}
