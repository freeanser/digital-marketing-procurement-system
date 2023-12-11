package model.OrderManagement;

import java.util.ArrayList;
import model.OrderManagement.MasterSolutionOrderList;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.SolutionOfferOrderItem;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;

public class SolutionOrder {

  CustomerProfile customerProfiles;
  ArrayList<SolutionOfferOrderItem> solutionOfferOrderItems;
  MasterSolutionOrderList masterSolutionOrderList;

  public SolutionOrder(CustomerProfile cp, MasterSolutionOrderList msol) {
    solutionOfferOrderItems = new ArrayList<SolutionOfferOrderItem>();
    masterSolutionOrderList = msol;
    customerProfiles = cp;
    cp.addSolutionOrder(this);

  }

  public CustomerProfile getCustomerProfiles() {
    return customerProfiles;
  }

  public void setCustomerProfiles(CustomerProfile customerProfiles) {
    this.customerProfiles = customerProfiles;
  }

  public ArrayList<SolutionOfferOrderItem> getSolutionOfferOrderItems() {
    return solutionOfferOrderItems;
  }

  public void setSolutionOfferOrderItems(ArrayList<SolutionOfferOrderItem> solutionOfferOrderItems) {
    this.solutionOfferOrderItems = solutionOfferOrderItems;
  }

  public SolutionOfferOrderItem newOrderItem(SolutionOffer so, int paidprice, int q, SolutionOrder o) {
    SolutionOfferOrderItem oi = new SolutionOfferOrderItem(so, paidprice, q, o);
    solutionOfferOrderItems.add(oi);

    // 2-3: Link the orderItem to the order
    oi.setSolutionOrder(this);
    return oi;
  }

  public MasterSolutionOrderList getMasterSolutionOrderList() {
    return masterSolutionOrderList;
  }

  public void setMasterSolutionOrderList(MasterSolutionOrderList masterSolutionOrderList) {
    this.masterSolutionOrderList = masterSolutionOrderList;
  }

}
