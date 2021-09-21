package com.example.listingapp.endPoint;

import com.example.listingapp.entity.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
@RequiredArgsConstructor
public class ListingEndPoint {

    private final ListingService listingService;

    @GetMapping
    public List<Listing> getAllListing() {
        return listingService.getAllListings();
    }

    @GetMapping("/byUser/{email}")
    public List<Listing> getByEmail(@RequestBody Listing listing) {
        return listingService.getByUserEmail(listing.getUser().getEmail());
    }

    @GetMapping("/byCategory/{categoryId}")
    public List<Listing> getByCategoryId(@RequestBody Listing listing) {
        return listingService.getByCategory(listing.getCategory().getId());
    }


    @GetMapping("/{id}")
    public Listing getById(@PathVariable("id") int id) {
        return listingService.getListingsById(id);
    }

    @PostMapping
    public void addListing(@RequestBody Listing listing) {
        listingService.addListing(listing);
    }

    @PutMapping
    public ResponseEntity<Listing> updateListing(@RequestBody Listing listing) {
        Listing listingsById = listingService.getListingsById(listing.getId());
        if (listingsById == null) {
            return ResponseEntity.ok(listingService.addListing(listing));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable("id") int id) {
        listingService.deleteListingByID(id);
    }

}
