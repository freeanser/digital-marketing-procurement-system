/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.lang.reflect.Array;
import java.util.ArrayList;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.OrderManagement.Order;
import model.OrderManagement.SolutionOrder;
import model.Personnel.Person;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    ArrayList<Order> orders;
    ArrayList<SolutionOrder> solutionOrders;
    ArrayList<Market> markets;

    // Channel channel;
    // // at specific customers through a specific market and channel
    Person person;

    public CustomerProfile(Person person) {
        // person = p;
        // orders = new ArrayList<Order>();
        this.person = person;
        this.orders = new ArrayList<>();
        this.solutionOrders = new ArrayList<>();
        this.markets = new ArrayList<>();
    }

    public ArrayList<SolutionOrder> getSolutionOrders() {
        return solutionOrders;
    }

    public void setSolutionOrders(ArrayList<SolutionOrder> solutionOrders) {
        this.solutionOrders = solutionOrders;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }

    public int getTotalPricePerformance() {
        // for each order in the customer orderlist
        // calculate order price performance and add it to the sum

        return 0;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        // for each order in the customer order list
        // calculate if order is positive (actual order total is greater than sum of
        // item targets
        // if yes then add 1 to total
        int sum = 0;
        for (Order o : orders) {
            if (o.isOrderAboveTotalTarget() == true)
                sum = sum + 1;
        }

        return sum;
    }

    public int getNumberOfOrdersBelowTotalTarget() {
        return 0;
    }
    // for each order in the customer order list
    // calculate if order is negative
    // if yes then add 1 to total

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void addCustomerOrder(Order o) {
        orders.add(o);
    }

    public void addSolutionOrder(SolutionOrder o) {
        solutionOrders.add(o);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

    public String getCustomerId() {
        return person.getPersonId();
    }

    public Person getPerson() {
        return person;
    }

}
