package com.example.listingapp.service.impl;

import com.example.listingapp.entity.Category;
import com.example.listingapp.entity.Listing;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @Override
    public Listing getListingsById(int id) {
        return listingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Listing addListing(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public List<Listing> getByUserEmail(String email) {
        return listingRepository.findByUser_Email(email);
    }

    @Override
    public List<Listing> getByCategory(int categoryID) {
        return listingRepository.findByCategory_Id(categoryID);
    }

    @Override
    public void deleteListingByID(int id) {
        listingRepository.deleteById(id);
    }
}
