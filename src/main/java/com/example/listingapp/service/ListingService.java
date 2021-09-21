package com.example.listingapp.service;

import com.example.listingapp.entity.Category;
import com.example.listingapp.entity.Listing;

import java.util.List;

public interface ListingService {

    List<Listing> getAllListings();

    Listing getListingsById(int id);

    Listing addListing(Listing listing);

    List<Listing> getByUserEmail(String email);

    List<Listing> getByCategory(int categoryId);

    void deleteListingByID(int id);


}
