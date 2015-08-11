package com.expense.groupexpensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.expense.database.ExpenseDatabase;
import com.expense.model.User;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {


    private ExpenseDatabase database = new ExpenseDatabase();

    private EditText nameText;
    private EditText passwordText;
    private EditText emailText;
    private EditText confirmPasswordText;
    private EditText mobileNumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameText = (EditText) findViewById(R.id.etName);
        passwordText = (EditText) findViewById(R.id.etPassword);
        emailText = (EditText) findViewById(R.id.etEmail);
        confirmPasswordText = (EditText) findViewById(R.id.etConfirmPassword);
        mobileNumText = (EditText) findViewById(R.id.etMobileNum);



        Button regSubBtn = (Button) findViewById(R.id.regFormSubBtn);

        regSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String password = passwordText.getText().toString();
                String confirmPassword = confirmPasswordText.getText().toString();
                String mobileNum = mobileNumText.getText().toString();
                String email = emailText.getText().toString();

                if(isValidateRegistrationForm(name, email, password, confirmPassword, mobileNum)){
                    User user = new User();
                    user.setName(name);
                    user.setEmailAddress(email);
                    user.setIsAdmin(true);
                    user.setMobileNum(mobileNum);
                    user.setPassword(password);
                    database.getUsers().put(name, user);
                    Intent intent = new Intent(Registration.this, Home.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean isValidateRegistrationForm(String name, String email, String password, String confirmPassword, String mobileNum) {
        if(name == null || name.isEmpty()){
            Toast.makeText(getApplicationContext(), "Name is empty", Toast.LENGTH_LONG).show();
            return false;
        }

        if(email == null || email.isEmpty()){
            Toast.makeText(getApplicationContext(),"Email is empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if(password == null || password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Password is empty",Toast.LENGTH_LONG).show();
            return false;
        }
        if(password.length() <6){
            Toast.makeText(getApplicationContext(),"Password should contain minimum 6 characters",Toast.LENGTH_LONG).show();
            return false;
        }

        if(confirmPassword == null || confirmPassword.isEmpty()){
            Toast.makeText(getApplicationContext(),"Confirm password is empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if(!password.equals(confirmPassword)){
            Toast.makeText(getApplicationContext(),"Password and confirm password doesn't match",Toast.LENGTH_LONG).show();
            return false;
        }
        if(mobileNum == null || mobileNum.isEmpty()){
            Toast.makeText(getApplicationContext(),"Mobile number is empty",Toast.LENGTH_LONG).show();
            return  false;
        }
        if(mobileNum.length() < 10){
            Toast.makeText(getApplicationContext(),"Invalid Mobile number",Toast.LENGTH_LONG).show();
            return  false;
        }
        return  true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
