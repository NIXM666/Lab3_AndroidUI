package com.example.king.lab3_androidui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10069 on 2017/3/21.
 */
public class ContextMenuActivity extends AppCompatActivity {
    private ListView lv;
    private String[] optionsitem = {"One", "Two", "Three", "Four", "Five"};
    private ActionMode mode;
    private ActionMode.Callback menuCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_context);
        lv = (ListView) findViewById(R.id.menu_context);
        lv.setSelector(R.color.colorPrimary);
        SimpleAdapter ad = new SimpleAdapter(
                this,
                getData(),
                R.layout.activity_menu_context,
                new String[]{"OptionImg", "OptionItem"},
                new int[]{R.id.OptionImg, R.id.OptionItem}
        );
        lv.setAdapter(ad);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setSelector(R.color.colorPrimary);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(mode != null){
                    return true;
                }
                mode = startSupportActionMode(menuCallBack);
                return false;
            }
        });
    }


    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < optionsitem.length; i++) {
            map = new HashMap<String, Object>();
            map.put("OptionImg", R.mipmap.ic_launcher);
            map.put("OptionItem", optionsitem[i]);
            list.add(map);
        }
        return list;
    }
}
