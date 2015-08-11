package com.expense.groupexpensetracker;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.expense.database.ExpenseDatabase;
import com.expense.model.User;

import java.util.List;
import java.util.Map;


public class Expense extends Activity {

    ExpenseDatabase db = new ExpenseDatabase();

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_expense);
         final EditText userNameText = (EditText) findViewById(R.id.userNameValue);
         final EditText passwordText = (EditText) findViewById(R.id.passwordValue);
         Button signInBtn = (Button) findViewById(R.id.signInBtnId);
         Button signUpBtn = (Button) findViewById(R.id.signUpBtnId);

         signInBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                String userName = userNameText.getText().toString();
                 String password = passwordText.getText().toString();
                 if(isValidUser(userName,password)){
                     Intent homeScreen = new Intent(Expense.this, Home.class);
                     homeScreen.putExtra("user", db.getUsers().get(userName));
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

    private boolean isValidUser(String userName, String password){
        if(userName.isEmpty() || password.isEmpty()){
            return false;
        }

        Map<String , User> usersMap = db.getUsers();
        User user = usersMap.get(userName);
        if(null == user){
            return false;
        }
        if(!userName.equals(user.getName()) && !password.equals(user.getPassword())){
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
