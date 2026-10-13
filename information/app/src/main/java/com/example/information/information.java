package com.example.information;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class information extends Activity {

    private RecyclerView recyclerview;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private EditText editdt;
    private Button sendbt;
    public String msg;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    List<Object> Array = new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        ToggleButton bookmark = findViewById(R.id.bookmark);

        bookmark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bookmark.setBackgroundDrawable(getResources().getDrawable(R.drawable.heart));
                } else {
                    bookmark.setBackgroundDrawable(getResources().getDrawable(R.drawable.emptyheart));
                }
            }
        });


//        메뉴 리스트
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();  // 데이터를 담을 List

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "라면"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "진라면 매운맛"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "신라면"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "불닭볶음면(큰컵)"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "열라면"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "식사"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "김치 볶음밥"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "스팸 김치 볶음밥"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "감자탕 볶음밥"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "김치 짜글이"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "간식"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "숏다리"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "핫도그"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "미니 탕수육"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "피카츄 돈가스"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "감자 튀김"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "과자"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "칸쵸"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "홈런볼"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "썬칩"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "예감"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "초코송이"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "음료수"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "코카콜라"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "칠성사이다"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "웰치스"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "밀키스"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "환타(오렌지)"));

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "카페"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "아이스 아메리카노"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "카페라떼"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "아이스티"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "커피모카"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "옛날 커피"));
        recyclerview.setAdapter(new ExpandableListAdapter(data));


        listView = (ListView) findViewById(R.id.rv_data);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);
        initDatabase();
        sendbt = (Button) findViewById(R.id.Reviewbtn);
        editdt = (EditText)findViewById(R.id.send_text);
        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        sendbt.setOnClickListener((v) -> {
            msg = editdt.getText().toString();
            databaseReference.child("Review").push().setValue(msg);
            editdt.setText("");
            manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        });

        mReference = mDatabase.getReference("Review"); // 변경값을 확인할 child 이름
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();

                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    String msg2 = messageData.getValue().toString();
                    Array.add(msg2);
                    adapter.add(msg2);
                }
                adapter.notifyDataSetChanged();
                listView.setSelection(adapter.getCount() - 1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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



    private void initDatabase() {

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("log");
        mReference.child("log").setValue("check");

        mChild = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mReference.addChildEventListener(mChild);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }
}
