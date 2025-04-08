import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:weather_history.db"; // Your SQLite DB file

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to SQLite database successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
