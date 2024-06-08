package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    private Media meida;

    public ItemController(Media media, Cart cart){
        this.media=media;
        this.cart=cart;
    }

    public ItemController(Cart cart) {
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws PlayerException {
//        Media media=this.media;
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Media media=this.media;
        try{
            ((Playable)media).play();
        } catch(Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void setData(Media media){
        this.media=meida;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+" $");
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0,0,0,60));
        }
    }

}
