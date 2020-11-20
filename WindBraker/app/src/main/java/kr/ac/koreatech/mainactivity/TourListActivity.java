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
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TourListActivity extends AppCompatActivity {


    private ListView listView;
    ListViewAdapter adapter;
    List<AttractionData> value;
    MyRest t=new MyRest();
    private ArrayList<String> items = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourlist);

        String str = getIntent().getExtras().getString("search_value");

        adapter = new ListViewAdapter();
        listView = findViewById(R.id.list_tourlist);
        listView.setAdapter(adapter);
   try {

                value = t.callAttraction(str);
                for(int i=0;i<value.size();i++)
                adapter.addItem(value.get(i).getName(),value.get(i).getAddress(),value.get(i).getTel());


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(TourListActivity.this,"asdg",Toast.LENGTH_SHORT);
            }
        });
    }
}
