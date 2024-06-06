package ru.mirea.orlovsky.lesson5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class SensorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HashMap<String, String>> data;

    public SensorAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        HashMap<String, String> sensor = (HashMap<String, String>) getItem(position);

        TextView nameTextView = convertView.findViewById(android.R.id.text1);
        TextView typeTextView = convertView.findViewById(android.R.id.text2);

        nameTextView.setText(sensor.get("Name"));
        typeTextView.setText(sensor.get("Type"));

        return convertView;
    }
}
