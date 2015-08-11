package com.expense.model;

import java.util.Date;

/**
 * Created by Kalmeshwar on 8/6/2015.
 */
public class Expense {

    private long id;
    private Group group;
    private String description;
    private Date purchasedOn;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(Date purchasedOn) {
        this.purchasedOn = purchasedOn;
    }
}
