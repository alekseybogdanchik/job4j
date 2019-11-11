package ru.job4j.pojo;

public class Library {
	public static void main(String[] args) {
		Book book1 = new Book("Java: The Complete Reference", 1488);
		Book book2 = new Book("HeadFirstJava", 717);
		Book book3 = new Book("Clean code", 123);
		Book book4 = new Book("How to get one million dollars in one day", 7);

		Book[] books = new Book[4];
		books[0] = book1;
		books[1] = book2;
		books[2] = book3;
		books[3] = book4;

		for (int i = 0; i < books.length; i++) {
			Book bkPrnt = books[i];
			System.out.println("In the book " + bkPrnt.getName() + " are " + bkPrnt.getPages() + " pages");
		}

		System.out.println("Change places of books indexed 0 and 3");
		Book bkTmp = books[0];
		books[0] = books[3];
		books[3] = bkTmp;
		for (int i = 0; i < books.length; i++) {
			Book bkPrnt = books[i];
			System.out.println("In the book " + bkPrnt.getName() + " are " + bkPrnt.getPages() + " pages");
		}

		System.out.println("Show books named \"Clean code\"");
		for (int i = 0; i < books.length; i++) {
			Book bkPrnt = books[i];
			if (bkPrnt.name.equals("Clean code")) {
				System.out.println("In the book " + bkPrnt.getName() + " are " + bkPrnt.getPages() + " pages");
			}
		}
	}
}
