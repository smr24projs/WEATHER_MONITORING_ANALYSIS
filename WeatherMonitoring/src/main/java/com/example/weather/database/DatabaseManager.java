package com.example.weather.database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:weather.db"; // SQLite database file

    // Create table if it doesn't exist
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS weather_data (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "city TEXT, " +
                     "temperature REAL, " +
                     "humidity INTEGER, " +
                     "description TEXT, " +
                     "wind_speed REAL, " +
                     "timestamp TEXT)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert weather data into the database
    public static void insertWeatherData(String city, double temperature, int humidity, 
                                         String description, double windSpeed, String timestamp) {
        String sql = "INSERT INTO weather_data (city, temperature, humidity, description, wind_speed, timestamp) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city);
            pstmt.setDouble(2, temperature);
            pstmt.setInt(3, humidity);
            pstmt.setString(4, description);
            pstmt.setDouble(5, windSpeed);
            pstmt.setString(6, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve the latest 10 records
    public static ResultSet fetchWeatherHistory() {
        String sql = "SELECT timestamp, temperature FROM weather_data ORDER BY timestamp DESC LIMIT 10";
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql); // Ensure this returns a ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
