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

import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.SolutionOfferOrderItem;
import model.Business.*;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {

    String type;
    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog(String n) {
        type = n;
        solutionoffers = new ArrayList<SolutionOffer>(); /// create the list of elements otherwise it is null
    }

    public SolutionOfferCatalog() {
        type = "unknown";
        solutionoffers = new ArrayList<SolutionOffer>();
    }

    public String getType() {
        return type;
    }

    public SolutionOffer newSolutionOffer(String name, MarketChannelAssignment m, ArrayList<Product> ps, int price) {

        SolutionOffer so = new SolutionOffer(name, m, ps, price);
        solutionoffers.add(so);
        return so;
    }

    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }

    public void setSolutionoffers(ArrayList<SolutionOffer> solutionoffers) {
        this.solutionoffers = solutionoffers;
    }

    public ArrayList<Product> setRandomProducts(ArrayList<Product> productsList, int count) {
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

    public int totalSalesRevenues() {
        int totalSales = 0;
        for (SolutionOffer so : solutionoffers) {

            int salesVolume = so.getSalesVolume();

            totalSales += salesVolume;
        }
        return totalSales;
    }

    // Generate SolutionOffer formance Report
    public SolutionOfferReport generateSolutionOfferReport(String sortingRule, Business business) {
        SolutionOfferReport solutionOfferReport = new SolutionOfferReport(sortingRule);

        for (SolutionOffer so : solutionoffers) {

            SolutionOfferSummary sos = new SolutionOfferSummary(so, business);
            solutionOfferReport.addSolutionOfferSummary(sos);
        }
        return solutionOfferReport;
    }

}
