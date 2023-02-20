import data.PostgreSQL;
import java.sql.*;
public class Login {

    private  PostgreSQL db;

    public void log(){
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            // Prompt the user to enter their username and password
            String usernameInput = System.console().readLine("Enter your username: ");
            char[] passwordInput = System.console().readPassword("Enter your password: ");

            // Set the parameters of the prepared statement
            stmt.setString(1, usernameInput);
            stmt.setString(2, new String(passwordInput));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful");
            } else {
                System.out.println("Incorrect username or password");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}






