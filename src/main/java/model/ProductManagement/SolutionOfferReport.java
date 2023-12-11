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

  public void printSolutionOfferReport() {
    System.out.println("Solution Offer Report");
    System.out.println("Sorting Rule: " + sortingRule);
    System.out.println("Solution Offer Summary List: ");
    for (SolutionOfferSummary sos : solutionOfferSummaryList) {
      // print market
      System.out.println("Market: " + sos.getMarket().getName());

      // print channel
      System.out.println("Channel: " + sos.getChannel().getName());

      // print advertisement
      System.out.println("Advertisement: " + sos.getAdvertisement());

      System.out.println("Total Revenue: " + sos.getTotalRevenue());
    }
  }

}
