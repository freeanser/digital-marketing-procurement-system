/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import model.ProductManagement.SolutionOfferReport;
import model.ProductManagement.SolutionOffer;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.OrderManagement.MasterSolutionOrderList;
import model.OrderManagement.SolutionOfferOrderItem;
import model.OrderManagement.SolutionOrder;
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

  // 2-6: Generate creative ideas beyond the requirements.
  // I create a class to store all the data
  private DigitalMarketApplicationModel model;

  // 2-6: Generate creative ideas beyond the requirements.
  // I created a constructor. This is a constructor with a
  // DigitalMarketApplicationModel parameter, used to initialize objects of the
  // DigitalMarketingApplication class.
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

    System.out.println("Welcome to join Education Sale! Please pick an option:");
    System.out.println("1. I am a customer and want to buy products");
    System.out.println("2. I am a market manager and want to see the sales orders");
    System.out.println("3. I am a market manager and want to see the reports");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1-1: A customer decides to browse and search for products
    // 1. I am a customer and want to buy products
    if (input.equals("1")) {
      CustomerOption(sc);
    }

    // 2. I am a market manager and want to see the sales orders
    if (input.equals("2")) {
      SalesOrdersOption(sc);
    }

    // 3. I am a market manager and want to see the reports
    if (input.equals("3")) {
      SolutionOfferReport Report = model.getSolutionoffercatalog().generateSolutionOfferReport("Total Sales",
          model.getBusiness());
      Report.printSolutionOfferReport();
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      renderMainMenuOptions(sc);
    }

    // // Test : This can explain my thought of the application
    // solutionOfferOrderItem = bundles products
    // System.out.println("SolutionOrders().size: " +
    // model.getMasterSolutionOrderList().getSolutionOrders().size());

    // List<SolutionOrder> solutionOrders =
    // model.getMasterSolutionOrderList().getSolutionOrders();
    // for (SolutionOrder solutionOrder : solutionOrders) {

    // int solutionOfferOrderItemsCount =
    // solutionOrder.getSolutionOfferOrderItems().size();

    // // getSolutionOffer
    // System.out.println(" SolutionOfferOrderItems Count: "
    // + solutionOfferOrderItemsCount);

    // for (SolutionOfferOrderItem solutionOfferOrderItem :
    // solutionOrder.getSolutionOfferOrderItems()) {
    // int price = solutionOfferOrderItem.getActualPrice();
    // System.out.println(" solutionOfferOrderItem: "
    // + solutionOfferOrderItem.getSolutionOffer().getName() + " price: " + price);
    // }
    // }
  }

  // 1-1: A customer decides to browse and search for products
  // Handle Customer Option
  public void CustomerOption(Scanner sc) {

    System.out.println("Welcome to join Education Sale! Please pick an option:");
    System.out.println("1. I am a teacher");
    System.out.println("2. I am an student");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. I am a teacher
    if (input.equals("1")) {
      handleTeacherOption(sc, model.getMarketTeachers());
    }

    // 2. I am an student
    if (input.equals("2")) {
      handleStudentOption(sc, model.getMarketStudents());
    }

    // 3. Previous Page
    if (input.equals("3")) {
      renderMainMenuOptions(sc);
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      renderMainMenuOptions(sc);
    }
  }

  // 1-1: A customer decides to browse and search for products
  // Handle customer Teacher Option
  public void handleTeacherOption(Scanner sc, Market marketTeachers) {

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

      handleTeacherFacebook(sc);
    }

    // 3. Previous Page
    if (input.equals("3")) {
      CustomerOption(sc);
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleTeacherOption(sc, marketTeachers);
    }

  }

  // 1-1: A customer decides to browse and search for products
  // Handle customer teacher & instagram
  public void handleTeacherInstagram(Scanner sc) {
    // TI
    SolutionOffer amazonBundlesProductsTI = model.getAmazonBundlesProductsTI();
    SolutionOffer groceryBundlesProductsTI = model.getGroceryBundlesProductsTI();
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1-2: The product descriptions and ads must speak the customer language.
    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsTI.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsTI.findProductsName();

      handleBuyOrNot(sc, amazonBundlesProductsTI);
    }

    // 1-2: The product descriptions and ads must speak the customer language.
    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsTI.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsTI.finProductsIngredientName();

      handleBuyOrNot(sc, groceryBundlesProductsTI);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleTeacherOption(sc, model.getMarketTeachers());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleTeacherInstagram(sc);
    }

  }

  // 1-1: A customer decides to browse and search for products
  // Handle teacher & facebook
  public void handleTeacherFacebook(Scanner sc) {
    // TF
    SolutionOffer amazonBundlesProductsTF = model.getAmazonBundlesProductsTF();
    SolutionOffer groceryBundlesProductsTF = model.getGroceryBundlesProductsTF();
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1-2: The product descriptions and ads must speak the customer language.
    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsTF.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsTF.findProductsName();

      handleBuyOrNot(sc, amazonBundlesProductsTF);
    }

    // 1-2: The product descriptions and ads must speak the customer language.
    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsTF.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsTF.finProductsIngredientName();

      handleBuyOrNot(sc, groceryBundlesProductsTF);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleTeacherOption(sc, model.getMarketTeachers());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleTeacherFacebook(sc);
    }

  }

  // 1-1: A customer decides to browse and search for products
  // Handle Student Option
  public void handleStudentOption(Scanner sc, Market marketStudents) {

    System.out.println("This is the list of the " + marketStudents.getCustomersID());
    System.out.println("What's the channel you use? Please pick an option");
    System.out.println("1. Instagram");
    System.out.println("2. Facebook");
    System.out.println("3. Exit");

    String input = sc.next();

    // 1. I am a student and choose 1. Instagram
    if (input.equals("1")) {
      model.getSi().printInfo();

      handleStudentInstagram(sc);
    }

    // 1. I am a student and choose 2. Facebook
    if (input.equals("2")) {
      model.getSf().printInfo();

      handleStudentFacebook(sc);
    }

    // 3. Previous Page
    if (input.equals("3")) {
      CustomerOption(sc);
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");
      handleStudentOption(sc, marketStudents);
    }
  }

  // 1-1: A customer decides to browse and search for products
  // Handle student & instagram
  public void handleStudentInstagram(Scanner sc) {
    // SI
    SolutionOffer amazonBundlesProductsSI = model.getAmazonBundlesProductsSI();
    SolutionOffer groceryBundlesProductsSI = model.getGroceryBundlesProductsSI();
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1-2: The product descriptions and ads must speak the customer language.
    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsSI.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsSI.findProductsName();

      handleBuyOrNot(sc, amazonBundlesProductsSI);
    }

    // 1-2: The product descriptions and ads must speak the customer language.
    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsSI.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsSI.finProductsIngredientName();

      handleBuyOrNot(sc, groceryBundlesProductsSI);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleStudentOption(sc, model.getMarketStudents());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleStudentInstagram(sc);
    }

  }

  // 1-1: A customer decides to browse and search for products
  // Handle student & facebook
  public void handleStudentFacebook(Scanner sc) {
    // SF
    SolutionOffer amazonBundlesProductsSF = model.getAmazonBundlesProductsSF();
    SolutionOffer groceryBundlesProductsSF = model.getGroceryBundlesProductsSF();
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1-2: The product descriptions and ads must speak the customer language.
    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsSF.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsSF.findProductsName();

      handleBuyOrNot(sc, amazonBundlesProductsSF);
    }

    // 1-2: The product descriptions and ads must speak the customer language.
    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsSF.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsSF.finProductsIngredientName();

      handleBuyOrNot(sc, groceryBundlesProductsSF);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleStudentOption(sc, model.getMarketStudents());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");
      handleStudentFacebook(sc);
    }

  }

  // private void confirmOrder(SolutionOffer so) {
  // model.addOrder
  // }

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
      // confirmOrderItems(so);
    }

    // 2. No
    if (input.equals("2")) {
      System.out.println("Thank you for your time! Have a nice day!");
    }

    // 3. Exit
    if (input.equals("3")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }
  }

  // 2-5: Create and generate reports that show the total sales revenues and the
  // sales revenues by market and channel.
  // Handle Sales Orders Option
  public void SalesOrdersOption(Scanner sc) {

    System.out.println("This is the list of the Sales Orders");
    System.out.println("What's the report you would like to check? Please pick an option");
    System.out.println("1. Total Sales");
    System.out.println("2. What Market and Channel?");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Total Sales
    if (input.equals("1")) {
      int totalSales = model.getSolutionoffercatalog().totalSalesRevenues();
      System.out.println("Total Sales Revenues: $" + totalSales);
    }

    // 2. What Market and Channel?
    if (input.equals("2")) {
      ManagingMarketOption(sc);
    }

    // 3. Previous Page
    if (input.equals("3")) {
      renderMainMenuOptions(sc);
    }
    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

  }

  // Handle managing Market Option
  public void ManagingMarketOption(Scanner sc) {

    System.out.println("What market you are looking for? Please pick an option:");
    System.out.println("1. Market Teacher");
    System.out.println("2. Market Student");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. I am a teacher
    if (input.equals("1")) {
      ManagingTeacherOption(sc, model.getMarketTeachers());
    }

    // 2. I am an student
    if (input.equals("2")) {
      ManagingStudentOption(sc, model.getMarketStudents());
    }

    // 3. Previous Page
    if (input.equals("3")) {
      SalesOrdersOption(sc);
    }

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      ManagingMarketOption(sc);
    }
  }

  // Handle managing Teacher Option
  public void ManagingTeacherOption(Scanner sc, Market marketTeachers) {

    System.out.println("This is the list of the " + marketTeachers.getCustomersID());
    System.out.println("What's the channel you use? Please pick an option");
    System.out.println("1. Instagram");
    System.out.println("2. Facebook");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Market Teacher and choose 1. Instagram
    if (input.equals("1")) {
      ManagingTeacherInstagram(sc);
    }

    // 1. Market Teacher and choose 2. Facebook
    if (input.equals("2")) {
      ManagingTeacherFacebook(sc);
    }

    // 3. Previous Page
    if (input.equals("3"))
      ManagingMarketOption(sc);

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      ManagingTeacherOption(sc, marketTeachers);
    }
  }

  // Handle managing teacher & instagram
  public void ManagingTeacherInstagram(Scanner sc) {
    // TI
    SolutionOffer amazonBundlesProductsTI = model.getAmazonBundlesProductsTI();
    SolutionOffer groceryBundlesProductsTI = model.getGroceryBundlesProductsTI();
    System.out.println("Check ads and solution bundles. Please pick an option");
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      model.getTi().printInfo();

      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsTI.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsTI.findProductsName();

      int total = amazonBundlesProductsTI.getSalesVolume();
      System.out.println("The Sales Revenues by Market Teacher, Channel Instagram, Total is $" + total);
    }

    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      model.getTi().printInfo();

      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsTI.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsTI.finProductsIngredientName();

      int total = groceryBundlesProductsTI.getSalesVolume();

      System.out.println("The Sales Revenues by Market Teacher, Channel Instagram, Ads Grocery Bundles Products is $"
          + total);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleTeacherOption(sc, model.getMarketTeachers());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleTeacherInstagram(sc);
    }

  }

  // Handle managing teacher & facebook
  public void ManagingTeacherFacebook(Scanner sc) {
    // TF
    SolutionOffer amazonBundlesProductsTF = model.getAmazonBundlesProductsTF();
    SolutionOffer groceryBundlesProductsTF = model.getGroceryBundlesProductsTF();
    System.out.println("Check ads and solution bundles. Please pick an option");
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      model.getTf().printInfo();

      System.out.println("Including all these items, the total cost is only $" +
          amazonBundlesProductsTF.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsTF.findProductsName();

      int total = amazonBundlesProductsTF.getSalesVolume();

      System.out.println("The Sales Revenues by Market Teacher, Channel Facebook, Ads Amazon Bundles Products is $"
          + total);
    }

    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      model.getTf().printInfo();

      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsTF.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsTF.finProductsIngredientName();

      int total = groceryBundlesProductsTF.getSalesVolume();

      System.out.println("The Sales Revenues by Market Teacher, Channel Facebook, Ads Grocery Bundles Products is $"
          + total);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleTeacherOption(sc, model.getMarketTeachers());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");
      handleTeacherFacebook(sc);
    }

  }

  // Handle managing Student Option
  public void ManagingStudentOption(Scanner sc, Market marketStudents) {

    System.out.println("This is the list of the " + marketStudents.getCustomersID());
    System.out.println("What's the channel you use? Please pick an option");
    System.out.println("1. Instagram");
    System.out.println("2. Facebook");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Market Student and choose 1. Instagram
    if (input.equals("1")) {
      ManagingStudentInstagram(sc);
    }

    // 1. Market Student and choose 2. Facebook
    if (input.equals("2")) {
      ManagingStudentFacebook(sc);
    }

    // 3. Previous Page
    if (input.equals("3"))
      ManagingMarketOption(sc);

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      ManagingStudentOption(sc, marketStudents);
    }
  }

  // Handle managing student & instagram
  public void ManagingStudentInstagram(Scanner sc) {
    // SI
    SolutionOffer amazonBundlesProductsSI = model.getAmazonBundlesProductsSI();
    SolutionOffer groceryBundlesProductsSI = model.getGroceryBundlesProductsSI();
    System.out.println("Check ads and solution bundles. Please pick an option");
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      model.getSi().printInfo();

      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsSI.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsSI.findProductsName();

      int total = amazonBundlesProductsSI.getSalesVolume();

      System.out.println("The Sales Revenues by Market Student, Channel Instagram, Ads Amazon Bundles Products is $"
          + total);
    }

    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      model.getSi().printInfo();

      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsSI.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsSI.finProductsIngredientName();

      int total = groceryBundlesProductsSI.getSalesVolume();

      System.out.println("The Sales Revenues by Market Student, Channel Instagram, Ads Grocery Bundles Products is $"
          + total);
    }

    // 3. Previous Page
    if (input.equals("3"))
      ManagingStudentOption(sc, model.getMarketStudents());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");

      handleStudentInstagram(sc);
    }
  }

  // Handle managing student & facebook
  public void ManagingStudentFacebook(Scanner sc) {

    // SF
    SolutionOffer amazonBundlesProductsSF = model.getAmazonBundlesProductsSF();
    SolutionOffer groceryBundlesProductsSF = model.getGroceryBundlesProductsSF();
    System.out.println("Check ads and solution bundles. Please pick an option");
    System.out.println("1. Amazon Bundles Products");
    System.out.println("2. Grocery Bundles Products");
    System.out.println("3. Previous Page");
    System.out.println("4. Exit");

    String input = sc.next();

    // 1. Amazon Bundles Products
    if (input.equals("1")) {
      model.getSf().printInfo();

      System.out.println("Including all these items, the total cost is only $" + amazonBundlesProductsSF.getPrice()
          + "! Act fast before it's gone! ");
      amazonBundlesProductsSF.findProductsName();

      int total = amazonBundlesProductsSF.getSalesVolume();

      System.out.println("The Sales Revenues by Market Student, Channel Facebook, Ads Amazon Bundles Products is $"
          + total);
    }

    // 2. Grocery Bundles Products
    if (input.equals("2")) {
      model.getSf().printInfo();

      System.out.println("Including all these items, the total cost is only $" + groceryBundlesProductsSF.getPrice()
          + "! Act fast before it's gone! ");
      groceryBundlesProductsSF.finProductsIngredientName();

      int total = groceryBundlesProductsSF.getSalesVolume();

      System.out.println("The Sales Revenues by Market Student, Channel Facebook, Ads Grocery Bundles Products is $"
          + total);
    }

    // 3. Previous Page
    if (input.equals("3"))
      handleStudentOption(sc, model.getMarketStudents());

    // 4. Exit
    if (input.equals("4")) {
      System.out.println("Thank you, have a nice day.");
      sc.close();
    }

    // if user press other keys
    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
      System.out.println("Please enter a valid option.");
      handleStudentFacebook(sc);
    }
  }

  // 2-6: Generate creative ideas beyond the requirements.
  public static DigitalMarketApplicationModel populateModel() {
    // 1-3: Configuring products and services as solution bundles targeting
    // different markets and channels. Markets, channels, and customer types are
    // configured and populated as well.

    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100, 10);
    SupplierDirectory sd = business.getSupplierDirectory();
    MasterOrderList mol = business.getMasterOrderList();
    MasterOrderReport orderReport = mol.generateMasterOrderReport();
    MarketCatalog marketCatalog = business.getMarketcatalog();
    ChannelCatalog channelCatalog = business.getChannelcatalog();
    SolutionOfferCatalog solutionoffercatalog = business.getSolutionoffercatalog();
    MasterSolutionOrderList masterSolutionOrderList = business.getMastersolutionorderlist();

    // market
    Market marketTeachers = marketCatalog.newMarket("teacher");
    Market marketStudents = marketCatalog.newMarket("student");
    Channel channelInstagram = channelCatalog.newChannel("Instagram");
    Channel channelFacebook = channelCatalog.newChannel("Facebook");
    MarketChannelAssignment ti = new MarketChannelAssignment(marketTeachers, channelInstagram,
        18000.0);
    MarketChannelAssignment tf = new MarketChannelAssignment(marketTeachers, channelFacebook,
        17700.0);
    MarketChannelAssignment si = new MarketChannelAssignment(marketStudents, channelInstagram,
        10200.0);
    MarketChannelAssignment sf = new MarketChannelAssignment(marketStudents, channelFacebook,
        10000.0);

    // Soulution Offer (Bundle of products)
    ArrayList<Product> allProducts = sd.findAllProducts();
    ArrayList<Product> amazonBundlesProducts = solutionoffercatalog.setRandomProducts(allProducts, 5);
    ArrayList<Product> groceryBundlesProducts = solutionoffercatalog.setRandomProducts(allProducts, 5);

    // solution offer
    // 1-1: The system displaces bundled products and services (solution) as well as
    // ads that match customer expectations.
    // // TI
    SolutionOffer amazonBundlesProductsTI = solutionoffercatalog.newSolutionOffer(
        "Amazon Bundles Products for Teachers on Instagram", ti,
        amazonBundlesProducts, 1000);
    SolutionOffer groceryBundlesProductsTI = solutionoffercatalog.newSolutionOffer(
        "Grocery Bundles Products for Teachers on Instagram", ti, groceryBundlesProducts,
        1370);

    // TF
    SolutionOffer amazonBundlesProductsTF = solutionoffercatalog
        .newSolutionOffer("Amazon Bundles Products for Teachers on Facebook", tf, amazonBundlesProducts, 1770);
    SolutionOffer groceryBundlesProductsTF = solutionoffercatalog
        .newSolutionOffer("Grocery Bundles Products for Teachers on Facebook", tf, groceryBundlesProducts, 1880);

    // SI
    SolutionOffer amazonBundlesProductsSI = solutionoffercatalog
        .newSolutionOffer("Amazon Bundles Products for Students on Instagram", si, amazonBundlesProducts, 1005);
    SolutionOffer groceryBundlesProductsSI = solutionoffercatalog
        .newSolutionOffer("Grocery Bundles Products for Students on Instagram", si, groceryBundlesProducts, 999);

    // SF
    SolutionOffer amazonBundlesProductsSF = solutionoffercatalog
        .newSolutionOffer("Amazon Bundles Products for Students on Facebook", sf, amazonBundlesProducts, 1050);
    SolutionOffer groceryBundlesProductsSF = solutionoffercatalog
        .newSolutionOffer("Grocery Bundles Products for Students on Facebook", sf, groceryBundlesProducts, 1030);

    // 2-4: Autogenerate sales orders with different pricing options as well as
    // product, people, markets, and channel perspectives.
    // Solution Order and Order Item
    // TI
    Business.createABusinessAndSolutions(business, 10, 10, amazonBundlesProductsTI);
    Business.createABusinessAndSolutions(business, 10, 10, groceryBundlesProductsTI);

    // TF
    Business.createABusinessAndSolutions(business, 10, 10, amazonBundlesProductsTF);
    Business.createABusinessAndSolutions(business, 10, 10, groceryBundlesProductsTF);

    // SI
    Business.createABusinessAndSolutions(business, 10, 10, amazonBundlesProductsSI);
    Business.createABusinessAndSolutions(business, 10, 10, groceryBundlesProductsSI);

    // SF
    Business.createABusinessAndSolutions(business, 10, 10, amazonBundlesProductsSF);
    Business.createABusinessAndSolutions(business, 10, 10, groceryBundlesProductsSF);

    return new DigitalMarketApplicationModel(business, sd, mol, orderReport, marketCatalog, channelCatalog,
        solutionoffercatalog, masterSolutionOrderList, marketTeachers, marketStudents, channelInstagram,
        channelFacebook, ti, tf, si, sf,
        allProducts, amazonBundlesProducts, groceryBundlesProducts, amazonBundlesProductsTI, groceryBundlesProductsTI,
        amazonBundlesProductsTF, groceryBundlesProductsTF, amazonBundlesProductsSI, groceryBundlesProductsSI,
        amazonBundlesProductsSF, groceryBundlesProductsSF);

  }
}
