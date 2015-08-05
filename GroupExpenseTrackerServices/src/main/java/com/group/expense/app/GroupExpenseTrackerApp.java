/**
 * 
 */
package com.group.expense.app;

import com.group.expense.config.DataBaseconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author AKivanda
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.group.expense.*")
@Import({DataBaseconfiguration.class})
public class GroupExpenseTrackerApp {

    public static void main(String[] args) {
        SpringApplication.run(GroupExpenseTrackerApp.class, args);
    }

}
