package com.android.aduino1;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClassName extends AppCompatActivity {

    ListView lv1;
    ArrayList<String> settings = new ArrayList();
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_name);

        lv1 = (ListView) findViewById(R.id.lv1);
        mDatabase = FirebaseDatabase.getInstance().getReference("ClassName");
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, settings);
        lv1.setAdapter(adapter);

        mDatabase.child(login.DataName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    String msg2 = messageData.getValue().toString();
                    adapter.add(msg2);
                    lv1.setAdapter(adapter);
                    lv1.setOnItemClickListener(onItemClickListener);
                    // child 내에 있는 데이터만큼 반복합니다.

                }
                adapter.notifyDataSetChanged();
                lv1.setSelection(adapter.getCount() - 1);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    static String CN;
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            Object vo = (Object)parent.getAdapter().getItem(position);
            for(int a = 0; a < lv1.getCount() ; a++ ) {
                CN = (String) vo;
                Intent intent = new Intent(ClassName.this, Check.class);
                startActivity(intent);
                break;

            }
        }
    };
}

