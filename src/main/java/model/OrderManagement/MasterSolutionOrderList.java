package model.OrderManagement;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;

public class MasterSolutionOrderList {

  Business business;
  ArrayList<SolutionOrder> solutionOrders;

  public MasterSolutionOrderList(Business b) {

    business = b;
    solutionOrders = new ArrayList<SolutionOrder>();

  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public ArrayList<SolutionOrder> getSolutionOrders() {
    return solutionOrders;
  }

  public void setSolutionOrders(ArrayList<SolutionOrder> solutionOrders) {
    this.solutionOrders = solutionOrders;
  }

}
