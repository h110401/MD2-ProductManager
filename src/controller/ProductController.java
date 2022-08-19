package controller;

import model.Product;
import service.product.IProductService;
import service.product.ProductServiceIMPL;

import java.util.List;

public class ProductController {

    IProductService productService = new ProductServiceIMPL();

    public List<Product> getProductList() {
        return productService.findAll();
    }

    public void saveProduct(Product product) {
        productService.save(product);
    }

}
