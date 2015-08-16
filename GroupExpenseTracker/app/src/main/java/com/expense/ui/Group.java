package com.expense.ui;

import android.widget.TextView;

/**
 * Created by Kalmeshwar on 8/16/2015.
 */
public class Group {

    private TextView userName;
    private TextView description;
    private TextView amount;
    private TextView date;

    public TextView getUserName() {
        return userName;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public TextView getAmount() {
        return amount;
    }

    public void setAmount(TextView amount) {
        this.amount = amount;
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }
}
