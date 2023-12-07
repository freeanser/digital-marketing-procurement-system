/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.SolutionOfferOrderItem;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;
    ArrayList<SolutionOfferOrderItem> solutionOfferOrderItems;
    SolutionOfferCatalog solutionOfferCatalog;

    // public SolutionOffer(MarketChannelAssignment m) {
    // marketChannelComb = m;
    // products = new ArrayList<Product>();
    // }

    public SolutionOffer(MarketChannelAssignment m, ArrayList<Product> ps, int price) {
        marketChannelComb = m;
        products = ps;
        solutionOfferOrderItems = new ArrayList<SolutionOfferOrderItem>();
        this.price = price; // total price of the solution offer
    }

    public void addProduct(Product p) {
        products.add(p);
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

    public SolutionOfferCatalog getSolutionOfferCatalog() {
        return solutionOfferCatalog;
    }

    public void setSolutionOfferCatalog(SolutionOfferCatalog solutionOfferCatalog) {
        this.solutionOfferCatalog = solutionOfferCatalog;
    }

}
