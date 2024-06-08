package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
//import java.text.DecimalFormat;
//import java.text.MessageFormat;
//import java.util.Optional;
//
//import static hust.soict.globalict.aims.cart.Cart;

public class CartController {
    private Cart cart;
    private Store store;
    private Media curMedia;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                showFiltereMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable) media).play();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have not put anything in your cart");
            return;
        }
        JOptionPane.showMessageDialog(null, "You did successfully order! Total cost is " + costLabel.getText());
        cart.clear();
        updateTotalCost();
    }

    public void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    public void showFiltereMedia(String filter) {
        ObservableList<Media> newcart;
        if (radioBtnFilterId.isSelected()) {
            newcart = cart.SearchByID(Integer.parseInt(filter));
        } else {
            newcart = cart.SearchByTitle(filter);
        }
        tblMedia.setItems(newcart);
    }
}
