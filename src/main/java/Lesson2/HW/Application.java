package Lesson2.HW;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet");

        var sql = "CREATE TABLE films"
                + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), release_year INT, duration INT)";

        var statement = conn.createStatement();
        statement.execute(sql);
        statement.close();

        // BEGIN (write your solution here)
        var sql2 = "INSERT INTO films(title, release_year, duration) VALUES ('Godfather', '1972', '175')";
        var statement2 = conn.createStatement();
        statement2.execute(sql2);
        statement2.close();

        var sql3 = "INSERT INTO films(title, release_year, duration) VALUES ('The Green Mile', '1999', '189')";
        var statement3 = conn.createStatement();
        statement3.execute(sql3);
        statement3.close();

        String sqlOutput = "SELECT * FROM films";
        var statement4 = conn.createStatement();
        var resultSet = statement4.executeQuery(sqlOutput);

        while (resultSet.next()) {
            System.out.print(resultSet.getString("title") + " ");
            System.out.print(resultSet.getString("release_year") + " ");
            System.out.print(resultSet.getString("duration") + " \n" );
        }
        statement4.close();
        // END

        conn.close();
    }
}
