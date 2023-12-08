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

  public static Business business;
  public static SupplierDirectory sd;
  public static MasterOrderList mol;
  public static MasterOrderReport orderReport;
  public static MarketCatalog marketCatalog;
  public static ChannelCatalog channelCatalog;
  public static SolutionOfferCatalog solutionoffercatalog;
  public static Market marketTeachers;
  public static Market marketStudents;
  public static Channel channelInstagram;
  public static Channel channelFacebook;
  public static MarketChannelAssignment ti;
  public static MarketChannelAssignment tf;
  public static MarketChannelAssignment si;
  public static MarketChannelAssignment sf;
  public static ArrayList<Product> allProducts;
  public static ArrayList<Product> laptopperipherals;
  public static ArrayList<Product> grocery;

  public static void main(String[] args) {
    // TODO code application logic here

    // 1. Populate the model
    populateModel();

    // 2. Maybe some interaction with the user (optional)

    Scanner sc = new Scanner(System.in);

    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("Welcome to join Education Sale! Please pick an option:");
      System.out.println("1. I am a teacher");
      System.out.println("2. I am an student");
      System.out.println("3. I want to see the reports");
      System.out.println("4. Exit");

      String input = sc.next();

      // System.out.println(input);

      // 1. I am a teacher
      if (input.equals("1")) {
        handleTeacherOption(sc, marketTeachers);
      }

      // 2. I am an student
      if (input.equals("2")) {
        handleStudentOption(sc, marketStudents);
      }

      // 3. I want to see the reports
      if (input.equals("3")) {
        System.out.println("Please pick an option:");
      }

      // 4. Exit
      if (input.equals("4")) {
        exitCode = true;
      }

    }

    System.out.println("Thank you, have a nice day.");

    sc.close();

  }

  public static void populateModel() {
    business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100, 10);
    sd = business.getSupplierDirectory();
    mol = business.getMasterOrderList();
    orderReport = mol.generateMasterOrderReport();
    marketCatalog = business.getMarketcatalog();
    channelCatalog = business.getChannelcatalog();
    solutionoffercatalog = business.getSolutionoffercatalog();

    // market
    marketTeachers = marketCatalog.newMarket("teacher");
    marketStudents = marketCatalog.newMarket("student");
    channelInstagram = channelCatalog.newChannel("Instagram");
    channelFacebook = channelCatalog.newChannel("Facebook");
    ti = new MarketChannelAssignment(marketTeachers, channelInstagram,
        "Hi! Are you a teacher? For a limited time on Instagram, teachers can now purchase all the following items at a discounted price!",
        10000.0);
    tf = new MarketChannelAssignment(marketTeachers, channelFacebook,
        "Hi! Are you a teacher? For a limited time on Facebook, teachers can now purchase all the following items at a discounted price!",
        13700.0);
    si = new MarketChannelAssignment(marketStudents, channelInstagram,
        "Hi! Are you a student? For a limited time on Instagram, students can now purchase all the following items at a discounted price!",
        12000.0);
    sf = new MarketChannelAssignment(marketStudents, channelFacebook,
        "Hi! Are you a student? For a limited time on Facebook, students can now purchase all the following items at a discounted price!",
        15200.0);

    // Soulution Offer (Bundle of products)
    allProducts = sd.findAllProducts();
    laptopperipherals = solutionoffercatalog.setRandomProducts(allProducts, 5);
    grocery = solutionoffercatalog.setRandomProducts(allProducts, 5);

    // solution offer
    // // TI
    // SolutionOffer laptopperipheralsTI = solutionoffercatalog.newSolutionOffer(ti,
    // laptopperipherals, 1000);
    // SolutionOffer groceryTI = solutionoffercatalog.newSolutionOffer(ti, grocery,
    // 1370);

    // TF
    SolutionOffer laptopperipheralsTF = solutionoffercatalog.newSolutionOffer(tf, laptopperipherals, 1370);
    SolutionOffer groceryTF = solutionoffercatalog.newSolutionOffer(tf, grocery, 1000);

    // SI
    SolutionOffer laptopperipheralsSI = solutionoffercatalog.newSolutionOffer(si, laptopperipherals, 1200);
    SolutionOffer grocerySI = solutionoffercatalog.newSolutionOffer(si, grocery, 1520);

    // SF
    SolutionOffer laptopperipheralsSF = solutionoffercatalog.newSolutionOffer(sf, laptopperipherals, 1520);
    SolutionOffer grocerySF = solutionoffercatalog.newSolutionOffer(sf, grocery, 1200);

  }

  // Handle Customers Option
  // public static void handleCustomersOption(Scanner sc) {
  // }

  // Handle Teacher Option
  public static void handleTeacherOption(Scanner sc, Market marketTeachers) {
    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("This is the list of the " + marketTeachers.getCustomersID());
      System.out.println("What's the channel you use? Please pick an option");
      System.out.println("1. Instagram");
      System.out.println("2. Facebook");
      System.out.println("3. Exit");

      String input = sc.next();

      // 1. I am a teacher and choose 1. Instagram
      if (input.equals("1")) {
        ti.printInfo();
        handleTeacherInstagram(sc);

      }

      // 1. I am a teacher and choose 2. Facebook
      if (input.equals("2")) {
        tf.printInfo();
      }

      if (input.equals("3"))
        exitCode = true;

    }
  }

  // Handle Student Option
  public static void handleStudentOption(Scanner sc, Market marketStudents) {
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
        si.printInfo();
      }

      // 1. I am a student and choose 2. Facebook
      if (input.equals("2")) {
        sf.printInfo();
      }

      if (input.equals("3"))
        exitCode = true;
    }
  }

  // Handle teacher & instagram
  public static void handleTeacherInstagram(Scanner sc) {
    // TI
    SolutionOffer laptopperipheralsTI = solutionoffercatalog.newSolutionOffer(ti, laptopperipherals, 1000);
    SolutionOffer groceryTI = solutionoffercatalog.newSolutionOffer(ti, grocery, 1370);
    System.out.println("1. Laptop Peripherals");
    System.out.println("2. Grocery");
    System.out.println("3. Exit");

    String input = sc.next();

    // 1. Laptop Peripherals
    if (input.equals("1")) {
      System.out.println("Including all these items, the total cost is only $" + laptopperipheralsTI.getPrice()
          + "! Act fast before it's gone! ");
      laptopperipheralsTI.finProductsProfessionName();
    }

    // 2. Grocery
    if (input.equals("2")) {
      // groceryTI.printInfo();
    }

    // if (input.equals("3"))
    // exitCode = true;
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
}
