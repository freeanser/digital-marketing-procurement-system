package model.OrderManagement;

import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.OrderManagement.SolutionOrder;

public class SolutionOfferOrderItem {

  SolutionOffer solutionOffer;
  int actualPrice;
  int quantity;
  SolutionOrder solutionOrder;

  public SolutionOfferOrderItem(SolutionOffer so, int paidprice, int q, SolutionOrder o) {
    solutionOffer = so;
    so.addSolutionOfferOrderItem(this); // make sure Solution Offer links back to the item
    quantity = q;
    this.actualPrice = paidprice;
    solutionOrder = o;
  }

  public SolutionOffer getSolutionOffer() {
    return solutionOffer;
  }

  public void setSolutionOffer(SolutionOffer solutionOffer) {
    this.solutionOffer = solutionOffer;
  }

  public int getActualPrice() {
    return actualPrice;
  }

  public void setActualPrice(int actualPrice) {
    this.actualPrice = actualPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public SolutionOrder getSolutionOrder() {
    return solutionOrder;
  }

  public void setSolutionOrder(SolutionOrder solutionOrder) {
    this.solutionOrder = solutionOrder;
  }

}
