package com.labs.spring.studentapp;

public class Category {
    private int catId;
    private String catName;

    public Category(int catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                '}';
    }
}
