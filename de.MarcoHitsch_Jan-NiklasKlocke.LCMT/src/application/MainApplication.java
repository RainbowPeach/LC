package application; /**
 * Created by peach on 5/8/16.
 */

import java.io.IOException;

import application.model.Card;
import application.view.CardOverViewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootView;

    private ObservableList<Card> cards = FXCollections.observableArrayList();

    public ObservableList<Card> getCards() {
        return cards;
    }

    public void setCards(ObservableList<Card> cards) {
        this.cards = cards;
    }

    /**
     * just for current testing
     */
    public MainApplication(){
        cards.add(new Card("Frage1",
                "HTMLArtikel1",
                "Kategorie1",
                "Kotext1",
                "keyword1", "keyword2", "keyword3"));

        cards.add(new Card("Frage2",
                "HTMLArtikel2",
                "Kategorie2",
                "Kotext2",
                "keyword1", "keyword2", "keyword3"));

        cards.add(new Card("Frage3",
                "HTMLArtikel3",
                "Kategorie3",
                "Kotext3",
                "keyword1", "keyword2", "keyword3"));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("LCMT -> Learning Card Management Tool");
        initRootView();
        showBarView();
        showCardOverView();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootView() {
        try {
            // Load rootView from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("view/RootView.fxml"));
            rootView = (BorderPane) loader.load();

            // Show the scene containing the rootView.
            Scene scene = new Scene(rootView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the CardOverView inside the rootView.
     */
    public void showCardOverView() {
        try {
            // Load CardOverView.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("view/CardOverView.fxml"));
            AnchorPane cardOverView = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            CardOverViewController controller = loader.getController();
            controller.setMainApp(this);

            // Set CardOverView into the center of rootView.
            rootView.setCenter(cardOverView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the BarView inside the rootView
     */
    public void showBarView(){
        try{
            //Load BarView
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("view/BarView.fxml"));
            VBox barView = (VBox) loader.load();

            // Set BarView into Top of rootView.
            rootView.setTop(barView);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}