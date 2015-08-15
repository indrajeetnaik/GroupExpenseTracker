package com.group.expense.config;

import com.group.expense.controller.ExpenseController;
import com.group.expense.controller.GroupController;
import com.group.expense.controller.ItemController;
import com.group.expense.controller.SignUpController;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(SignUpController.class);
        register(ExpenseController.class);
        register(ItemController.class);
        register(GroupController.class);
    }
}
