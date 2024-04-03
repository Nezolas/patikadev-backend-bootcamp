import java.sql.*;

public class DBConnect {
    private Connection connection = null;
    public static String DB_URL = "jdbc:postgresql://localhost:5432/jdbc";
    public static String DB_USERNAME = "postgres";
    public static String DB_PASSWORD = "0000";

    public static  void main(String[] args){
        Connection connect = null;

        String sql = "SELECT * FROM employees";
        try{
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement st = connect.createStatement();


            ResultSet data = st.executeQuery(sql);
            while (data.next()){
                System.out.println("---------------------------------------------------------------");
                System.out.println("ID: " + data.getInt("id") );
                System.out.println("Name: " + data.getString("name") );
                System.out.println("Position: " + data.getString("position") );
                System.out.println("Salary: " + data.getString("salary") );

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
