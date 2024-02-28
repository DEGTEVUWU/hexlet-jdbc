package Lesson5;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws SQLException {
        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet-test");

        var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
        try (var statement = conn.createStatement()) {
            statement.execute(sql);
        }
        UserDAO userDAO = new UserDAO(conn);

        // Создание нового пользователя
        User user = new User("John Doe", "1234567890");

        try {
            // Сохранение пользователя в базу данных
            userDAO.save(user);
            System.out.println("User1 saved successfully");
        } catch (SQLException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }

        try {
            // Поиск пользователя по идентификатору
            Optional<User> foundUser = userDAO.find(1L);

            if (foundUser.isPresent()) {
                System.out.println("User found: " + foundUser.get().getName());
            } else {
                System.out.println("User1 not found");
            }
        } catch (SQLException e) {
            System.out.println("Error finding user: " + e.getMessage());
        }

        try {
            userDAO.delete(user);
            System.out.println("User1 delete successfully");
        } catch (SQLException e) {
            System.out.println("Error delete user: " + e.getMessage());
        }


        try {
            // Поиск пользователя по идентификатору
            Optional<User> foundUser = userDAO.find(1L);

            if (foundUser.isPresent()) {
                System.out.println("User found: " + foundUser.get().getName());
            } else {
                System.out.println("User1 not found");
            }
        } catch (SQLException e) {
            System.out.println("Error finding user: " + e.getMessage());
        }
    }
}
