/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;
    String AdvertisingMessage;
    Double AdvertisingBudget;
    List<String> allAdvertisingMessages = Arrays.asList(
            "Hi! Are you a teacher? For a limited time on Instagram, teachers can now purchase all the following items at a discounted price!",
            "Hi! Are you a teacher? For a limited time on Facebook, teachers can now purchase all the following items at a discounted price!",
            "Hi! Are you a student? For a limited time on Instagram, students can now purchase all the following items at a discounted price!",
            "Hi! Are you a student? For a limited time on Facebook, students can now purchase all the following items at a discounted price!");

    public MarketChannelAssignment(Market m, Channel c, Double ab) {

        market = m;
        channel = c;
        // AdvertisingMessage = am;
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

    public List<String> getAllAdvertisingMessages() {
        return allAdvertisingMessages;
    }

    public String getAdvertisingMessage() {
        return AdvertisingMessage;
    }

    // public String getAdvertisingMessage() {
    // // Return the corresponding advertising message based on the values of market
    // // and channel
    // if (market != null && channel != null) {
    // if (market.getName().equals("teacher") &&
    // channel.getName().equals("Instagram")) {
    // // If it is a teacher on Instagram, return the first message from
    // // allAdvertisingMessages
    // return allAdvertisingMessages.get(0);
    // } else if (market.getName().equals("teacher") &&
    // channel.getName().equals("Facebook")) {
    // // If it is a teacher on Facebook, return the second message from
    // // allAdvertisingMessages
    // return allAdvertisingMessages.get(1);
    // } else if (market.getName().equals("student") &&
    // channel.getName().equals("Instagram")) {
    // // If it is a student on Instagram, return the third message from
    // // allAdvertisingMessages
    // return allAdvertisingMessages.get(2);
    // } else if (market.getName().equals("student") &&
    // channel.getName().equals("Facebook")) {
    // // If it is a student on Facebook, return the fourth message from
    // // allAdvertisingMessages
    // return allAdvertisingMessages.get(3);
    // }
    // }

    // // If unable to match specific market and channel, you can return a default
    // // message or an empty string, depending on the situation
    // return "Default Advertising Message";
    // }

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
