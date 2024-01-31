package com.perscholas.model;


import java.util.HashMap;
import java.util.Map;

public class Shop {
    public Map<String, Product> products;
    //private Map<String, Product> products;

    public Shop() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public int getProductStock(String name) {
        Product product = products.get(name);
        if (product == null) {
            return 0;
        }
        return product.getStock();
    }
}
