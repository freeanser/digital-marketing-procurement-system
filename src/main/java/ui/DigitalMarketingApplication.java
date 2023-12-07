/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    // 1. Populate the model +

    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100, 10);

    SupplierDirectory sd = business.getSupplierDirectory();

    MasterOrderList mol = business.getMasterOrderList();
    MasterOrderReport orderReport = mol.generateMasterOrderReport();
    MarketCatalog marketCatalog = business.getMarketcatalog();
    // Generate data
    Market marketTeachers = marketCatalog.newMarket("teacher");
    Market marketStudents = marketCatalog.newMarket("student");

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

        Scanner sc1 = new Scanner(System.in);

        boolean exitCode1 = false;

        while (!exitCode1) {
          System.out.println("This is the list of the teachers: " + marketTeachers.getCustomersID());
          System.out.println("What's the channel you use? Please pick an option");
          System.out.println("1. Instagram");
          System.out.println("2. Facebook");
          System.out.println("3. Exit");

          String input1 = sc1.next();

          // System.out.println(input);

          // 1. I am a teacher and choose 1. Instagram
          if (input1.equals("1")) {

          }

          // 1. I am a teacher and choose 2. Facebook
          if (input1.equals("2")) {

          }

          if (input1.equals("3"))
            exitCode1 = true;

          sc1.close();
        }

      }

      // 2. I am an student
      if (input.equals("2")) {

        Scanner sc1 = new Scanner(System.in);

        boolean exitCode1 = false;

        while (!exitCode1) {
          System.out.println("What's the channel you use? Please pick an option");
          System.out.println("1. Instagram");
          System.out.println("2. Facebook");
          System.out.println("3. Exit");

          String input1 = sc1.next();

          // System.out.println(input);

          // 1. I am a student and choose 1. Instagram
          if (input1.equals("1")) {

          }

          // 1. I am a student and choose 2. Facebook
          if (input1.equals("2")) {

          }

          if (input1.equals("3"))
            exitCode1 = true;

          sc1.close();
        }
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

    // 3. Show some analytics (Summarizing, comparing, sorting, grouping data by
    // some criteria)

    // business.printShortInfo();

    // Faker magicBox = new Faker();

    // System.out.println("================== First, Last name ==================
    // ");
    // for (int index=0; index < 50; index++){
    // String fullName = magicBox.name().fullName();
    // System.out.println(fullName);
    // }

    // System.out.println("================== Companies ================== ");

    // for (int index=0; index < 50; index++){
    // String companyName = magicBox.company().name();
    // System.out.println(companyName);
    // }

    // System.out.println("================== Products ================== ");

    // for (int index=0; index < 50; index++){
    // String product = magicBox.commerce().productName();
    // System.out.println(product);
    // }

    // System.out.println("================== Yoda Quotes ================== ");

    // for (int index=0; index < 50; index++){
    // String quote = magicBox.yoda().quote();
    // System.out.println(quote);
    // }

    sc.close();

  }
}
