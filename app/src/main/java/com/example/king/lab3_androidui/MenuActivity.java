package com.example.king.lab3_androidui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 10069 on 2017/3/20.
 */
public class MenuActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_custom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.normal_menu:{
                Toast.makeText(this,"点中了普通菜单项",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.s_size:{
                TextView tv = (TextView) findViewById(R.id.test_text);
                tv.setTextSize(10);
                break;
            }
            case R.id.m_size:{
                TextView tv = (TextView) findViewById(R.id.test_text);
                tv.setTextSize(16);
                break;
            }
            case R.id.l_size:{
                TextView tv = (TextView) findViewById(R.id.test_text);
                tv.setTextSize(20);
                break;
            }
            case R.id.color_black:{
                TextView tv = (TextView) findViewById(R.id.test_text);
                tv.setTextColor(Color.rgb(0,0,0));
                break;
            }
            case R.id.color_red:{
                TextView tv = (TextView) findViewById(R.id.test_text);
                tv.setTextColor(Color.rgb(255,0,0));
                break;
            }
            default:
                break;
        }
        return true;
    }
}
