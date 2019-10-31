package ru.job4j.oop;

public class Jukebox {

	public void music(int position) {
		if (position == 1) {
			System.out.println("Пусть бегут неуклюже");
		} else if (position == 2) {
			System.out.println("Спокойной ночи малыши");
		} else {
			System.out.println("Песня не найдена");
		}
	}

	public static void main(String[] args) {
		Jukebox iplod = new Jukebox();
		iplod.music(0);
		iplod.music(1);
		iplod.music(2);
	}
}
