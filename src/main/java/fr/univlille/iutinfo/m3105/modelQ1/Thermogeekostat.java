package fr.univlille.iutinfo.m3105.modelQ1;

import fr.univlille.iutinfo.m3105.utils.Subject;

public class Thermogeekostat extends Subject implements ITemperature {

	public double temperature;

	@Override
	public void setTemperature(double d) {
		temperature = d;
		this.notifyObservers(d);
	}

	@Override
	public Double getTemperature() {
		return temperature;
	}

	@Override
	public void incrementTemperature() {
		temperature++;
		this.notifyObservers(getTemperature());
	}

	@Override
	public void decrementTemperature() {
		temperature--;
		this.notifyObservers(getTemperature());
	}

}
