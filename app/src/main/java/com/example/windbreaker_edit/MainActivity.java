package com.example.windbreaker_edit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawrView;     //슬라이드 메뉴바
    private TextView menu1,menu2,menu3;
    private EditText edit_serach;
    private Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_activity_main);
        //******************메뉴바
        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        drawrView = (View) findViewById(R.id.drawer);
        drawerLayout.addDrawerListener(listener);
        drawrView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        //**************************************
        Button btn_open=(Button)findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(!drawerLayout.isDrawerOpen(Gravity.LEFT)){
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        //*************버튼 누르면 메뉴 열림
        menu1=(TextView)findViewById(R.id.menu_1);
        menu2=(TextView)findViewById(R.id.menu_2);
        menu3=(TextView)findViewById(R.id.menu_3);
        menu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        menu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        menu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        //*****************메뉴로 액티비티 이동
        edit_serach=findViewById(R.id.edit_search);
        btn_search=findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str = edit_serach.getText().toString();
                Intent intent=new Intent(MainActivity.this,TourListActivity.class);
                intent.putExtra("search_value",str);
                startActivity(intent);
            }
        });
        //***********검색어 받아서 TourListAcitivity로 넘기고 실행
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}