package ru.lazarev.lesson1.polymorphism;


import ru.lazarev.lesson1.polymorphism.shape.Shape;
import ru.lazarev.lesson1.polymorphism.shape.impl.Circle;
import ru.lazarev.lesson1.polymorphism.shape.Drawable;
import ru.lazarev.lesson1.polymorphism.shape.impl.Square;
import ru.lazarev.lesson1.polymorphism.shape.impl.Triangle;

public class Main {
  public static void main(String[] args) {
    Circle circle = new Circle(10);
    Triangle triangle = new Triangle(15, 20, 30);
    Square square = new Square(1, 2);

    Drawable[] shapesDraw = new Drawable[]{circle, triangle, square};

    drawAll(shapesDraw);

    Shape[] shapesArea = new Shape[]{circle, triangle, square};
    getAreaAll( shapesArea);
  }

  private static void getAreaAll(Shape[] shapes) {
    for (Shape shape : shapes) {
      System.out.println("shape.getArea() = " + shape.getArea());
    }
  }

  public static void drawAll(Drawable[] shapes) {
    for (Drawable shape : shapes) {
      shape.draw();
    }
  }
}
