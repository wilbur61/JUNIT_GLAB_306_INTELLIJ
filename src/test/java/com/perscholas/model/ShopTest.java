package com.perscholas.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTest {

    //private Shop shop;
    public Shop shop;
    @BeforeEach
    public void setUp() {
        shop = new Shop();
    }

    @AfterEach
    public void tearDown() {
        shop.products.clear(); // Reset shop's stock to zero after each test
    }

    @Test
    public void testAddProduct() {
        String productName = "T-Shirt";
        double price = 19.99;
        int initialStock = 1;
        int expectedStock = 1;

        Product product = new Product(productName, price, initialStock);
        shop.addProduct(product);

        int actualStock = shop.getProductStock(productName);

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testAddDuplicateProduct() {
        String productName = "Mug";
        double price = 9.99;
        int initialStock = 2;
        int expectedStock = 2;

        Product product = new Product(productName, price, initialStock);
        shop.addProduct(product);
        shop.addProduct(product); // Add the same product twice

        int actualStock = shop.getProductStock(productName);

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testGetProductStock() {
        String productName = "Hat";
        double price = 14.99;
        int initialStock = 5;

        Product product = new Product(productName, price, initialStock);
        shop.addProduct(product);

        int expectedStock = initialStock;
        int actualStock = shop.getProductStock(productName);

        assertEquals(expectedStock, actualStock);
    }

    @Test
    public void testAddProductWithNegativePrice() {
        String productName = "Water Bottle";
        double price = -5.00; // Negative price
        int initialStock = 10;

        assertThrows(IllegalArgumentException.class, () -> shop.addProduct(new Product(productName, price, initialStock)));
    }

    @Test
    public void testAddProductWithNegativeStock() {
        String productName = "Notebook";
        double price = 7.99;
        int initialStock = -20; // Negative stock

        assertThrows(IllegalArgumentException.class, () -> shop.addProduct(new Product(productName, price, initialStock)));
    }

}
