/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import java.util.ArrayList;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOfferCatalog;
import model.ProductManagement.SolutionOffer;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.Product;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  private DigitalMarketApplicationModel model;

  public DigitalMarketingApplication(DigitalMarketApplicationModel model) {
    this.model = model;
  }

  public static void main(String[] args) {
    // TODO code application logic here
    DigitalMarketApplicationModel model = populateModel();

    // 1. Populate the model
    DigitalMarketingApplication application = new DigitalMarketingApplication(model);

    // 2. Maybe some interaction with the user (optional)

    Scanner sc = new Scanner(System.in);
    application.renderMainMenuOptions(sc);
  }

  public void renderMainMenuOptions(Scanner sc) {

    // boolean exitCode = false;

    // while (!exitCode) {
    System.out.println("Welcome to join Education Sale! Please pick an option:");
    System.out.println("1. I am a teacher");
    System.out.println("2. I am an student");
    System.out.println("3. I want to see the reports");
    System.out.println("4. Exit");

    String input = sc.next();

    // System.out.println(input);

    // 1. I am a teacher
    if (input.equals("1")) {
      handleTeacherOption(sc, model.getMarketTeachers());
    }

    // 2. I am an student
    if (input.equals("2")) {
      handleStudentOption(sc, model.getMarketStudents());
    }

    // 3. I want to see the reports
    if (input.equals("3")) {
      System.out.println("Please pick an option:");
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");

      sc.close();
      // exitCode = true;
    }

    // }

  }

  // Handle Teacher Option
  public void handleTeacherOption(Scanner sc, Market marketTeachers) {
    // boolean exitCode = false;

    // while (!exitCode) {
    System.out.println("This is the list of the " + marketTeachers.getCustomersID());
    System.out.println("What's the channel you use? Please pick an option");
    System.out.println("1. Instagram");
    System.out.println("2. Facebook");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. I am a teacher and choose 1. Instagram
    if (input.equals("1")) {
      model.getTi().printInfo();
      handleTeacherInstagram(sc);

    }

    // 1. I am a teacher and choose 2. Facebook
    if (input.equals("2")) {
      model.getTf().printInfo();
    }

    if (input.equals("3"))
      renderMainMenuOptions(sc);

    if (input.equals("4"))
      System.out.println("Thank you, have a nice day.");
    sc.close();
    // exitCode = true;

    // }
  }

  // Handle teacher & instagram
  public void handleTeacherInstagram(Scanner sc) {
    // TI
    SolutionOffer amazonBundlesProductsTI = model.getSolutionoffercatalog().newSolutionOffer(model.getTi(),
        model.getAmazonBundlesProducts(), 1600);
    SolutionOffer groceryTI = model.getSolutionoffercatalog().newSolutionOffer(model.getTi(), model.getGrocery(), 1970);
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      model.getTi().printInfo();
      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsTI.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsTI.finProductsProfessionName();
      handleBuyOrNot(sc, amazonBundlesProductsTI);
    }

    // 2. Grocery
    if (input.equals("2")) {
      // groceryTI.printInfo();
    }

    if (input.equals("3"))
      handleTeacherOption(sc, model.getMarketTeachers());

    if (input.equals("4"))
      System.out.println("Thank you, have a nice day.");
    sc.close();

  }

  // Handle Student Option
  public void handleStudentOption(Scanner sc, Market marketStudents) {
    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("This is the list of the " + marketStudents.getCustomersID());
      System.out.println("What's the channel you use? Please pick an option");
      System.out.println("1. Instagram");
      System.out.println("2. Facebook");
      System.out.println("3. Exit");

      String input = sc.next();

      // System.out.println(input);

      // 1. I am a student and choose 1. Instagram
      if (input.equals("1")) {
        model.getSi().printInfo();
      }

      // 1. I am a student and choose 2. Facebook
      if (input.equals("2")) {
        model.getSf().printInfo();
      }

      if (input.equals("3"))
        exitCode = true;
    }
  }

  private void confirmOrder(SolutionOffer so) {
     model.addOrder
  }

  // Handle buy it or not
  public void handleBuyOrNot(Scanner sc, SolutionOffer so) {
    System.out.println("Do you want to buy it? Please pick an option");
    System.out.println("1. Yes");
    System.out.println("2. No");
    System.out.println("3. Exit");

    String input = sc.next();

    // 1. Yes
    if (input.equals("1")) {
      System.out.println("Thank you for your purchase! Have a nice day!");
      confirmOrder(so);
    }

    // 2. No
    if (input.equals("2")) {
      System.out.println("Thank you for your time! Have a nice day!");
    }

    if (input.equals("3"))
      System.out.println("Thank you, have a nice day.");
    sc.close();
  }

  // Handle Reports Option
  public static void handleReportsOption(Scanner sc, Market marketStudents) {
    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("This is the list of the ");
      System.out.println("What's the report you would like to check? Please pick an option");
      System.out.println("1. ");
      System.out.println("2. ");
      System.out.println("3. Exit");

      String input = sc.next();

      // 1.
      if (input.equals("1")) {

      }

      // 2.
      if (input.equals("2")) {

      }

      if (input.equals("3"))
        exitCode = true;

    }
  }

  public static DigitalMarketApplicationModel populateModel() {
    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100, 10);
    SupplierDirectory sd = business.getSupplierDirectory();
    MasterOrderList mol = business.getMasterOrderList();
    MasterOrderReport orderReport = mol.generateMasterOrderReport();
    MarketCatalog marketCatalog = business.getMarketcatalog();
    ChannelCatalog channelCatalog = business.getChannelcatalog();
    SolutionOfferCatalog solutionoffercatalog = business.getSolutionoffercatalog();

    // market
    Market marketTeachers = marketCatalog.newMarket("teacher");
    Market marketStudents = marketCatalog.newMarket("student");
    Channel channelInstagram = channelCatalog.newChannel("Instagram");
    Channel channelFacebook = channelCatalog.newChannel("Facebook");
    MarketChannelAssignment ti = new MarketChannelAssignment(marketTeachers, channelInstagram,
        "Hi! Are you a teacher? For a limited time on Instagram, teachers can now purchase all the following items at a discounted price!",
        18000.0);
    MarketChannelAssignment tf = new MarketChannelAssignment(marketTeachers, channelFacebook,
        "Hi! Are you a teacher? For a limited time on Facebook, teachers can now purchase all the following items at a discounted price!",
        17700.0);
    MarketChannelAssignment si = new MarketChannelAssignment(marketStudents, channelInstagram,
        "Hi! Are you a student? For a limited time on Instagram, students can now purchase all the following items at a discounted price!",
        10200.0);
    MarketChannelAssignment sf = new MarketChannelAssignment(marketStudents, channelFacebook,
        "Hi! Are you a student? For a limited time on Facebook, students can now purchase all the following items at a discounted price!",
        10000.0);

    // Soulution Offer (Bundle of products)
    ArrayList<Product> allProducts = sd.findAllProducts();
    ArrayList<Product> amazonBundlesProducts = solutionoffercatalog.setRandomProducts(allProducts, 5);
    ArrayList<Product> grocery = solutionoffercatalog.setRandomProducts(allProducts, 5);

    // solution offer
    // // TI
    // SolutionOffer amazonBundlesProductsTI =
    // solutionoffercatalog.newSolutionOffer(ti,
    // amazonBundlesProducts, 1000);
    // SolutionOffer groceryTI = solutionoffercatalog.newSolutionOffer(ti, grocery,
    // 1370);

    // TF
    SolutionOffer amazonBundlesProductsTF = solutionoffercatalog.newSolutionOffer(tf, amazonBundlesProducts, 1770);
    SolutionOffer groceryTF = solutionoffercatalog.newSolutionOffer(tf, grocery, 1880);

    // SI
    SolutionOffer amazonBundlesProductsSI = solutionoffercatalog.newSolutionOffer(si, amazonBundlesProducts, 1005);
    SolutionOffer grocerySI = solutionoffercatalog.newSolutionOffer(si, grocery, 999);

    // SF
    SolutionOffer amazonBundlesProductsSF = solutionoffercatalog.newSolutionOffer(sf, amazonBundlesProducts, 1050);
    SolutionOffer grocerySF = solutionoffercatalog.newSolutionOffer(sf, grocery, 1030);

    return new DigitalMarketApplicationModel(business, sd, mol, orderReport, marketCatalog, channelCatalog,
        solutionoffercatalog, marketTeachers, marketStudents, channelInstagram, channelFacebook, ti, tf, si, sf,
        allProducts, amazonBundlesProducts, grocery);

  }
}
