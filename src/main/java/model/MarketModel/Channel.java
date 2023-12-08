/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Channel {

  String name;
  ChannelCatalog channelCatalog;
  ArrayList<Market> markets;
  ArrayList<MarketChannelAssignment> marketChannelAssignments;

  public Channel(String s, ChannelCatalog channelCatalog) {

    name = s;
    marketChannelAssignments = new ArrayList<MarketChannelAssignment>();
    this.channelCatalog = channelCatalog;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ChannelCatalog getChannelCatalog() {
    return channelCatalog;
  }

  public void setChannelCatalog(ChannelCatalog channelCatalog) {
    this.channelCatalog = channelCatalog;
  }

  public ArrayList<Market> getMarkets() {
    return markets;
  }

  public void setMarkets(ArrayList<Market> markets) {
    this.markets = markets;
  }

  public ArrayList<MarketChannelAssignment> getMarketChannelAssignments() {
    return marketChannelAssignments;
  }

  public void setMarketChannelAssignments(ArrayList<MarketChannelAssignment> marketChannelAssignments) {
    this.marketChannelAssignments = marketChannelAssignments;
  }
}
