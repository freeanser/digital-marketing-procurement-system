package model.MarketModel;

import java.util.ArrayList;

public class MarketChannelAssignmentReport {
  ArrayList<MarketChannelAssignmentSummary> marketChannelAssignmentSummaryList;
  String sortingRule;

  public MarketChannelAssignmentReport(String sortingRule) {
    marketChannelAssignmentSummaryList = new ArrayList<MarketChannelAssignmentSummary>();
    this.sortingRule = sortingRule;
    /// We could make it "pre-populate" with the existing supplier data
  }

}
