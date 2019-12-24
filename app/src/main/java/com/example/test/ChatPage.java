package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ChatPage extends AppCompatActivity{
    ListView listView;
    TextView textView;
    EditText message;
    ImageButton send;
    String[] version = {"Android Alpha", "Android Beta", "Android Cupcake", "Android Donut", "Android Eclair", "Android Froyo", "Android Gingerbread", "Android Honeycomb", "Android Ice Cream Sandwich", "Android JellyBean", "Android Kitkat", "Android Lollipop", "Android Marshmallow", "Android Nougat"};

    String[] versionNumber = {"1.0", "1.1", "1.5", "1.6", "2.0", "2.2", "2.3", "3.0", "4.0", "4.1", "4.4", "5.0", "6.0", "7.0"};
    int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher};


    ListView lView;


    ChatPageListAdaptor lAdapter;
    ArrayList<String> stringArrayList=new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);

        message=(EditText)findViewById(R.id.chatpage_message_et);
        send=(ImageButton)findViewById(R.id.chatpage_send_imageButton);
        message.setScroller(new Scroller(this));
        message.setMaxLines(5);
        message.setVerticalScrollBarEnabled(true);
        message.setMovementMethod(new ScrollingMovementMethod());
       // stringArrayList.addAll(Arrays.asList(version));
        lView = (ListView) findViewById(R.id.chatpage_listview);

        lAdapter = new ChatPageListAdaptor(this, version, versionNumber, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ChatPage.this, version[i]+" "+versionNumber[i], Toast.LENGTH_SHORT).show();



            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sms=message.getText().toString();
                stringArrayList.add(sms);
                lAdapter = new ChatPageListAdaptor(ChatPage.this, version, versionNumber, images);

                lView.setAdapter(lAdapter);

            }
        });





    }
}
