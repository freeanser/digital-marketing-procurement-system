/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {
    String name;
    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> marketChannelAssignments;
    MarketCatalog marketCatalog;
    ArrayList<String> characteristics;
    // ArrayList<Market> submarkets;
    Channel channel;
    ArrayList<CustomerProfile> customerProfiles;
    int size;

    public Market(String s, MarketCatalog marketCatalog) {
        name = s;
        // characteristics = new ArrayList<String>();
        // characteristics.add(s);
        marketChannelAssignments = new ArrayList<MarketChannelAssignment>();
        this.marketCatalog = marketCatalog;
        customerProfiles = new ArrayList<CustomerProfile>();
        // so = new ArrayList<SolutionOffer>();
        // submarkets = new ArrayList<Market>();
    }

    public String getName() {
        return name;
    }

    // public void setName(String name) {
    // this.name = name;
    // }

    public ArrayList<SolutionOffer> getSo() {
        return so;
    }

    public void setSo(ArrayList<SolutionOffer> so) {
        this.so = so;
    }

    public ArrayList<MarketChannelAssignment> getmarketChannelAssignments() {
        return marketChannelAssignments;
    }

    public void setmarketChannelAssignments(ArrayList<MarketChannelAssignment> marketChannelAssignments) {
        this.marketChannelAssignments = marketChannelAssignments;
    }

    public MarketCatalog getMarketCatalog() {
        return marketCatalog;
    }

    public String addCharacteristics(String s) {
        characteristics.add(s);
        return s;
    }

    public void setMarketCatalog(MarketCatalog marketCatalog) {
        this.marketCatalog = marketCatalog;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCustomersID() {
        // get customers' ID
        StringBuilder customersID = new StringBuilder();
        customersID.append(name).append(": \n");
        for (CustomerProfile cp : customerProfiles) {
            size = customerProfiles.size();
            if (customerProfiles.indexOf(cp) == size - 1) {
                customersID.append(cp.getCustomerId());
            } else {
                customersID.append(cp.getCustomerId()).append(", \n");
            }
        }
        return customersID.toString();
    }

    public ArrayList<CustomerProfile> getCustomerProfiles() {
        return customerProfiles;
    }

    public void addCustomerProfile(CustomerProfile cp) {
        customerProfiles.add(cp);
    }

    public void addCustomerProfiles(ArrayList<CustomerProfile> profiles) {
        customerProfiles.addAll(profiles);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isMatch(String name) {
        if (this.getName().equals(name)) {
            return true;
        }
        return false;
    }

    public MarketChannelAssignment newMarketChannelAssignment(Channel c) {
        MarketChannelAssignment mca = new MarketChannelAssignment(this, c);
        marketChannelAssignments.add(mca);
        return mca;
    }

    public MarketChannelAssignment findMarketChannelAssignment(Channel c) {
        for (MarketChannelAssignment mca : marketChannelAssignments) {
            if (mca.isMatch(c)) {
                return mca;
            }
        }
        return null; // not found after going through the whole list
    }

    public void printShortInfo() {
        System.out.println("Market: " + name);
        System.out.println("Channel: " + channel.getName());
        System.out.println("Characteristics: " + characteristics);
        System.out.println("Customer Profiles: " + customerProfiles);
        System.out.println("Size: " + size);
    }

}
