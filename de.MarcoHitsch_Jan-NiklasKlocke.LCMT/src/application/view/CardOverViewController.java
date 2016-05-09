package application.view;

/**
 * Created by peach on 5/8/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.MainApplication;
import application.model.Card;

public class CardOverViewController {
    @FXML
    private TableView<Card> CardTable;
    //ToDo add TableView for Sets
    @FXML
    private TableColumn<Card, String> questionColumn;
    @FXML
    private Label questionLabel;
    @FXML
    private Label articleLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label contextLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label keyWordsLabel;

    // Reference to the main application.
    private MainApplication main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMainApp(MainApplication main) {
        this.main = main;

        // Add observable list data to the table
        CardTable.setItems(main.getCards());
    }

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CardOverViewController() {
    }

    /**
     * Initializes the application.controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the question table.
        questionColumn.setCellValueFactory(cellData -> cellData.getValue().questionProperty());

        // Clear Card details.
        showCardDetails(null);

        // Listen for selection changes and show the Card details when changed.
        CardTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCardDetails(newValue));
    }

    /**
     * Fills all text fields to show details about the card.
     * If the specified card is null, all text fields are cleared.
     *
     * @param card the card or null
     */
    private void showCardDetails(Card card) {
        if (card != null) {
            // Fill the labels with info from the card object.
            questionLabel.setText(card.getQuestion());
            articleLabel.setText(card.getArticle());
            categoryLabel.setText(card.getCategory());
            contextLabel.setText(card.getContext());
            keyWordsLabel.setText(card.getKeyWordsAsString());
            idLabel.setText(card.getId());
        } else {
            // Card is null, remove all the text.
            questionLabel.setText("");
            articleLabel.setText("");
            categoryLabel.setText("");
            contextLabel.setText("");
            keyWordsLabel.setText("");
            idLabel.setText("");
        }
    }

}