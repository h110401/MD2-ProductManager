package service.category;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {

    static List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category(1, "Dau an", "Khong chi de nau an"));
        categoryList.add(new Category(2, "Ao mua", "Condomdom"));
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category e) {
        categoryList.add(e);
    }
}
