package BD;

import java.sql.*;

public class Courses {
    public static Connection conn;
    public static PreparedStatement stat;
    public static void connectToDB() throws ClassNotFoundException, SQLException
    {
        conn = null;
        try {


            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TEST1.db");

            System.out.println("Connected");
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void createDB() throws ClassNotFoundException, SQLException
    {


        String sql =  "CREATE TABLE if not exists Courses ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'course' text);";

        stat = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.execute();
            System.out.println("Tablet created");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void writeDB(String course) throws SQLException, ClassNotFoundException{
        System.out.println(course);
        String sql = "INSERT INTO Courses(course) VALUES(?)";

        stat = null;
        try{
            stat = conn.prepareStatement(sql);
            stat.setString(1, course);
            stat.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
