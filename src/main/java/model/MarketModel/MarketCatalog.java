/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {

  Business business;
  ArrayList<Market> markets;

  public MarketCatalog(Business d) {

    business = d;
    markets = new ArrayList<Market>();

  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public ArrayList<Market> getMarkets() {
    return markets;
  }

  public void setMarkets(ArrayList<Market> markets) {
    this.markets = markets;
  }

  public Market newMarket(String s) {
    Market m = new Market(s, this);
    CustomerDirectory cd = business.getCustomerDirectory();
    ArrayList<CustomerProfile> profiles = cd.newRandomCustomerlist(15);
    m.addCustomerProfiles(profiles);
    markets.add(m);
    m.setMarketCatalog(this);
    return m;
  }

  public Market findMarket(String s) {

    for (Market m : markets) {

      if (m.isMatch(s)) {
        return m;
      }
    }
    return null; // not found after going through the whole list
  }

}
