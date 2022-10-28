package com.example.BudgetApp.category;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<List<Category>> getAllCategories(){
        try{
            return ResponseEntity.ok(categoryRepository.findAll());
        } catch (Exception e) {
            log.error("Error with \"getAllCategories\"");
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Category> getCategoryById (UUID id) {
        Optional<Category> categoryData = categoryRepository.findById(id);
        if (categoryData.isPresent()) {
            return ResponseEntity.ok(categoryData.get());
        } else {
            log.info("Category not found");
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Category> addCategory(Category category) {
        try {
            Category _category = categoryRepository.save(new Category(category.getBudget(), category.getName(), category.getStartDate(), category.getEndDate()));
            return ResponseEntity.ok(_category);
        } catch (Exception e) {
            log.info("createCategory exception: "+ category.toString()+e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Category> updateCategory(Category category) {
        try {
            Category categoryData = categoryRepository.findById(category.getId()).stream()
                    .findFirst()
                    .orElse(null);
            if (categoryData == null)
                throw new Exception();
            return new ResponseEntity<>(categoryRepository.save(category), HttpStatus.OK);
        } catch (Exception e) {
            log.info("updateCategory exception: "+ category.toString()+e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<HttpStatus> deleteCategory(UUID id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info("deleteCategory exception: "+ id.toString()+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
