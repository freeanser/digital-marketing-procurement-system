package model.OrderManagement;

import java.util.Random;

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

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // Make sure the random number is never 0
    while (true) {
      int randomInt = lower + r.nextInt(upper - lower);
      if (randomInt != 0) {
        return randomInt;
      }
    }
  }

  public int getTotal() {
    int Total = actualPrice * quantity;
    return Total;

  }

  public SolutionOrder getSolutionOrder() {
    return solutionOrder;
  }

  public void setSolutionOrder(SolutionOrder solutionOrder) {
    this.solutionOrder = solutionOrder;
  }

}
