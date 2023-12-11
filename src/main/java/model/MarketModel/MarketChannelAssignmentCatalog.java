package model.MarketModel;

import java.util.ArrayList;
import model.Business.Business;
import model.MarketModel.Channel;
import model.MarketModel.Market;

public class MarketChannelAssignmentCatalog {

  ArrayList<MarketChannelAssignment> marketChannelAssignments;

  Business business;

  public MarketChannelAssignmentCatalog() {
    marketChannelAssignments = new ArrayList<MarketChannelAssignment>();
  }

  public ArrayList<MarketChannelAssignment> getMarketChannelAssignment() {
    return marketChannelAssignments;
  }

  public MarketChannelAssignment newmarketChannelAssignment(Market m, Channel c, Double ab) {
    MarketChannelAssignment mca = new MarketChannelAssignment(m, c, ab);
    marketChannelAssignments.add(mca);
    return mca;
  }

  // Generate formance Report
  public MarketChannelAssignmentReport generateMarketChannelAssignmentReport(String sortingRule, Business business) {
    MarketChannelAssignmentReport marketChannelAssignmentReport = new MarketChannelAssignmentReport(sortingRule);

    for (MarketChannelAssignment mca : marketChannelAssignments) {

      MarketChannelAssignmentSummary mcas = new MarketChannelAssignmentSummary(mca, business);
      marketChannelAssignmentReport.addMarketChannelAssignmentSummary(mcas);
    }
    return marketChannelAssignmentReport;
  }

}
