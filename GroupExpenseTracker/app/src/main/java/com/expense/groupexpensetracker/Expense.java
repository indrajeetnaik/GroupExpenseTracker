package com.expense.groupexpensetracker;

import android.app.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.expense.database.ExpenseDatabase;
import com.expense.model.User;
import com.expense.service.UserService;
import com.expense.util.UserSessionManager;

import java.util.List;
import java.util.Map;


public class Expense extends Activity {

    private UserService userService;

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_expense);
        }else{
            setContentView(R.layout.activity_expense_landscape);
        }
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

         final EditText userNameText = (EditText) findViewById(R.id.userNameValue);
         final EditText passwordText = (EditText) findViewById(R.id.passwordValue);
         Button signInBtn = (Button) findViewById(R.id.signInBtnId);
         Button signUpBtn = (Button) findViewById(R.id.signUpBtnId);

         signInBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                User user = new User();
                 user.setUserName(userNameText.getText().toString());
                 user.setPassword( passwordText.getText().toString());
                 if(isValidUser(user)){
                    session = new UserSessionManager(getApplicationContext());
                    session.createUserLoginSession(user.getUserName(),user.getUserId());
                     Intent homeScreen = new Intent(Expense.this, Home.class);
                     startActivity(homeScreen);
                 }else{
                     Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_LONG).show();
                 }
             }
         });
         signUpBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent homeScreen = new Intent(Expense.this, Registration.class);
                 startActivity(homeScreen);
             }
         });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
//window
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

        }
    }

    private boolean isValidUser(User user){
        if(user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
         User existingUser = UserService.validateUser(user);
        if(null == existingUser){
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expense, menu);
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
