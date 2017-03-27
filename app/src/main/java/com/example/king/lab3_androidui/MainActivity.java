package com.example.king.lab3_androidui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.listview);
        btn2 = (Button) findViewById(R.id.alert);
        btn3 = (Button) findViewById(R.id.menu);
        btn4 = (Button) findViewById(R.id.contextmenu);
        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, LVActivity.class);
                                        startActivity(intent);
                                    }
                                }
        );
        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        AlertDialog ad = new AlertDialog.Builder(MainActivity.this).create();
                                        ad.show();
                                        Window window = ad.getWindow();
                                        window.setContentView(R.layout.activity_alert);

                                    }
                                }
        );
        btn3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                        startActivity(intent);
                                    }
                                }
        );
        btn4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, ContextMenuActivity.class);
                                        startActivity(intent);
                                    }
                                }
        );
    }
}
