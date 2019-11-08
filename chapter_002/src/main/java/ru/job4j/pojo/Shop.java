package ru.job4j.pojo;

public class Shop {

	public Product[] delete(Product[] products, int index) {
		products[index] = null;
		for (int i = index; index < (products.length - 1); index++) {
			products[index] = products[index + 1];
		}
		return products;
	}

	public static void main(String[] args) {
		Product[] products = new Product[5];
		products[0] = new Product("Milk", 10);
		products[1] = new Product("Bread", 4);
		products[2] = new Product("Egg", 19);

		for (int i = 0; i < products.length; i++) {
			Product pr = products[i];
			if (pr != null) {
				System.out.println(pr.getName() + " - " + pr.getCount());
			} else {
				System.out.println("null");
			}
		}

		System.out.println();
		System.out.println("Проверка метода");
		Shop magnit = new Shop();
		magnit.delete(products, 0);
		for (int i = 0; i < products.length; i++) {
			Product product = products[i];
			if (product != null) {
				System.out.println(product.getName());
			} else {
				System.out.println("null");
			}
		}
	}
}