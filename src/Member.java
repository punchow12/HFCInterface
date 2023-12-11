import java.sql.*;

public class Member {

    private final String url = "jdbc:postgresql://localhost/HealthFitnessClub";
    private final String user = "postgres";
    private final String password = "password123";

    private Connection connection;

    public Member() {
        connection = this.connect();
    }

    public Connection connect() {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void getSchedule(){}

    void printTable() {
        try {
            // Example SELECT query
            String Query = "SELECT * FROM Member";
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int column1 = resultSet.getInt("member_id");
                String column2 = resultSet.getString("achievements");
                String column3 = resultSet.getString("health_records");
                int column4 = resultSet.getInt("loyalty_points");
                // Process the data as needed
                System.out.println("Column1: " + column1 + ", Column2: " + column2+ ", Column3: " + column3+ ", Column4: " + column4);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CheckMember(int value){
        //return value == connection.createStatement();
    }

    public static void main(String[] args) {
        Member Paul = new Member();
        Paul.printTable();
    }



}