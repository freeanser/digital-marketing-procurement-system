package model.OrderManagement;

import java.util.ArrayList;

public class SolutionReport {

  ArrayList<SolutionSummary> solutionSummaryList;
  String sortingRule;

  public SolutionReport(String sortingRule) {
    solutionSummaryList = new ArrayList<SolutionSummary>();
    this.sortingRule = sortingRule;
    /// We could make it "pre-populate" with the existing supplier data
  }

}
