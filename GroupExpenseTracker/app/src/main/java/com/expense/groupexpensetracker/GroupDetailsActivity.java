package com.expense.groupexpensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Toast;


import com.expense.model.Expense;
import com.expense.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupDetailsActivity extends AppCompatActivity {

    String companies[] = {"Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung"};
    String os[]       =  {"Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada"};

    TableLayout tl;
    TableRow tr;
    TextView companyTV,valueTV;
    TextView userName, description, date, amount;
    Button action;
    TextView groupName;

    private List<Expense> expenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);
        tl = (TableLayout) findViewById(R.id.expenseTableId);
        groupName = (TextView) findViewById(R.id.groupNameId);
        groupName.setText("Group 1");
        addHeaders();
        expenses = getExpenses(1);

        addData();

    }

    private List<Expense> getExpenses(int id){
        expenses = new ArrayList<>();
        Expense expense = new Expense();
        expense.setAmount("100");
        expense.setDate("17/8/15");
        expense.setDesc("Item 1");
        expense.setUserName("Kalmesh Bhavi");
        expenses.add(expense);
        Expense expense2 = new Expense();
        expense2.setAmount("200");
        expense2.setDate("17/8/15");
        expense2.setDesc("Item 2");
        expense2.setUserName("Avinash kivanda");
        expenses.add(expense);
        return expenses;
    }
    /** This function add the headers to the table **/
    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        TextView userNameTV = new TextView(this);
        userNameTV.setText("Name ");
        userNameTV.setTextColor(Color.RED);
        userNameTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        userNameTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        userNameTV.setPadding(10, 10, 10, 0);
        userNameTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
        tr.addView(userNameTV);  // Adding textView to tablerow.

        TextView descTV = new TextView(this);
        descTV.setText("Description");
        descTV.setTextColor(Color.RED);
        descTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        descTV.setPadding(10, 10, 10, 0);
        descTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
       // descTV.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tr.addView(descTV);  // Adding textView to tablerow.

        TextView amountTV = new TextView(this);
        amountTV.setText("Amount");
        amountTV.setTextColor(Color.RED);
        amountTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        amountTV.setPadding(5, 5, 5, 0);
        amountTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
        tr.addView(amountTV);  // Adding textView to tablerow.

        TextView dateTV = new TextView(this);
        dateTV.setText("Date");
        dateTV.setTextColor(Color.RED);
        dateTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        dateTV.setPadding(5, 5, 5, 0);
        dateTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
        tr.addView(dateTV);  // Adding textView to tablerow.

        TextView actionTV = new TextView(this);
        actionTV.setText("");
        actionTV.setTextColor(Color.RED);
        actionTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        actionTV.setPadding(5, 5, 5, 0);
        actionTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
        tr.addView(actionTV);  // Adding textView to tablerow.
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(Color.GREEN);
        divider.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(Color.GREEN);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
      /*  TextView companyTV = new TextView(this);
        companyTV.setText("Companies");
        companyTV.setTextColor(Color.GRAY);
        companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        companyTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        companyTV.setPadding(5, 5, 5, 0);
        tr.addView(companyTV);  // Adding textView to tablerow.

        *//** Creating another textview **//*
        TextView valueTV = new TextView(this);
        valueTV.setText("Operating Systems");
        valueTV.setTextColor(Color.GRAY);
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        valueTV.setPadding(5, 5, 5, 0);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        *//** Creating another textview **//*
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(Color.GREEN);
        divider.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(Color.GREEN);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));*/
    }

    /** This function add the data to the table **/
    public void addData(){

        for (int i=0; i< expenses.size() ; i++){
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
            userName = new TextView(this);
            userName.setText(expenses.get(i).getUserName());
            userName.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //userName.setPadding(5, 5, 5, 5);
            tr.addView(userName);

            description = new TextView(this);
            description.setText(expenses.get(i).getDesc());
            description.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            description.setPadding(5, 5, 5, 5);
            tr.addView(description);

            amount = new TextView(this);
            amount.setText(expenses.get(i).getAmount());
            amount.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            amount.setPadding(5, 5, 5, 5);
            tr.addView(amount);

            date = new TextView(this);
            date.setText(expenses.get(i).getDate());
            date.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            date.setPadding(5, 5, 5, 5);
            tr.addView(date);

            action = new Button(this);
            action.setPadding(5,5,5,5);
            action.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            action.setText("Delete");
            action.setId(i);
            action.setOnClickListener(new ExpenseDeleteCallback());
            tr.addView(action);
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }

       /* for (int i = 0; i < companies.length; i++)
        {
            *//** Create a TableRow dynamically **//*
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            *//** Creating a TextView to add to the row **//*
            companyTV = new TextView(this);
            companyTV.setText(companies[i]);
            companyTV.setTextColor(Color.RED);
            companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            companyTV.setPadding(5, 5, 5, 5);
            tr.addView(companyTV);  // Adding textView to tablerow.

            *//** Creating another textview **//*
            valueTV = new TextView(this);
            valueTV.setText(os[i]);
            valueTV.setTextColor(Color.GREEN);
            valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            valueTV.setPadding(5, 5, 5, 5);
            valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(valueTV); // Adding textView to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group_details, menu);
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

    public class ExpenseDeleteCallback implements Button.OnClickListener {
        @Override
        public void onClick(View v) {

            Toast.makeText(getApplicationContext(), "Selected ID "+v.getId(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(GroupDetailsActivity.this, AddExpense.class);
            startActivity(intent);
        }
    }
}
