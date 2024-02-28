package Lesson4.HW;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        List<String> products = List.of("computer", "mobile phone", "tv", "kettle");


        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet")) {

            var sql = "CREATE TABLE products "
                    + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255))";

            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }

            // BEGIN (write your solution here)
            var sql2 = "INSERT INTO products (name) VALUES (?)";
                try (var preparedStatement = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {
                    for (var product : products) {
                        preparedStatement.setString(1, product);
                        preparedStatement.executeUpdate();
                    }
                }
                // END

                var sql3 = "SELECT * FROM products ORDER BY name";

                try (var statement3 = conn.createStatement()) {
                    var resultSet = statement3.executeQuery(sql3);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name"));
                    }
                }
        }
    }
}

