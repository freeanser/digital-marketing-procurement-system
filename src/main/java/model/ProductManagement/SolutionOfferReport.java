package model.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionOfferReport {
  ArrayList<SolutionOfferSummary> solutionOfferSummaryList;
  String sortingRule;

  public SolutionOfferReport(String sortingRule) {
    solutionOfferSummaryList = new ArrayList<SolutionOfferSummary>();
    this.sortingRule = sortingRule;
    /// We could make it "pre-populate" with the existing supplier data
  }

  public void addSolutionOfferSummary(SolutionOfferSummary sos) {

    solutionOfferSummaryList.add(sos);

    SolutionOfferSummaryComparator comparator = new SolutionOfferSummaryComparator(sortingRule);
    Collections.sort(solutionOfferSummaryList, comparator);

  }

}
