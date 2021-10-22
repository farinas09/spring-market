package com.farinas.market.domain.dto;

import java.sql.Timestamp;

public class Category {
    private int categoryId;
    private String description;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
