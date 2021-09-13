package fr.univlille.iutinfo.m3105.modelQ2;

import fr.univlille.iutinfo.m3105.modelQ1.ITemperature;
import fr.univlille.iutinfo.m3105.utils.ConnectableProperty;

public class Temperature extends ConnectableProperty implements ITemperature {
	
	protected Echelle temp;

	public Temperature(Echelle celsius) {
		this.temp = celsius;
	}

	public Echelle getEchelle() {
		return temp;
	}

	@Override
	public void setTemperature(double d) {
		
	}

	@Override
	public Double getTemperature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementTemperature() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementTemperature() {
		// TODO Auto-generated method stub
		
	}

}
