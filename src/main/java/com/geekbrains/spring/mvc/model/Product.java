package com.geekbrains.spring.mvc.model;

public class Product {
    private Long id;
    private String name;
    private int cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Product(Long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }
}
