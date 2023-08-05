package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BrandBook {

    /** The list of brands or designers */
    private ArrayList<Brand> brands;

    /** The ListView containing the names of brands or designers */
    private ListView<String> listView;

    /**
     * Constructor for the BrandBook class.
     * Initializes an ArrayList of Brand objects, and a ListView for displaying the brands.
     */
    public BrandBook() {
        brands = new ArrayList<Brand>();
        listView = new ListView<String>();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage, and shows the main scene on the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("BrandBook");
        showMainScene(primaryStage);    
    }

    /**
     * Displayss the main scene of the application.
     * It sets up the layout, scene, and stage, then shows the stage.
     *
     * @param primaryStage The primary stage on which the scene is set and shown.
     */
    public void showMainScene(Stage primaryStage) {
        TextField inputField = new TextField();
        Button addButton = new Button("Add Brand / Designer");
        addButton.setOnAction(event -> addBrand(inputField));

        VBox layout = new VBox(10, inputField, addButton, listView);
        Scene mainScene = new Scene(layout, 300, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Adds a new brand to the list of brands.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Brand object with the input text and adds it to the brands list.
     * After adding the new brand, it sorts the brands list, refreshes the list view,
     * and finally clears the input field.
     *
     * @param inputField TextField object that contains the name of the new brand to be added.
     */
    public void addBrand(TextField inputField) {
        String newBrand = inputField.getText();

        if (!newBrand.isEmpty()) {
            brands.add(new Brand(newBrand));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the brands in the 'brands' list based on their names.
     */
    public void sortBrands() {
        

    }

    /**
     * Refreshes the list of brands displayed in the listView.
     * It first clears the listView, then iterates over the 'brands' list,
     * adding each brand's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Brand brand : brands) {
            listView.getItems().add(brand.getName());
        }
    }

}
