import java.sql.*;
public class Main {
    public static void main(String[] args) {
        /*AccountVerwalten accountVerwalten = new AccountVerwalten();
        accountVerwalten.accountErstellen();
        accountVerwalten.login();*/
        String connectionString = "postgresql://sebastian:<ENTER-SQL-USER-PASSWORD>@projektsysa-14269.8nj.gcp-europe-west1.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full";
        String username = "sebastian";
        String password = "zRHxxQhCrC7Cm1AHzC9O5w";
        /*try{
            Connection connection = DriverManager.getConnection(connectionString, username, password);
        }catch(SQLException e){
            System.out.println("Connection failed");

        }*/
        String url = "jdbc:postgresql://projektsysa-14269.8nj.gcp-europe-west1.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full&password=zenrDiV9Je4z1pL6hgcmIw&user=sebastian";

        try{
            Connection connection1 = DriverManager.getConnection(url);
        }catch(Exception e){
            System.out.println("Connection failed");

        }
    }
}

