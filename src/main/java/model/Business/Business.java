/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;
import java.util.Random;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.MarketCatalog;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterSolutionOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.SolutionOrder;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.ProductManagement.SolutionOffer;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory;
    MasterOrderList masterorderlist;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    SolutionOfferCatalog solutionoffercatalog;
    MasterSolutionOrderList mastersolutionorderlist;
    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();
        solutionoffercatalog = new SolutionOfferCatalog();
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory(this);
        marketcatalog = new MarketCatalog(this);
        channelcatalog = new ChannelCatalog(this);
        mastersolutionorderlist = new MasterSolutionOrderList(this);

    }

    public static void createABusinessAndSolutions(Business business, int soOrderCount, int soItemCount,
            SolutionOffer solutionOffer) {

        // Add Solution Order
        loadSolutionOrders(business, soOrderCount, soItemCount, solutionOffer);

    }

    static int getRandom(int lower, int upper) {
        Random r = new Random();

        // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
        // numbers from 10 to 15
        // I will have result = 10 + nextInt(5)
        int randomInt = lower + r.nextInt(upper - lower);
        return randomInt;
    }

    public static void loadSolutionOrders(Business b, int orderCount, int itemCount,
            SolutionOffer solutionOffer) {
        MasterSolutionOrderList masterSolutionOrderList = b.getMastersolutionorderlist();

        // pick a random customer (reach to customer directory)
        CustomerDirectory cd = b.getCustomerDirectory();

        for (int index = 0; index < orderCount; index++) {

            CustomerProfile randomCustomer = cd.pickRandomCustomer();
            if (randomCustomer == null) {
                System.out.println("Cannot generate orders. No customers in the customer directory.");
                return;
            }

            // create an order for that customer
            SolutionOrder randomOrder = masterSolutionOrderList.newSOOrder(randomCustomer);

            int randomItemCount = getRandom(1, itemCount);
            for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {
                int price = solutionOffer.getPrice();
                int quantity = solutionOffer.getProducts().size();
                int randomPrice = getRandom((price - 20), (price + 20));
                int randomQuantity = getRandom((quantity - 1), (quantity + 1));

                randomOrder.newOrderItem(solutionOffer, randomPrice, randomQuantity,
                        randomOrder);
            }
        }
        // Make sure order items are connected to the order

    }

    public MasterSolutionOrderList getMastersolutionorderlist() {
        return mastersolutionorderlist;
    }

    public SolutionOfferCatalog getSolutionoffercatalog() {
        return solutionoffercatalog;
    }

    public void setSolutionoffercatalog(SolutionOfferCatalog solutionoffercatalog) {
        this.solutionoffercatalog = solutionoffercatalog;
    }

    public ChannelCatalog getChannelcatalog() {
        return channelcatalog;
    }

    public void setChannelcatalog(ChannelCatalog channelcatalog) {
        this.channelcatalog = channelcatalog;
    }

    public MarketCatalog getMarketcatalog() {
        return marketcatalog;
    }

    public void setMarketcatalog(MarketCatalog marketcatalog) {
        this.marketcatalog = marketcatalog;
    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); // return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the business hierarchy.");
        suppliers.printShortInfo();
        customerdirectory.printShortInfo();
        masterorderlist.printShortInfo();
    }

}
