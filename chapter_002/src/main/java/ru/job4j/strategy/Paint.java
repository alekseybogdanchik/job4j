package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        new Paint().draw(square);
        new Paint().draw(triangle);
    }
}
