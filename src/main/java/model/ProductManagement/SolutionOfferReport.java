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
    System.out.println("Solution Report");
    System.out.println("Sorting Rule: " + sortingRule);
    System.out.println("Solution Summary List: ");
    for (SolutionOfferSummary sos : solutionOfferSummaryList) {

      StringBuilder sb = new StringBuilder();
      sb.append("Market: " + sos.getMarket().getName() + "\n");
      sb.append("Channel: " + sos.getChannel().getName() + "\n");
      sb.append("Advertisement: " + sos.getAdvertisement() + "\n");
      sb.append("Solution Bundles Name: " + sos.getName() + "\n");
      sb.append("Total Revenue (Actual Sales): " + sos.getTotalRevenue() + "\n");
      // sb.append("get AllSolutionOfferPrice: " + sos.getAllSolutionOfferPrice() +
      // "\n");

      sb.append("\n");

      System.out.println(sb.toString());
    }
  }

}
