package kr.ac.koreatech.mainactivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

public class TourListActivity extends AppCompatActivity {


    private ListView listView;
    ListViewAdapter adapter;
    private ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourlist);


        String str = getIntent().getExtras().getString("search_value");

        adapter = new ListViewAdapter();
        listView = findViewById(R.id.list_tourlist);
        listView.setAdapter(adapter);
        adapter.addItem("가평","천안","010214141");
        adapter.addItem("가평","천안","010214141");
        adapter.addItem("가평","천안","010214141");
        adapter.addItem("가평","천안","010214141");
        adapter.addItem("가평","천안","010214141");
        adapter.addItem(str,"asdf","saf");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(TourListActivity.this,"asdg",Toast.LENGTH_SHORT);
            }
        });
    }
}
