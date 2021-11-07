package com.project.expenses;

import com.project.expenses.domain.Category;
import com.project.expenses.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@ComponentScan
@Configuration
@RequiredArgsConstructor
public class Main {
    
    private static final ExpenseService expenseService = new ExpenseService();

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        
        expenseService.addExpense(Category.FOOD, "Alex", 200);
        expenseService.addExpense(Category.FOOD, "Alex", 200);
        expenseService.printAllExpenses();
        
    }
    
}
