package fr.univlille.iutinfo.m3105.utils;


public class ObservableProperty extends Subject {

	protected Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object val) {
		value = val;
		notifyObservers(val);
	}
}
