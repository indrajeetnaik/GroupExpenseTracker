package com.group.expense.mapper;

import com.group.expense.model.Item;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemSqlMapper {

    List<Item> getAllItems();

}
