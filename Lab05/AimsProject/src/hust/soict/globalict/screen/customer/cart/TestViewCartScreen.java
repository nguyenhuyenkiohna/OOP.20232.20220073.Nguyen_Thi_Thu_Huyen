package hust.soict.globalict.screen.customer.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
    private static Cart cart;

    public void start(Stage basicStage) throws Exception{
        String CART_FXML_FILE_PATH ="hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        CartController cartController = new CartController(new Store(), cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();
        basicStage.setTitle("Cart");
        basicStage.setScene(new Scene(root));
        basicStage.show();
    }

    public static void main(String[] args) throws Exception{
        cart = new Cart();

        ObservableList<String> author1 = FXCollections.observableArrayList("Joshua Bloch", "Ki Oh Na");
        ObservableList<String> author2 = FXCollections.observableArrayList("Robert C.Martin", "StrongDz");
        ObservableList<String> author3 = FXCollections.observableArrayList("Ardrew Hunt", "David Thomas");

        Book book1 = new Book(1, "Effective Java", "Programming", 45.00f,author1);
        Book book2 = new Book(2, "Clean Code", "Programming", 40.00f,author2);
        Book book3 = new Book(1, "The Pragmatic Programmer", "Programming", 50.00f,author3);

        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);

        ObservableList<Track> tracks1 = FXCollections.observableArrayList();
        tracks1.add(new Track("Track one",320));
        tracks1.add(new Track("Track two",250));
        tracks1.add(new Track("Track three",300));

        CompactDisc cd1 = new CompactDisc(1,"Best of 2020", "Pop", "Various Artists", "Director A", tracks1, 19.99f);

        ObservableList<Track> tracks2= FXCollections.observableArrayList();
        tracks2.add(new Track("Track four",360));
        tracks2.add(new Track("Track five",400));
        tracks2.add(new Track("Track six",120));

        CompactDisc cd2 = new CompactDisc(2,"Rock Classics", "Rock", "Various Artists", "Director B", tracks2, 24.99f);

        ObservableList<Track> tracks3 = FXCollections.observableArrayList();
        tracks3.add(new Track("Track seven",732));
        tracks3.add(new Track("Track eight",512));
        tracks3.add(new Track("Track nice",382));

        CompactDisc cd3 = new CompactDisc(3,"Jazz Favorites", "Jazz", "Various Artists", "Director C", tracks3, 22.99f);

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Godfather", "Crime", "Francis Ford Coppola", 175, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Dark Knight", "Action", "Christopher Nolan", 152, 22.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        launch(args);
    }
}