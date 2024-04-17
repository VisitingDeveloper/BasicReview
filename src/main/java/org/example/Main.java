package org.example;

import java.sql.*;

public class Main {

  private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

  public static void main(String[] args) {
    try (Connection conn = DriverManager.getConnection(DB_URL)) {
      createTables(conn);
      insertSampleData(conn);
      displayDatabase(conn);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void createTables(Connection conn) throws SQLException {
    Statement stmt = conn.createStatement();
    stmt.execute("CREATE TABLE IF NOT EXISTS User (id INT PRIMARY KEY, name VARCHAR(255));");
    stmt.execute("CREATE TABLE IF NOT EXISTS Review (id INT PRIMARY KEY, userId INT, stars INT, description TEXT, date DATE, FOREIGN KEY (userId) REFERENCES User(id));");
  }

  private static void insertSampleData(Connection conn) throws SQLException {
    PreparedStatement insertUser = conn.prepareStatement("INSERT INTO User (id, name) VALUES (?, ?)");
    insertUser.setInt(1, 1);
    insertUser.setString(2, "Test");
    insertUser.executeUpdate();

    PreparedStatement insertReview = conn.prepareStatement("INSERT INTO Review (id, userId, stars, description, date) VALUES (?, ?, ?, ?, ?)");
    insertReview.setInt(1, 1);
    insertReview.setInt(2, 1);
    insertReview.setInt(3, 4);
    insertReview.setString(4, "Sehr guter Service!");
    insertReview.setDate(5, new java.sql.Date(System.currentTimeMillis()));
    insertReview.executeUpdate();

    insertReview.setInt(1, 2);
    insertReview.setInt(2, 1);
    insertReview.setInt(3, 2);
    insertReview.setString(4, "Na ja!");
    insertReview.setDate(5, new java.sql.Date(System.currentTimeMillis()));
    insertReview.executeUpdate();
  }

  private static void displayDatabase(Connection conn) throws SQLException {
    ResultSet rsUsers = conn.createStatement().executeQuery("SELECT * FROM User");
    System.out.println("Users:");
    while (rsUsers.next()) {
      System.out.println("ID: " + rsUsers.getInt("id") + ", Name: " + rsUsers.getString("name"));
    }

    ResultSet rsReviews = conn.createStatement().executeQuery("SELECT * FROM Review");
    System.out.println("Reviews:");
    while (rsReviews.next()) {
      System.out.println("ID: " + rsReviews.getInt("id") + ", User ID: " + rsReviews.getInt("userId") +
              ", Stars: " + rsReviews.getInt("stars") + ", Description: " + rsReviews.getString("description") +
              ", Date: " + rsReviews.getDate("date"));
    }
  }
}

