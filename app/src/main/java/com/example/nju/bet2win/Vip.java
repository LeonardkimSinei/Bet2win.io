package com.example.nju.bet2win;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nju on 7/5/2017.
 */

public class Vip extends Activity {
    //DatabaseReference dref;
    ListView listView;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter<String> adapter;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference=firebaseDatabase.getReference("vip");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip);
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list  );
        listView.setAdapter(adapter);

        //dref= FirebaseDatabase.getInstance().getReference();
        mRootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, Object> tips = (HashMap<String, Object>) dataSnapshot.getValue();

                for(Object tip: tips.values()){
                    HashMap<String, Object> tipMap = (HashMap<String, Object>) tip;
                    String today_tip = (String) tipMap.remove("todayTip");

                    list.add(today_tip);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vyip, menu);
        return true;
    }
}
