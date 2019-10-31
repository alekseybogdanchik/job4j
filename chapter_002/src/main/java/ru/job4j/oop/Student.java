package ru.job4j.oop;

public class Student {
	public void music() {
		System.out.println("Tram taram tararam");
	}

	public void song(String lyrics) {
		System.out.println("I can sing a song: " + lyrics);
	}

	public static void main(String[] args) {
		Student petya = new Student();
		String song = "I believe i can fly";
		petya.song(song);
		petya.music();
	}
}
