/**
 * 
 */
package com.group.expense.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AKivanda
 *
 */
@XmlRootElement
public class Expense {

    private User user;

    private Group group;

    private Item item;

    private Integer expenseAmount;

    private Date createdDate;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the expenseAmount
     */
    public Integer getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * @param expenseAmount the expenseAmount to set
     */
    public void setExpenseAmount(Integer expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
