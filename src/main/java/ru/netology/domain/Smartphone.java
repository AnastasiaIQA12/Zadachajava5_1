package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
  private String generator;

  public Smartphone() {
    super();
  }

  public Smartphone(int id, String name, int price, String generator) {
    super(id, name, price);
    this.generator = generator;
  }

  public String getGenerator() {
    return generator;
  }

  public void setGenerator(String generator) {
    this.generator = generator;
  }
}
