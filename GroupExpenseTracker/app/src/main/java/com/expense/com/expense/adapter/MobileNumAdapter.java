package com.expense.com.expense.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.expense.groupexpensetracker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalmeshwar on 8/9/2015.
 */
public class MobileNumAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public MobileNumAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.activity_add_member, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_add_member, parent, false);
        ListView listView =(ListView) rowView.findViewById(R.id.listView);


        return super.getView(position, convertView, parent);
    }
}
