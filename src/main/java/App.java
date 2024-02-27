import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {

        var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet-test");

        var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
        var statement = conn.createStatement();
        statement.execute(sql);
        statement.close();

        var sql2 = "INSERT INTO users (username, phone) VALUES ('tommy', '123456789')";
        var statement2 = conn.createStatement();
        statement2.execute(sql2);
        statement2.close();

        var sql2_1 = "INSERT INTO users (username, phone) VALUES ('tommy2', '12345678927777')";
        var statement2_1 = conn.createStatement();
        statement2_1.execute(sql2_1);
        statement2_1.close();

        String sql3 = "SELECT * FROM users";
        Statement statement3 = conn.createStatement();

        ResultSet resultSet = statement3.executeQuery(sql3);

        while (resultSet.next()) {
            System.out.println(resultSet.getLong("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("phone"));
            System.out.println("next person --->");
            System.out.println("");


        }
        statement3.close();
        conn.close();
    }
}
