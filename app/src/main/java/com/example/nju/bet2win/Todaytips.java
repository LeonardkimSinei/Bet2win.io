package com.example.nju.bet2win;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by nju on 6/19/2017.
 */
 public class Todaytips extends Activity{

    private TextView MsgTxt;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

    //

    private ArrayList<String> tipList = new ArrayList<>();
    private ListView tip_view;
   @Override
    protected void onCreate (Bundle savedInstanceState)
   {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.todaytips);

        //firebaseDatabase.setPersistenceEnabled(true);
       DatabaseReference mRootReference=firebaseDatabase.getReference("tips");
       tip_view = (ListView) findViewById(R.id.tip_list);
       final ArrayAdapter tipAdapter = new ArrayAdapter(Todaytips.this, android.R.layout.simple_list_item_1, tipList);
       tip_view.setAdapter(tipAdapter);



        mRootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, Object> tips = (HashMap<String, Object>) dataSnapshot.getValue();

                for(Object tip: tips.values()){
                    HashMap<String, Object> tipMap = (HashMap<String, Object>) tip;
                    String today_tip = (String) tipMap.remove("todayTip");

                    tipList.add(today_tip);
                    tipAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       //getActionBar().setDisplayHomeAsUpEnabled(true);

       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // If your minSdkVersion is 11 or higher, instead use:


       //my added code
       //scoresRef.keepSynced(false);
       //DatabaseReference mRootReference = FirebaseDatabase.getInstance().getReference("message");
       //mRootReference.keepSynced(true);
     // FirebaseDatabase.getInstance().setPersistenceEnabled(true);


   }
   @Override
    protected void onStart()
   {
       super.onStart();

   }

};