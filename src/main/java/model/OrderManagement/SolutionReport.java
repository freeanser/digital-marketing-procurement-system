package model.OrderManagement;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionReport {

  ArrayList<SolutionSummary> solutionSummaryList;
  String sortingRule;

  public SolutionReport(String sortingRule) {
    solutionSummaryList = new ArrayList<SolutionSummary>();
    this.sortingRule = sortingRule;
    /// We could make it "pre-populate" with the existing supplier data
  }

  public void addSolutionSummary(SolutionSummary ss) {
    solutionSummaryList.add(ss);

    SolutionSummaryComparator comparator = new SolutionSummaryComparator(sortingRule);
    Collections.sort(solutionSummaryList, comparator);
  }

}
