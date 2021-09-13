package fr.univlille.iutinfo.m3105.modelQ2;

import java.util.function.Function;

public enum Echelle {
	CELSIUS("Celsius", t -> t - 273.15, t -> t + 273.15), 
	FAHRENHEIT("Fahrenheit", t -> t * 1.8 - 459.67, t -> (t - 32) / 1.8 + 273.15),
	KELVIN("Kelvin", t -> t, t -> t)/* , RANKINE("Rankine"), NEWTON("Newton") */;

	protected String name;
	private Function<Double, Double> convertFromK;
	private Function<Double, Double> convertToK;

	private Echelle(String name, Function<Double, Double> convertFromK, Function<Double, Double> convertToK) {
		this.name = name;
		this.convertFromK = convertFromK;
		this.convertToK = convertToK;

	}

	public String getName() {
		return name;
	}

	public String getAbbrev() {
		/*
		 * if (name.equals(Echelle.RANKINE.getName())) return "Ra";
		 */
		return "" + name.charAt(0);
	}

	public double fromKelvin(double d) {
		return convertFromK.apply(d);
	}

	public double toKelvin(double d) {
		return convertToK.apply(d);
	}

}
