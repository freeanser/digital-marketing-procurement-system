/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.Arrays;
import java.util.List;

import model.Advertisement.Advertisement;
import model.Advertisement.AdvertisementCatalog;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;
    Advertisement advertisement;
    Double AdvertisingBudget;
    private static AdvertisementCatalog advertisementCatalog = new AdvertisementCatalog();

    public MarketChannelAssignment(Market m, Channel c, Double ab) {

        market = m;
        channel = c;
        AdvertisingBudget = ab;

    }

    /**
     * Gets the advertising message based on the market and channel.
     * If the market and channel match specific conditions, returns the
     * corresponding
     * advertising message from the advertisement catalog.
     * Otherwise, returns a default advertising message.
     */

    public String getAdvertisingMessage() {

        // Retrieve the list of advertisements from the shared catalog
        List<Advertisement> advertisements = advertisementCatalog.getAdvertisements();

        if (market != null && channel != null) {
            // Check market and channel conditions to determine the appropriate message
            // Return the first message for teacher on Instagram
            if (market.getName().equals("teacher") && channel.getName().equals("Instagram")) {
                return advertisements.get(0).getMessage();
                // Return the second message for teacher on Facebook
            } else if (market.getName().equals("teacher") && channel.getName().equals("Facebook")) {
                return advertisements.get(1).getMessage();
                // Return the third message for student on Instagram
            } else if (market.getName().equals("student") && channel.getName().equals("Instagram")) {
                return advertisements.get(2).getMessage();
                // Return the fourth message for student on Facebook
            } else if (market.getName().equals("student") && channel.getName().equals("Facebook")) {
                return advertisements.get(3).getMessage();
            }
        }

        return "Default Advertising Message";
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
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

    public Double getAdvertisingBudget() {
        return AdvertisingBudget;
    }

    public void printInfo() {
        StringBuilder mcaInfo = new StringBuilder();
        mcaInfo.append("Market: " + market.getName()).append("\n");
        mcaInfo.append("Channel: " + channel.getName()).append("\n");
        mcaInfo.append("Advertising Message: ").append(getAdvertisingMessage()).append("\n");
        mcaInfo.append(" (Advertising Budget: " + AdvertisingBudget + ")").append("\n");

        System.out.println(mcaInfo.toString());
    }
}
