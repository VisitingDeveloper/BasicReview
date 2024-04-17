package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
  private int id;
  private String name;
  private List<Review> reviews;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
    this.reviews = new ArrayList<Review>();
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Review> getReviews() {
    return this.reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
