package com.expense.groupexpensetracker;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactList extends Fragment {

    private static TextView textView;

    ArrayList<String> numbers = new ArrayList<>();
    ArrayAdapter<String> adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,numbers);
        textView =(TextView) view.findViewById(R.id.contactId);
        return view;

    }

    public void setContactNumber(String num){
    textView.setText(num);
    }

}
