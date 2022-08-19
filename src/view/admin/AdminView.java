package view.admin;

import config.Config;
import controller.CategoryController;
import controller.ProductController;
import plugin.Menu;

public class AdminView {

    CategoryController categoryController = new CategoryController();
    ProductController productController = new ProductController();

    public void menu() {
        Menu menu = new Menu();
        menu.addHeader("MENU");
        menu.addChoice("1. Category manage");
        menu.addChoice("2. Product manage");
        menu.addChoice("3. Log out");

        menu.addPaddingLeft(4);

        menu.print();

        int choice = Config.getIntegerInput();

        switch (choice) {
            case 1:
                this.formCategoryManage();
                break;
            case 2:
                this.formProductManage();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice");
        }

        menu();
    }

    private void formCategoryManage() {
        System.out.println(categoryController.getCategoryList());
    }

    private void formProductManage() {
        System.out.println(productController.getProductList());
    }
}
