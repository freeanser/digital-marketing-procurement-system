/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.OrderItem;
import model.OrderManagement.SolutionOfferOrderItem;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    String name;
    ArrayList<Product> products;
    int price;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;
    ArrayList<SolutionOfferOrderItem> solutionOfferOrderItems;
    SolutionOfferCatalog solutionOfferCatalog;

    // public SolutionOffer(MarketChannelAssignment m) {
    // marketChannelComb = m;
    // products = new ArrayList<Product>();
    // }

    public SolutionOffer(String name, MarketChannelAssignment m, ArrayList<Product> ps, int price) {
        this.name = name;
        marketChannelComb = m;
        products = ps;
        solutionOfferOrderItems = new ArrayList<SolutionOfferOrderItem>();
        this.price = price; // total price of the solution offer
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addProducts(ArrayList<Product> newproducts) {
        products.addAll(newproducts);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void findProductsName() {
        Faker faker = new Faker();
        int index = 1;
        for (Product p : products) {
            String fakeName = faker.commerce().productName();
            p.setName(fakeName);
            System.out.println("(" + index + ")" + p.getName());
            index++;
        }
    }

    public void finProductsIngredientName() {
        Faker faker = new Faker();
        int index = 1;
        for (Product p : products) {
            String ingredientName = faker.food().ingredient();
            p.setName(ingredientName);
            System.out.println("(" + index + ")" + p.getName());
            index++;
        }
    }

    public void setPrice(int p) {
        price = p;

    }

    public int getPrice() {
        return price;
    }

    public MarketChannelAssignment getMarketChannelComb() {
        return marketChannelComb;
    }

    public void setMarketChannelComb(MarketChannelAssignment marketChannelComb) {
        this.marketChannelComb = marketChannelComb;
    }

    public ArrayList<SolutionOfferOrderItem> getSolutionOfferOrderItems() {
        return solutionOfferOrderItems;
    }

    public void setSolutionOfferOrderItems(ArrayList<SolutionOfferOrderItem> solutionOfferOrderItems) {
        this.solutionOfferOrderItems = solutionOfferOrderItems;
    }

    public void addSolutionOfferOrderItem(SolutionOfferOrderItem sooi) {
        solutionOfferOrderItems.add(sooi);
    }

    // public int getSalesVolume(int price, int quantity) {
    // // price = this.getPrice();
    // int sum = 0;
    // for (SolutionOfferOrderItem soi : solutionOfferOrderItems) {
    // sum = sum + soi.getRandomSolutionOrderItemTotal(price, quantity);
    // }
    // return sum;
    // }

    public int getSalesVolume(int price, int quantity) {

        int sum = 0;
        for (SolutionOfferOrderItem soi : solutionOfferOrderItems) {

            sum += soi.getRandomSOITotal(price, quantity);
            // System.out.println("getSalesVolume - sum: " + sum);
        }
        return sum;
    }

    public SolutionOfferCatalog getSolutionOfferCatalog() {
        return solutionOfferCatalog;
    }

    public void setSolutionOfferCatalog(SolutionOfferCatalog solutionOfferCatalog) {
        this.solutionOfferCatalog = solutionOfferCatalog;
    }

}
