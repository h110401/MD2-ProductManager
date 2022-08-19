package service.product;

import model.Product;
import service.category.CategoryServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {

    static List<Product> productList = new ArrayList<>();

    static {
        CategoryServiceIMPL categoryService = new CategoryServiceIMPL();

        productList.add(new Product(1, "Neptune", "Trơn", 2, categoryService.findAll().get(0)));
        productList.add(new Product(2, "Castrol Power", "Hot", 5, categoryService.findAll().get(0)));
        productList.add(new Product(3, "Hayashi", "0.01", 10, categoryService.findAll().get(1)));

    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product e) {
        productList.add(e);
    }
}
