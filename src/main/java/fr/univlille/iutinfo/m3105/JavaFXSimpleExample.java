package fr.univlille.iutinfo.m3105;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXSimpleExample extends Application {

	protected Stage stage = new Stage();
	protected Number newValue;

	@Override
	public void start(Stage stage) {
		HBox root = new HBox();
		VBox secondaryRoot = new VBox();
		Label celsius = new Label("Température en Célsius");
		TextField value = new TextField("0");
		Button plus = new Button(" + ");
		Button moins = new Button(" - ");

		Slider slider = new Slider();
		slider.setMin(-10);
		slider.setMax(40);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setOrientation(Orientation.VERTICAL);

		root.getChildren().addAll(moins, value, plus);
		secondaryRoot.getChildren().addAll(celsius, root);
		root.getChildren().addAll(slider);

		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				value.setText("" + newValue);
				slider.setValue((double) newValue);
			}
		});

		plus.addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				newValue = Double.parseDouble(value.getText()) + 1;
				value.setText("" + newValue);
				slider.setValue((double) newValue);
			}
		});

		moins.addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				newValue = Double.parseDouble(value.getText()) - 1;
				value.setText("" + newValue);
				slider.setValue((double) newValue);

			}
		});

		Scene scene = new Scene(secondaryRoot, 640, 480);
		stage.setScene(scene);
		stage.setTitle("Thermogeekostat");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
