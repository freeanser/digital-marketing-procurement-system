package model.OrderManagement;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.CustomerManagement.CustomerProfile;
import model.ProductManagement.SolutionOffer;

public class MasterSolutionOrderList {

  Business business;
  ArrayList<SolutionOrder> solutionOrders;
  SolutionOffer solutionOffer;

  public MasterSolutionOrderList(Business b, SolutionOffer so) {

    business = b;
    solutionOrders = new ArrayList<SolutionOrder>();
    solutionOffer = so;

  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public SolutionOffer getSolutionOffer() {
    return solutionOffer;
  }

  public ArrayList<SolutionOrder> getSolutionOrders() {
    return solutionOrders;
  }

  public void setSolutionOrders(ArrayList<SolutionOrder> solutionOrders) {
    this.solutionOrders = solutionOrders;
  }

  public SolutionOrder newSOOrder(CustomerProfile cp) {
    SolutionOrder o = new SolutionOrder(cp, this);
    solutionOrders.add(o);
    return o;

  }

  public SolutionReport generateSuppliererformanceReport(String sortingRule, Business business) {
    SolutionReport SupplierReport = new SolutionReport(sortingRule);

    for (SolutionOrder s : solutionOrders) {
      SolutionSummary ss = new SolutionSummary(business, s, solutionOffer);

      SupplierReport.addSupplierSummary(ss);
    }
    return SupplierReport;
  }

}
