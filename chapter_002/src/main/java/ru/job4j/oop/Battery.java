package ru.job4j.oop;

public class Battery {
	private int load;

	public Battery(int charge) {
		this.load = charge;
	}

	public void exchange(Battery another) {
		another.load = this.load + another.load;
		this.load = 0;
	}

	public static void main(String[] args) {
		Battery gp = new Battery(500);
		Battery drcell = new Battery(1000);
		System.out.println("GP charge: " + gp.load + ", Duracell charge: " + drcell.load);
		drcell.exchange(gp);
		System.out.println("GP charge: " + gp.load + ", Duracell charge: " + drcell.load);
	}
}
