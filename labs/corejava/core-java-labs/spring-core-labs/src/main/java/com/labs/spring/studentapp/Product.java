package com.labs.spring.studentapp;

public class Product {
    private int pid;
    private String pname;
    private Category category;

    public Product(int pid, String pname, Category category) {
        this.pid = pid;
        this.pname = pname;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", category=" + category +
                '}';
    }
}
