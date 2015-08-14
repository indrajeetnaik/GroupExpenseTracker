/**
 * 
 */
package com.group.expense.dao;

import com.group.expense.mapper.ItemSqlMapper;
import com.group.expense.model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AKivanda
 *
 */
@Component
public class ItemDao {

    @Autowired
    private ItemSqlMapper itemSqlMapper;

    public List<Item> getAllItems() {
        return itemSqlMapper.getAllItems();
    }

}
