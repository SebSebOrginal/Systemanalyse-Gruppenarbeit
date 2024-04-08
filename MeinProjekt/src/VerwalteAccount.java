import java.sql.*;
import java.util.Scanner;

public class VerwalteAccount {
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "IzgMz2++";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getData(Connection connection) {
        try {
            // Creating and executing query to retrieve data
            String query = "SELECT * FROM datenkunden";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Printing data from the result set
            while (resultSet.next()) {
                String vusername = resultSet.getString("username");
                String vpassword = resultSet.getString("password");
                int vage = resultSet.getInt("age");
                String vemail = resultSet.getString("email");
                System.out.println(vusername + " " + vpassword + " " + vage + " " + vemail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccount(Connection connection) {
        try {
            // Taking user input for new record
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username:");
            String newUsername = scanner.next();
            System.out.println("Enter password:");
            String newPassword = scanner.next();
            System.out.println("Enter age:");
            int newAge = scanner.nextInt();
            System.out.println("Enter email:");
            String newEmail = scanner.next();

            // Creating SQL query for inserting new record
            String insertQuery = "INSERT INTO datenkunden(username, password, age, email) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setInt(3, newAge);
            preparedStatement.setString(4, newEmail);

            // Executing the insert query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row has been inserted successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Connection connection) {
        try {
            // Taking user input for record deletion
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username to delete:");
            String deleteUsername = scanner.next();
            // Creating SQL query for deleting a record
            String deleteQuery = "DELETE FROM datenkunden WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, deleteUsername);
            // Executing the delete query
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The row has been deleted successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePassword(Connection connection) {
        try {
            //Update
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username for password update:");
            String usernameForUpdate = scanner.next();
            System.out.println("Enter new password:");
            String newPasswordUpdate = scanner.next();

            String updateQuery = "UPDATE datenkunden SET password=? WHERE username=?";
            PreparedStatement updatePW = connection.prepareStatement(updateQuery);
            updatePW.setString(1, newPasswordUpdate);
            updatePW.setString(2, usernameForUpdate);
            updatePW.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUsername(Connection connection) {
        try {
            Scanner scanner = new Scanner(System.in);
            String updateQuery = "UPDATE datenkunden SET username=? WHERE username=?";
            PreparedStatement updatePW1 = connection.prepareStatement(updateQuery);
            System.out.println("Enter username for username update:");
            String usernameForUpdate = scanner.next();
            System.out.println("Enter new username:");
            String newUsernameUpdate = scanner.next();

            updatePW1.setString(1, newUsernameUpdate);
            updatePW1.setString(2, usernameForUpdate);
            updatePW1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

