package ru.lazarev.lesson1.polymorphism.shape.impl;

import ru.lazarev.lesson1.polymorphism.shape.Drawable;
import ru.lazarev.lesson1.polymorphism.shape.Shape;

public class Square extends Shape implements Drawable {
  private int x;
  private int y;

  @Override
  public void draw() {
    System.out.println("Рисуем треугольник");
  }

  public Square(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public double getArea() {
    return x * y;
  }
}
