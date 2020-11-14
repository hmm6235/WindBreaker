package kr.ac.koreatech.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }
    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if(convertView == null){    // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_tourlistitems,parent,false);
        }
              TextView name=(TextView) convertView.findViewById(R.id.listItem_Name);
        TextView address=(TextView) convertView.findViewById(R.id.listItem_Address);
        TextView tel=(TextView) convertView.findViewById(R.id.listItem_Tel);

        ListViewItem listViewItem = listViewItems.get(position);

        name.setText(listViewItem.getName());
        address.setText(listViewItem.getAddress());
        tel.setText(listViewItem.getTel());

        return convertView;
    }
    public void addItem(String name, String address, String tel){
        ListViewItem item = new ListViewItem();

        item.setName(name);
        item.setAddress(address);
        item.setTel(tel);
        listViewItems.add(item);
    }
}
