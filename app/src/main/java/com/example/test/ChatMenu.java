package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ChatMenu extends AppCompatActivity {
    String[] version = {"قسم النظم", "المكافحة", "الامن الحربي", " السكرتارية"};
    String[] versionNumber = {"1.0", "1.1", "1.5", "1.6"};
    int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher};


    ListView lView;

    ListAdapter lAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_menu);

        lView = (ListView) findViewById(R.id.chatmenu_listview);

        lAdapter = new ListAdapter(this, version, versionNumber, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ChatMenu.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ChatMenu.this,ChatPage.class);
                startActivity(intent);


            }
        });

    }
}