package ro.gshmedia.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Product {

    private String name;
    @Id
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private int stock;
}
