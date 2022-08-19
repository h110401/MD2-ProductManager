package controller;

import model.Category;
import service.category.CategoryServiceIMPL;
import service.category.ICategoryService;

import java.util.List;

public class CategoryController {

    ICategoryService categoryService = new CategoryServiceIMPL();

    public List<Category> getCategoryList() {
        return categoryService.findAll();
    }

    public void saveCategory(Category category) {
        categoryService.save(category);
    }

}
