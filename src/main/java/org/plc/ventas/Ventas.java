package org.plc.ventas;

import org.plc.ventas.model.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Ventas extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        ListView<Person> list = new ListView<Person>();
        ObservableList<Person> items = getCredits();
        list.setItems(items);

        list.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {

            @Override
            public ListCell<Person> call(ListView<Person> param) {
                final Label leadLbl = new Label();
                final Tooltip tooltip = new Tooltip();
                final ListCell<Person> cell = new ListCell<Person>() {
                    @Override
                    public void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            leadLbl.setText(item.getNombre());
                            setText(item.getNombre() + " " + item.getDeuda());
                            tooltip.setText(item.getNombre());
                            setTooltip(tooltip);
                        }
                    }
                }; // ListCell
                return cell;
            }
        }); // setCellFactory

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                openPersonDetail();
            }

        });

        root.setCenter(list);
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());

        stage.getIcons().add(new Image(Ventas.class.getResourceAsStream("/icon.png")));

        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Person> getCredits() {
        Person p = new Person();
        p.setNombre("Juan");
        p.setDeuda(150);
        return FXCollections.observableArrayList(
                p);
    }

    private void openPersonDetail() {
        Dialog personDetail = new Alert(Alert.AlertType.INFORMATION);
        personDetail.showAndWait();
        
    }
}
