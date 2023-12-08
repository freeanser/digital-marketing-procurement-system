/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.CustomerManagement.CustomerProfile;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products; // list of products initially empty

    public ProductCatalog(String n) {
        type = n;
        products = new ArrayList<Product>(); /// create the list of elements otherwise it is null
    }

    // new ProductCatalog(); or new ProductCatalog("Printers");
    public ProductCatalog() {
        type = "unknown";
        products = new ArrayList<Product>();
    }

    public Product newProduct(int fp, int cp, int tp) {
        Product p = new Product(fp, cp, tp);
        products.add(p);
        return p;
    }

    public Product newProduct(String n, int fp, int cp, int tp) {
        Product p = new Product(n, fp, cp, tp);
        products.add(p);
        return p;
    }

    public ProductsReport generateProductPerformanceReport(String sortingRule) {
        ProductsReport productsReport = new ProductsReport(sortingRule);

        for (Product p : products) {

            ProductSummary ps = new ProductSummary(p);
            productsReport.addProductSummary(ps);
        }
        return productsReport;
    }

    public ArrayList<Product> getProductList() {
        return products;
    }

    public Product pickRandomProduct() {
        if (products.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(products.size());
        return products.get(randomIndex);
    }

    public ArrayList<Product> newRandomProducts(ArrayList<Product> productsList, int count) {
        if (productsList.size() == 0) {
            System.out.println("Cannot find Product list!");
        }
        ;
        // Pick random Products
        Set<Product> productSet = new HashSet<>();
        while (productSet.size() < count) {
            Random r = new Random();
            int randomIndex = r.nextInt(productsList.size());
            productSet.add(productsList.get(randomIndex));
        }
        ArrayList<Product> newProducts = new ArrayList<>(productSet);
        return newProducts;
    }

    public void printShortInfo() {
        System.out.println("There are " + products.size() + " products in this catalog");
    }

}
