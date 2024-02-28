package Lesson3;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    public static void main(String[] args) throws SQLException {

        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet-test");

        var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
        var statement = conn.createStatement();
        statement.execute(sql);
        statement.close();

        var sql2 = "INSERT INTO users (username, phone) VALUES ('tommy', '123456789')";
        Statement statement2 = null;
        try {
            statement2 = conn.createStatement();
            statement2.executeUpdate(sql2);
        } finally {
            statement2.close();
        }

        var sql3 = "INSERT INTO users (username, phone) VALUES ('tom', '123')";
        try(Statement statement3 = conn.createStatement()) {
            statement3.executeUpdate(sql3);
        }

        String sql4 = "SELECT * FROM users";
        try (Statement statement4 = conn.createStatement()) {
            ResultSet resultSet = statement4.executeQuery(sql4);
            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id"));
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("phone"));
                System.out.println("next person --->");
                System.out.println("");

            }

            var sql5 = "INSERT INTO users (username, phone) VALUES (?, ?)";
            try (var preparedStatement = conn.prepareStatement(sql5)) {
                preparedStatement.setString(1, "Tommy");
                preparedStatement.setString(2, "33333333");
                preparedStatement.executeUpdate();
            }
        }
    }
}
