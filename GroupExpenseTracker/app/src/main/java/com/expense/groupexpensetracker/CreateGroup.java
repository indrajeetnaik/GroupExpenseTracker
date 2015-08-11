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
import com.expense.model.Group;
import com.expense.model.User;

public class CreateGroup extends AppCompatActivity {


    private  EditText groupNameText;
    private Button createGroupBtn;
    private ExpenseDatabase database = new ExpenseDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        final User user = (User) getIntent().getExtras().get("user");
        groupNameText = (EditText) findViewById(R.id.newGroupNameId);
        createGroupBtn = (Button) findViewById(R.id.createGroupdBtnId);

        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = groupNameText.getText().toString();
                Toast.makeText(getApplicationContext(),"Group " + groupName ,Toast.LENGTH_LONG).show();
                if(groupName == null || groupName.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please provide group subject" ,Toast.LENGTH_LONG).show();
                }else{
                    Group group = new Group();
                    group.setGroupName(groupName);
                    group.setGroupDesc(groupName);
                    group.getMembers().add(user);
                    Integer groupId = database.getGroups().size() +1;
                    group.setGroupId(groupId);
                    database.getGroups().put(groupId, group);
                    Intent addMemberIntent = new Intent(CreateGroup.this, AddMember.class);
                    addMemberIntent.putExtra("group", group);
                    startActivity(addMemberIntent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_group, menu);
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
