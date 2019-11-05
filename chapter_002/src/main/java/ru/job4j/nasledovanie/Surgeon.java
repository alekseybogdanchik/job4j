package ru.job4j.nasledovanie;

public class Surgeon extends Doctor {

	public Surgeon(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	MedKit medKit = new MedKit();

	/**
	 * Делает хирургические операции
	 */
	public void surgery() {
	}

	/**
	 * Накладывает гипс
	 */
	public void cast() {
	}
}
