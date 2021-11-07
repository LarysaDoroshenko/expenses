package com.project.expenses.service;

import com.project.expenses.domain.Category;
import com.project.expenses.domain.Debt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ExpenseService {
    
    private final Map<Category, List<Debt>> debts = new HashMap<>();
    
    public void addExpense(Category category, String name, Integer amount) {
        Debt debt = createNewDebt(category, name, amount);
        List<Debt> debtList = debts.getOrDefault(category, new ArrayList<>());
        debtList.add(debt);

        debts.put(category, debtList);
    }

    private Debt createNewDebt(Category category, String name, Integer amount) {
        Debt debt = new Debt();
        debt.setName(name);
        debt.setCategory(category);
        debt.setAmount(amount);
        debt.setCreatedAt(ZonedDateTime.now());
        debt.setOpen(true);
        return debt;
    }

    public void printAllExpenses() {
        System.out.println("All debts:");
        for (Map.Entry<Category, List<Debt>> debt : debts.entrySet()) {
            System.out.println(debt.getKey());
            debt.getValue().forEach(System.out::println);
        }
    }
    
}
