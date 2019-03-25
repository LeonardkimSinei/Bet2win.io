package com.example.nju.bet2win;


import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            //case R.id.action_search:
               // openSearch();
               // return true;
            case R.id.action_share:
                //openShare();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void one(View v)
    {
        //navigate to page one
        //Intent class
        //Message to OS
        Intent x = new Intent(this, Todaytips.class);
        startActivity(x);
    }
public void telegra (View v)
{
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/joinchat/AAAAAD_58ds9Wk62aOybHw")));
}
public  void plus (View v)
{
    Intent x= new Intent(this, Twoplus.class);
    startActivity(x);

}
public  void viparch (View v)
    {
        Intent x= new Intent(this, Viparchive.class);
        startActivity(x);

    }
    public  void vipee (View v)
    {
        Intent x= new Intent(this, Vip.class);
        startActivity(x);

    }


}
