package model.MarketModel;

import java.util.List;

import com.github.javafaker.Business;

import java.util.ArrayList;

public class AdvertisementCatalog {
  Business business;
  List<Advertisement> advertisements;

  public AdvertisementCatalog() {
    this.advertisements = new ArrayList<>();

    advertisements.add(new Advertisement(
        "Hi! Are you a teacher? For a limited time on Instagram, teachers can now purchase all the following items at a discounted price!"));
    advertisements.add(new Advertisement(
        "Hi! Are you a teacher? For a limited time on Facebook, teachers can now purchase all the following items at a discounted price!"));
    advertisements.add(new Advertisement(
        "Hi! Are you a student? For a limited time on Instagram, students can now purchase all the following items at a discounted price!"));
    advertisements.add(new Advertisement(
        "Hi! Are you a student? For a limited time on Facebook, students can now purchase all the following items at a discounted price!"));
  }

  public List<Advertisement> getAdvertisements() {
    return advertisements;
  }
}
