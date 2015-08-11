package com.expense.groupexpensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.expense.database.ExpenseDatabase;
import com.expense.model.Group;
import com.expense.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class AddMember extends AppCompatActivity/* implements Contact.OnFragmentInteractionListener*/{

    ArrayList<String> persons = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<User> users = new ArrayList<>();
    Group group;

    ExpenseDatabase db = new ExpenseDatabase();


    EditText numText;
    Button btn;
    ListView listView;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        group = (Group) getIntent().getExtras().get("group");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        numText = (EditText) findViewById(R.id.memberId);
        btn =(Button) findViewById(R.id.addContactBtn);
        submit = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String num = numText.getText().toString();
                numText.getText().clear();
                User user = getUser(num);
                if(user != null){
                    persons.add(num);
                    users.add(user);
                    adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, persons);
                    listView = (ListView) findViewById(R.id.listView);
                    listView.setAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "User is not registered", Toast.LENGTH_LONG).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    group.getMembers().addAll(users);
            }
        });
    }

    private User getUser(String num){

    Map<String, User> userMap = db.getUsers();
        for (User user: userMap.values()) {
            if(user == null)
                continue;
            if(num.equals(user.getMobileNum())){
                return user;
            }
        }
        return null;
    }
 /* @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }*/
   /* @Override
    public void onFragmentInteraction(String phoneNum) {
        ContactList textFragment =
                (ContactList)
                        getFragmentManager().findFragmentById(R.id.contactListFragment);
        textFragment.setContactNumber(phoneNum);
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_member, menu);
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
