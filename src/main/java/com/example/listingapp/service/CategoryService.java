package com.example.listingapp.service;

import com.example.listingapp.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category getCategoryById(int id);

    Category addCategory(Category category);

    void deleteCategoryByID(int id);



}
