package com.example.listingapp.endPoint;

import com.example.listingapp.entity.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryEndPoint {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getById(int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category categoryById = categoryService.getCategoryById(category.getId());
        if (categoryById == null) {
            return ResponseEntity.ok(categoryService.addCategory(category));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategoryByID(id);
    }

}
