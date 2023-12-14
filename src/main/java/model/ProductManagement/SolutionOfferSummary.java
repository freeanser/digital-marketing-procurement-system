package model.ProductManagement;

import java.util.ArrayList;
import java.util.List;

import model.Business.Business;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.SolutionOfferOrderItem;
import model.OrderManagement.SolutionOrder;
import model.MarketModel.Advertisement;
import model.MarketModel.Channel;

public class SolutionOfferSummary {
  Business business;
  SolutionOffer solutionOffer;
  MarketChannelAssignment marketChannel;
  Market market;
  Channel channel;
  String advertisement;
  String name;

  int totalRevenue;

  public SolutionOfferSummary(SolutionOffer so, Business business) {
    solutionOffer = so;
    this.business = business;
    marketChannel = so.getMarketChannelComb();
    market = marketChannel.getMarket();
    channel = marketChannel.getChannel();
    advertisement = marketChannel.getAdvertisingMessage();
    name = so.getName();

    // totalRevenue = so.getSalesVolume(so.getPrice(), so.getProducts().size());

    totalRevenue = this.getAllSolutionOfferPrice();

  }

  public int getAllSolutionOfferPrice() {
    int totalRevenue = 0;
    ArrayList<SolutionOfferOrderItem> solutionOrderItems = solutionOffer.getSolutionOfferOrderItems();
    for (SolutionOfferOrderItem solutionOfferOrderItem : solutionOrderItems) {
      int price = solutionOfferOrderItem.getActualPrice();
      int quantity = solutionOfferOrderItem.getQuantity();
      int total = price * quantity;
      totalRevenue += total;
    }
    return totalRevenue;

    // return solutionOffer.getPrice();
  }

  public int getOrderItemSize() {
    return solutionOffer.getSolutionOfferOrderItems().size();
  }

  public Business getBusiness() {
    return business;
  }

  public SolutionOffer getSolutionOffer() {
    return solutionOffer;
  }

  public MarketChannelAssignment getMarketChannel() {
    return marketChannel;
  }

  public Market getMarket() {
    return market;
  }

  public Channel getChannel() {
    return channel;
  }

  public String getAdvertisement() {
    return advertisement;
  }

  public String getName() {
    return name;
  }

  public int getTotalRevenue() {
    return totalRevenue;
  }
}