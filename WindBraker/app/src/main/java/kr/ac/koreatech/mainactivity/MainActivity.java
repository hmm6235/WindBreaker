package kr.ac.koreatech.mainactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawrView;     //슬라이드 메뉴바
    private TextView menu1,menu2,menu3;
    private EditText edit_serach;
    private Button btn_search;
    private ImageView img;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //******************메뉴바
        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        drawrView = (View) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(listener);
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
        img=(ImageView)findViewById(R.id.img_flower);
        menu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        menu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getBaseContext(),TourListActivity.class);
                intent.putExtra("search_value","");
                startActivity(intent);
            }
        });
        menu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getBaseContext(),BicycleListActivity.class);
                intent.putExtra("search_value","");
                startActivity(intent);
            }
        });

        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count=(count+1)%5;
                switch (count){
                    case 0:
                        img.setImageResource(R.drawable.img1);
                        break;
                    case 1:
                        img.setImageResource(R.drawable.img2);

                        break;
                    case 2:
                        img.setImageResource(R.drawable.img3);

                        break;
                    case 3:
                        img.setImageResource(R.drawable.img4);

                        break;
                    case 4:
                        img.setImageResource(R.drawable.img5);

                        break;
                }



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