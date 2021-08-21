package ru.lazarev.lesson1.polymorphism.shape.impl;


import ru.lazarev.lesson1.polymorphism.shape.Drawable;
import ru.lazarev.lesson1.polymorphism.shape.Shape;

public class Triangle extends Shape implements Drawable {
  private int a;
  private int b;
  private int c;

  @Override
  public void draw() {
    System.out.println("Рисуем треугольник");
  }

  public Triangle(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double getArea() {
    double p = (a + b + c) >> 1;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }



}
