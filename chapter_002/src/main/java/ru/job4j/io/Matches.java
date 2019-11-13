package ru.job4j.io;

import java.util.Scanner;

public class Matches {

	public void startGame() {
		Scanner input = new Scanner(System.in);
		int player = 1;
		int matches = 11;
		boolean run = true;
		System.out.println("Starting game 11 matches");
		System.out.println("Po ocheredi igroki berut ot 1 do 3 spichek");
		while (run) {
			System.out.println("Na stole " + matches + " spichek");
			System.out.print("Igrok " + player + ", skolko spichek budete brat: ");
			int select = Integer.valueOf(input.nextLine());
			System.out.println();
			if (select >= 1 && select <= 3 && select <= matches) {
				matches -= select;
				if (matches <= 0) {
					System.out.println("Igrok " + player + " pobedil !!!");
					boolean play = Matches.playAgain();
					if (play) {
						matches = 11;
						player = 1;
					} else {
						System.out.println("Igra zavershena!");
						run = false;
					}
				} else {
					System.out.println("Na stole ostalos " + matches + " spichek");
					if (player == 1) {
						player++;
					} else {
						player--;
					}
				}
			} else {
				System.out.println("Vvedite chislo ot 1 do 3, no ne bolshe chem ostalos spichek!");
			}
		}
	}

	private static boolean playAgain() {
		Scanner input = new Scanner(System.in);
		boolean play = false;
		boolean ask = true;
		while (ask) {
			System.out.println("Hotite sygrat esche?");
			System.out.println("1. Da");
			System.out.println("2. Net");
			int playAgain = Integer.valueOf(input.nextLine());
			if (playAgain == 1) {
				play = true;
				ask = false;
			} else if (playAgain == 2) {
				ask = false;
			} else {
				System.out.println("Vvedite cifru 1 ili 2");
			}
		}
	return play;
	}

	public static void main(String[] args) {
		Matches game = new Matches();
		game.startGame();
	}
}
