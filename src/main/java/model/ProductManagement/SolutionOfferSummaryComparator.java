package model.ProductManagement;

import java.util.ArrayList;
import java.util.Comparator;

public class SolutionOfferSummaryComparator implements Comparator<SolutionOfferSummary> {

  String sortingRule;

  public SolutionOfferSummaryComparator(String sortingRule) {
    this.sortingRule = sortingRule;
  }

  @Override
  public int compare(SolutionOfferSummary o1, SolutionOfferSummary o2) {
    if (sortingRule.equals("Total Sales")) {
      return o1.getTotalRevenue().compareTo(o2.getTotalRevenue());
    }

    return (-1) * Double.compare(o1.getTotalRevenue(), o2.getTotalRevenue());
  }
}