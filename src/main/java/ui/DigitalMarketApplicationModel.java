package ui;

import java.util.ArrayList;

import model.Business.Business;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.OrderManagement.MasterSolutionOrderList;
import model.OrderManagement.MasterSolutionOrderList;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.Supplier.SupplierDirectory;

public class DigitalMarketApplicationModel {
  private Business business;
  private SupplierDirectory sd;
  private MasterOrderList mol;
  private MasterOrderReport orderReport;
  private MarketCatalog marketCatalog;
  private ChannelCatalog channelCatalog;
  private SolutionOfferCatalog solutionoffercatalog;
  private MasterSolutionOrderList masterSolutionOrderList;
  private Market marketTeachers;
  private Market marketStudents;
  private Channel channelInstagram;
  private Channel channelFacebook;
  private MarketChannelAssignment ti;
  private MarketChannelAssignment tf;
  private MarketChannelAssignment si;
  private MarketChannelAssignment sf;
  private ArrayList<Product> allProducts;
  private ArrayList<Product> amazonBundlesProducts;
  private ArrayList<Product> groceryBundlesProducts;

  private SolutionOffer amazonBundlesProductsTI;
  private SolutionOffer groceryBundlesProductsTI;
  private SolutionOffer amazonBundlesProductsTF;
  private SolutionOffer groceryBundlesProductsTF;
  private SolutionOffer amazonBundlesProductsSI;
  private SolutionOffer groceryBundlesProductsSI;
  private SolutionOffer amazonBundlesProductsSF;
  private SolutionOffer groceryBundlesProductsSF;

  public DigitalMarketApplicationModel(
      Business b,
      SupplierDirectory sd,
      MasterOrderList mol,
      MasterOrderReport orderReport,
      MarketCatalog marketCatalog,
      ChannelCatalog channelCatalog, SolutionOfferCatalog solutionoffercatalog,
      MasterSolutionOrderList masterSolutionOrderList, Market marketTeachers,
      Market marketStudents, Channel channelInstagram, Channel channelFacebook, MarketChannelAssignment ti,
      MarketChannelAssignment tf, MarketChannelAssignment si, MarketChannelAssignment sf,
      ArrayList<Product> allProducts, ArrayList<Product> amazonBundlesProducts,
      ArrayList<Product> groceryBundlesProducts, SolutionOffer amazonBundlesProductsTI,
      SolutionOffer groceryBundlesProductsTI, SolutionOffer amazonBundlesProductsTF,
      SolutionOffer groceryBundlesProductsTF, SolutionOffer amazonBundlesProductsSI,
      SolutionOffer groceryBundlesProductsSI, SolutionOffer amazonBundlesProductsSF,
      SolutionOffer groceryBundlesProductsSF) {
    this.business = b;
    this.sd = sd;
    this.mol = mol;
    this.orderReport = orderReport;
    this.marketCatalog = marketCatalog;
    this.channelCatalog = channelCatalog;
    this.solutionoffercatalog = solutionoffercatalog;
    this.masterSolutionOrderList = masterSolutionOrderList;
    this.marketTeachers = marketTeachers;
    this.marketStudents = marketStudents;
    this.channelInstagram = channelInstagram;
    this.channelFacebook = channelFacebook;
    this.ti = ti;
    this.tf = tf;
    this.si = si;
    this.sf = sf;
    this.allProducts = allProducts;
    this.amazonBundlesProducts = amazonBundlesProducts;
    this.groceryBundlesProducts = groceryBundlesProducts;

    this.amazonBundlesProductsTI = amazonBundlesProductsTI;
    this.groceryBundlesProductsTI = groceryBundlesProductsTI;
    this.amazonBundlesProductsTF = amazonBundlesProductsTF;
    this.groceryBundlesProductsTF = groceryBundlesProductsTF;
    this.amazonBundlesProductsSI = amazonBundlesProductsSI;
    this.groceryBundlesProductsSI = groceryBundlesProductsSI;
    this.amazonBundlesProductsSF = amazonBundlesProductsSF;
    this.groceryBundlesProductsSF = groceryBundlesProductsSF;

  }

  public Business getBusiness() {
    return business;
  }

  public SolutionOffer getAmazonBundlesProductsTI() {
    return amazonBundlesProductsTI;
  }

  public SolutionOffer getGroceryBundlesProductsTI() {
    return groceryBundlesProductsTI;
  }

  public SolutionOffer getAmazonBundlesProductsTF() {
    return amazonBundlesProductsTF;
  }

  public SolutionOffer getGroceryBundlesProductsTF() {
    return groceryBundlesProductsTF;
  }

  public SolutionOffer getAmazonBundlesProductsSI() {
    return amazonBundlesProductsSI;
  }

  public SolutionOffer getGroceryBundlesProductsSI() {
    return groceryBundlesProductsSI;
  }

  public SolutionOffer getAmazonBundlesProductsSF() {
    return amazonBundlesProductsSF;
  }

  public SolutionOffer getGroceryBundlesProductsSF() {
    return groceryBundlesProductsSF;
  }

  public MasterSolutionOrderList getMasterSolutionOrderList() {
    return masterSolutionOrderList;
  }

  public SolutionOfferCatalog getSolutionoffercatalog() {
    return solutionoffercatalog;
  }

  public Market getMarketTeachers() {
    return marketTeachers;
  }

  public Market getMarketStudents() {
    return marketStudents;
  }

  public MarketChannelAssignment getTi() {
    return ti;
  }

  public MarketChannelAssignment getTf() {
    return tf;
  }

  public MarketChannelAssignment getSi() {
    return si;
  }

  public MarketChannelAssignment getSf() {
    return sf;
  }

  public ArrayList<Product> getAmazonBundlesProducts() {
    return amazonBundlesProducts;
  }

  public ArrayList<Product> getGroceryBundlesProducts() {
    return groceryBundlesProducts;
  }

  public void generateOrderReport() {
    orderReport.printOrderReport();
  }

}
