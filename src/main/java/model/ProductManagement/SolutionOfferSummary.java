package model.ProductManagement;

import java.util.ArrayList;
import model.Business.Business;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.MarketModel.Advertisement;
import model.MarketModel.Channel;

public class SolutionOfferSummary {
  Business business;
  SolutionOffer solutionOffer;
  MarketChannelAssignment marketChannel;
  Market market;
  Channel channel;
  String advertisement;

  Double totalRevenue;

  public SolutionOfferSummary(SolutionOffer so, Business business) {
    solutionOffer = so;
    this.business = business;
    marketChannel = so.getMarketChannelComb();
    market = marketChannel.getMarket();
    channel = marketChannel.getChannel();
    advertisement = marketChannel.getAdvertisingMessage();

    totalRevenue = 0.0;

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

  public Double getTotalRevenue() {
    return totalRevenue;
  }
}