/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> suppliers;

    public SupplierDirectory() {
        suppliers = new ArrayList<Supplier>();
    }

    public ArrayList<Supplier> getSupplierList() {
        return suppliers;
    }

    public Supplier newSupplier(String n) {
        Supplier supplier = new Supplier(n);
        suppliers.add(supplier);
        return supplier;
    }

    public Supplier findSupplier(String id) {

        for (Supplier supplier : suppliers) {

            if (supplier.getName().equals(id))
                return supplier;
        }
        return null;
    }

    // find all products from all suppliers
    public ArrayList<Product> findAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        for (Supplier s : suppliers) {
            for (Product p : s.getProductCatalog().getProductList()) {
                products.add(p);
            }
        }
        return products;
    }

    public Supplier pickRandomSupplier() {
        if (suppliers.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(suppliers.size());
        return suppliers.get(randomIndex);
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the supplier directory.");
        System.out.println("There are " + suppliers.size() + " suppliers.");
        for (Supplier s : suppliers) {
            s.printShortInfo();
        }
    }

}