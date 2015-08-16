package com.expense.groupexpensetracker;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.expense.model.Group;
import com.expense.model.User;
import com.expense.service.GroupService;
import com.expense.util.ServiceUtil;
import com.expense.util.UserSessionManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        session = new UserSessionManager(getApplicationContext());
        final HashMap<String, String> users = session.getUserDetails();
        List<Group> groups = GroupService.viewYourGroups(users.get("userName"));
        Button createGroupBtnId = (Button) findViewById(R.id.createGroupBtnId);
        Button viewGroupsBtnID = (Button) findViewById(R.id.viewGroupsBtnId);
        if(groups.size()<=0){
            viewGroupsBtnID.setVisibility(View.GONE);
        }
        TextView userName = (TextView) findViewById(R.id.userMessageId);
        if(users.get("userName") != null){
            userName.setText("Welcome " + users.get("userName"));
        }
        createGroupBtnId.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,CreateGroup.class);
                intent.putExtra("user", users.get("userId"));
                startActivity(intent);
            }
        });
        viewGroupsBtnID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,ViewGroups.class);
                //intent.putExtras("groups", groups);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
