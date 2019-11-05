package ru.job4j.nasledovanie;

public class Programmer extends Engineer {

	public Programmer(String name, String surname, String education, int birthday) {
		super(name, surname, education, birthday);
	}

	public boolean hasBeard;
	public String codeQuality;

	public void writeCode() {
		if (hasBeard) {
			codeQuality = "is better (but i'm not sure)";
		} else {
			codeQuality = "good";
		}
	}

	public void development() {

	}
}
