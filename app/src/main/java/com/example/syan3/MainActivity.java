package com.example.syan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private int []picture = new int[]{R.drawable.cat,R.drawable.dog,R.drawable.elephant,
            R.drawable.lion,R.drawable.monkey,R.drawable.tiger,
    };//用来存放要显示的图片资源, 因为图片资源在AS中是以整数为标签存在的, 所以我们用int类型的数组来保存.
    private String []text = new String[]{
            "cat","dog","elephant","lion","monkey","tiger"
    };//用来存储将要显示的文本信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(int i = 0;i < text.length; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",picture[i]);
            map.put("name",text[i]);
            mapList.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, mapList,R.layout.cell,new String[]{"image","name"},new int[]{R.id.image,R.id.name});
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("name").toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
