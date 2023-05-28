package javafx2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProductController {
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtQty;
    public TextField txtDescription;
    public TextField txtCategory;
    public static ObservableList<Product> listProducts = FXCollections.observableArrayList();
    public ListView<Product> productView;
    public static Product editProduct;
//    public static Product deleteProducts;
//    public static ObservableList<Product> deleteProducts = FXCollections.observableArrayList();
    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
        String price = txtPrice.getText();
        String qty = txtQty.getText();
        String des = txtDescription.getText();
        String category = txtCategory.getText();
        if (editProduct != null) {
            editProduct.setName(name);
            editProduct.setPrice(price);
            editProduct.setQty(qty);
            editProduct.setDes(des);
            editProduct.setCategory(category);
            productView.setItems(listProducts);
            productView.refresh();
            editProduct = null;
            clear();
            return;
        }
        try {
            for (Product p: listProducts) {
                if (p.getName().equals(name))
                    throw new Exception("Ten sp da ton tai");
            }
            Product pd = new Product(name, price, qty, des, category);
            listProducts.add(pd);
            productView.setItems(listProducts);
            clear();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void editProduct(MouseEvent mouseEvent) {
        editProduct = productView.getSelectionModel().getSelectedItem();
        if (editProduct != null) {
            txtName.setText(editProduct.getName());
            txtPrice.setText(editProduct.getPrice());
            txtQty.setText(editProduct.getQty());
            txtDescription.setText(editProduct.getDes());
            txtCategory.setText(editProduct.getCategory());
        }
    }

    public void delete(ActionEvent mouseEvent) {
        try {
            productView.setItems(listProducts);
            productView.refresh();
            editProduct = null;
            clear();
            editProduct = productView.getSelectionModel().getSelectedItem();
            if (editProduct != null) {
                for (Product product: listProducts) {
                    listProducts.remove(product);
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    public void clear() {
        txtName.clear();
        txtPrice.clear();
        txtQty.clear();
        txtDescription.clear();
        txtCategory.clear();
    }

}


