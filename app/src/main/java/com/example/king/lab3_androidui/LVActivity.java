package com.example.king.lab3_androidui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 10069 on 2017/3/14.
 */
public class LVActivity extends Activity {
    private ListView listview;
    private int[] imgData = {R.drawable.cat, R.drawable.dog, R.drawable.elephant, R.drawable.lion, R.drawable.monkey, R.drawable.tiger};
    private String[] imgName = {"cat", "dog", "elephant", "lion", "monkey", "tiger"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listview = (ListView) findViewById(R.id.lv);
        listview.setSelector(R.color.colorAccent);
        SimpleAdapter adpater = new SimpleAdapter(
                this,
                getData(),
                R.layout.activity_listview,
                new String[]{"name", "img"},
                new int[]{R.id.name, R.id.img}
        );
        listview.setAdapter(adpater);
        showInfo();
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < imgData.length; i++) {
            map = new HashMap<String, Object>();
            map.put("name", imgName[i]);
            map.put("img", imgData[i]);
            list.add(map);
        }
        return list;
    }

    private void showInfo() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(LVActivity.this, imgName[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
