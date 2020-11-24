package com.example.windbreaker_edit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ch_MainActivity extends AppCompatActivity {
    private ListView m_ListView;
    private ArrayAdapter<String>m_Adapter;

    public AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?>parent, View view, int position, long id){
            Toast.makeText(getApplicationContext(), m_Adapter.getItem(position),Toast.LENGTH_SHORT).show();
            if(position == 0){  //Map
                Intent intent = new Intent(ch_MainActivity.this, Main.class);
                startActivity(intent);
            }
            else if(position ==1){ // Review
                Intent intent = new Intent(ch_MainActivity.this, Review.class);
                startActivity(intent);
            }
            else if(position == 2){ // 별점
                Intent intent = new Intent(ch_MainActivity.this, StarScore.class);
                startActivity(intent);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] values = {"지도", "리뷰", "별점","주변 자전거 찾기"};
        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        m_ListView = findViewById(R.id.list);
        m_ListView.setAdapter(m_Adapter);
        m_ListView.setOnItemClickListener(onClickListItem);
    }


}