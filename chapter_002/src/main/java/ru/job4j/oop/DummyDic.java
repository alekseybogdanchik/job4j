package ru.job4j.oop;

public class DummyDic {
	public String engToRus(String eng) {
		String result = "Неизвестное слово " + eng;
		return result;
	}

	public static void main(String[] args) {
		DummyDic moidodyr = new DummyDic();
		String word = "Karabaras";
		String search = moidodyr.engToRus(word);
		System.out.println(search);
	}
}
