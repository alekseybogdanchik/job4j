package ru.job4j.nasledovanie;

public class Tiger extends Predator {

	public Tiger(String name) {
		super(name);
	}

	public static void main(String[] args) {
		Tiger tiger = new Tiger("Kusachiy");
	}
}
