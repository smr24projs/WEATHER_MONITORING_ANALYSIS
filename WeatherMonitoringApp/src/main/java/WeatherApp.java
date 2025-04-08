import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WeatherApp extends Application {
    private static final String DB_URL = "jdbc:sqlite:weather_history.db"; // SQLite database path
    private TableView<WeatherData> tableView = new TableView<>();

    public static void main(String[] args) {
        launch(args); // Start JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Define table columns
        TableColumn<WeatherData, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<WeatherData, Double> tempCol = new TableColumn<>("Temperature (°C)");
        tempCol.setCellValueFactory(new PropertyValueFactory<>("temperature"));

        TableColumn<WeatherData, Double> humidityCol = new TableColumn<>("Humidity (%)");
        humidityCol.setCellValueFactory(new PropertyValueFactory<>("humidity"));

        TableColumn<WeatherData, String> timestampCol = new TableColumn<>("Timestamp");
        timestampCol.setCellValueFactory(new PropertyValueFactory<>("timestamp"));

        // Add columns to table
        tableView.getColumns().addAll(cityCol, tempCol, humidityCol, timestampCol);

        // Load data from SQLite
        tableView.setItems(fetchWeatherData());

        // Set up scene
        primaryStage.setScene(new Scene(tableView, 600, 400));
        primaryStage.setTitle("Weather Monitoring System");
        primaryStage.show();
    }

    private ObservableList<WeatherData> fetchWeatherData() {
        ObservableList<WeatherData> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT city, temperature, humidity, timestamp FROM weather_data ORDER BY timestamp DESC LIMIT 50");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                data.add(new WeatherData(
                        rs.getString("city"),
                        rs.getDouble("temperature"),
                        rs.getDouble("humidity"),
                        rs.getString("timestamp")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
