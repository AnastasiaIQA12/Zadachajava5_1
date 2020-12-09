package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
  private String generator;

  public Smartphone() {
    super();
  }

  @Override
  public boolean matches(String search) {
    if (super.matches(search)){
      return true;
    }
    if (this.getGenerator().equalsIgnoreCase(search)) {
      return true;
    }
    return false;
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
