package org.example;


import java.sql.Date;

public class Review {
  public int id;
  public int userId;
  public int stars;
  public String description;
  public Date date;

  public Review(int id, int userId, int stars, String description, Date date) {
    this.id = id;
    this.userId = userId;
    this.stars = stars;
    this.description = description;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
