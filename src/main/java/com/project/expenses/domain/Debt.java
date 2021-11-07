package com.project.expenses.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Debt {
    
    private String name;
    private Category category;
    private Integer amount;
    private ZonedDateTime createdAt;
    private boolean isOpen;
    
    @Override
    public String toString() {
        return "Debt{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", isOpen=" + isOpen +
                '}';
    }
    
}
