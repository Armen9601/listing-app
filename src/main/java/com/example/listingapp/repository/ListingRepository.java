package com.example.listingapp.repository;

import com.example.listingapp.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    List<Listing> findByCategory_Id(int id);

    List<Listing> findByUser_Email(String email);
}
