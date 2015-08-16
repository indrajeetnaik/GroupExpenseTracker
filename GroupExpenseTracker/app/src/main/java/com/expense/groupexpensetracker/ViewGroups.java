package com.expense.groupexpensetracker;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.expense.model.Group;

import java.util.ArrayList;
import java.util.List;

public class ViewGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);

        TextView userId = (TextView) findViewById(R.id.userId);
        ListView groupdListId = (ListView) findViewById(R.id.userGroupListId);

        userId.setText("Hello, Sachya");
        final List<Group> groups = new ArrayList<>();
        groups.add(new Group(1, "Group 1", "Group 1 Desc"));
        groups.add(new Group(2, "Group 2", "Group 2 Desc"));
        groups.add(new Group(3, "Group 3", "Group 3 Desc"));
        groups.add(new Group(4, "Group 4", "Group 4 Desc"));


        ArrayAdapter<Group> adapter = new ArrayAdapter<Group>(this,
                android.R.layout.simple_list_item_1, groups);

        groupdListId.setAdapter(adapter);

        groupdListId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                Integer i = new Integer(String.valueOf(id));
                Toast.makeText(getBaseContext(), "" +groups.get(i).getGroupId(), Toast.LENGTH_LONG).show();

                Intent viewGroupDetailsVIntent = new Intent(ViewGroups.this, GroupDetailsActivity.class);
                viewGroupDetailsVIntent.putExtra("group", groups.get(i));
                startActivity(viewGroupDetailsVIntent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_groups, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
