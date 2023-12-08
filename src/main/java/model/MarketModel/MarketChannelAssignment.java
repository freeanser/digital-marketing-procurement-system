/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;
    String AdvertisingMessage;
    Double AdvertisingBudget;

    public MarketChannelAssignment(Market m, Channel c, String am, Double ab) {

        market = m;
        channel = c;
        AdvertisingMessage = am;
        AdvertisingBudget = ab;

    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getAdvertisingMessage() {
        return AdvertisingMessage;
    }

    public void setAdvertisingMessage(String advertisingMessage) {
        AdvertisingMessage = advertisingMessage;
    }

    public Double getAdvertisingBudget() {
        return AdvertisingBudget;
    }

    public void printInfo() {
        StringBuilder mcaInfo = new StringBuilder();
        mcaInfo.append("Market: " + market.getName()).append("\n");
        mcaInfo.append("Channel: " + channel.getName()).append("\n");
        mcaInfo.append("Advertising Message: " + AdvertisingMessage).append("\n");
        mcaInfo.append(" (Advertising Budget: " + AdvertisingBudget + ")").append("\n");

        System.out.println(mcaInfo.toString());
    }
}
