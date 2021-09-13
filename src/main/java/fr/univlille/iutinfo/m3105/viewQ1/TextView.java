package fr.univlille.iutinfo.m3105.viewQ1;

import fr.univlille.iutinfo.m3105.modelQ1.Thermogeekostat;
import fr.univlille.iutinfo.m3105.utils.Observer;
import fr.univlille.iutinfo.m3105.utils.Subject;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextView extends Stage implements ITemperatureView, Observer {

	protected Thermogeekostat model;
	protected Number newValue;
	protected TextField value = new TextField("0");

	public TextView(Thermogeekostat model) {
		this.model = model;
		this.model.attach(this);
		HBox root = new HBox();
		VBox secondaryRoot = new VBox();
		Button plus = new Button(" + ");
		Button moins = new Button(" - ");
		root.getChildren().addAll(moins, secondaryRoot, plus);
		secondaryRoot.getChildren().addAll(value);

		plus.setOnAction(e -> {
			model.incrementTemperature();
			value.setText("" + model.getTemperature());
		});

		moins.setOnAction(e -> {
			model.decrementTemperature();
			value.setText("" + model.getTemperature());
		});

		Scene scene1 = new Scene(root, 250, 250);
		this.setScene(scene1);
		this.setTitle("Celsius");
		this.show();
	}

	@Override
	public double getDisplayedValue() {
		return model.getTemperature();
	}

	@Override
	public void incrementAction() {
		model.incrementTemperature();

	}

	@Override
	public void decrementAction() {
		model.decrementTemperature();

	}

	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Subject subj, Object data) {
		this.value.setText("" + data);	
	}

}
