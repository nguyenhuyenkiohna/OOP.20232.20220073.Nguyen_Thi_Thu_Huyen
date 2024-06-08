package hust.soict.globalict.screen.customer.store;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
    private static Store store;
    private static Cart cart;

    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args){
        store=new Store();
        cart = new Cart();
        launch(args);
    }
}