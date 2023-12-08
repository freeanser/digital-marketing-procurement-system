/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.Business.Business;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {

  Business business;
  ArrayList<Channel> channels;

  public ChannelCatalog(Business d) {

    business = d;
    channels = new ArrayList<Channel>();

  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public ArrayList<Channel> getChannels() {
    return channels;
  }

  public void setChannels(ArrayList<Channel> channels) {
    this.channels = channels;
  }

  public Channel newChannel(String s) {
    Channel c = new Channel(s, this);
    channels.add(c);
    c.setChannelCatalog(this);
    return c;
  }

}
