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

    public SolutionOffer newSolutionOffer(MarketChannelAssignment m, ArrayList<Product> ps, int price) {
        SolutionOffer so = new SolutionOffer(m, ps, price);
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

}
