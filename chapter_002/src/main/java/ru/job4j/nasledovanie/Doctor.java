package ru.job4j.nasledovanie;

public class Doctor extends Profession {

	public Doctor(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	/**
	 * Носит белый халат
	 */
	public String clothes;

	/**
	 * Проводит осмотр
	 */
	public void doExam() {
	}

	/**
	 * Ставит диагноз
	 */
	public void diagnose() {
	}
}
