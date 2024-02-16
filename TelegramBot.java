import java.sql.*;

public class TelegramBot {
    private Connection connection;

    public TelegramBot() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveData(String data) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO data_table (data) VALUES (?)");
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String fetchData() {
        StringBuilder result = new StringBuilder();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM data_table");
            while (resultSet.next()) {
                result.append(resultSet.getString("data")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

            }
        }

