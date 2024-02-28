package Lesson3.HW;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {
    public static void main(String[] args) throws SQLException {
        try(var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet-test")) {

            var sql = "CREATE TABLE cars (id BIGINT PRIMARY KEY AUTO_INCREMENT,"
                + "brand VARCHAR(255), model VARCHAR(255))";
            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }

            var sql2 = "INSERT INTO cars (brand, model) VALUES ('kia', 'sorento'), ('bmw', 'x5'), ('audi', 'q7')";
            try (var statement2 = conn.createStatement()) {
                statement2.executeUpdate(sql2);
            }

            var sql3 = "SELECT * FROM cars ORDER BY brand ASC";
            try (var statement3 = conn.createStatement()) {
                var resultSet = statement3.executeQuery(sql3);
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("brand") + " ");
                    System.out.print(resultSet.getString("model") + "\n");

                }
            }
        }
    }
}
