package ru.job4j.nasledovanie;

public class Dentist extends Doctor {

	public Dentist(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	/**
	 * Лечит зубы
	 */
	public void treatTeeth() {
	}
}
