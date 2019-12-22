package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

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
    String[] listItem= {"1.0", "1.1", "1.5", "1.6", "2.0", "2.2", "2.3", "3.0", "4.0", "4.1", "4.4", "5.0", "6.0", "7.0"};
    ArrayList<String> stringArrayList=new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
        listView=(ListView)findViewById(R.id.chatpage_listview);
        textView=(TextView)findViewById(R.id.mylisttexxtview);
        message=(EditText)findViewById(R.id.chatpage_message_et);
        send=(ImageButton)findViewById(R.id.chatpage_send_imageButton);
        message.setScroller(new Scroller(this));
        message.setMaxLines(5);
        message.setVerticalScrollBarEnabled(true);
        message.setMovementMethod(new ScrollingMovementMethod());
        stringArrayList.addAll(Arrays.asList(listItem));
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sms=message.getText().toString();
                stringArrayList.add(sms);
                adapter = new ArrayAdapter<String>(ChatPage.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, stringArrayList);
                listView.setAdapter(adapter);

            }
        });


        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, stringArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position).toString();
                Toast.makeText(ChatPage.this,value,Toast.LENGTH_SHORT).show();

            }
        });


    }
}
