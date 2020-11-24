package kr.ac.koreatech.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BicycleListActivity extends AppCompatActivity {
    private TextView textview;
    private ListView listView;
    ListViewAdapter adapter;
    List<AttractionData> value;
    private TextView menu1,menu2,menu3;
    private ImageView img;
    int count=1;
  //  MyRest t=new MyRest();
    private ArrayList<String> items = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourlist);
        textview=(TextView)findViewById(R.id.text_bicyclelist);


        menu1=(TextView)findViewById(R.id.menu_1);
        menu2=(TextView)findViewById(R.id.menu_2);
        menu3=(TextView)findViewById(R.id.menu_3);
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
        //*****************메뉴로 액티비티 이동
        img=findViewById(R.id.img_flower);
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

        String str = getIntent().getExtras().getString("search_value");

        adapter = new ListViewAdapter();
        listView = findViewById(R.id.list_tourlist);
        listView.setAdapter(adapter);
  /*      try {

           value = t.callAttraction(str);
            for(int i=0;i<value.size();i++)
                adapter.addItem(value.get(i).getName(),value.get(i).getAddress(),value.get(i).getTel());


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {     //상세화면 이동
                //Toast.makeText(TourListActivity.this,"asdg",Toast.LENGTH_SHORT);
            }
        });
    }
}
