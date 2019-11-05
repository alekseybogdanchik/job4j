package ru.job4j.nasledovanie;

public class Engineer extends Profession {

	public Engineer(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	/**
	 * работет с/над проектами
	 */
	public void projectControl() {
	}

	public void workOnPC() {
	}
}
