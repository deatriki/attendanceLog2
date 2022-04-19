package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class Courses {
    public static Connection conn;
    public static PreparedStatement stat;
    private static ResultSet rs;
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


        String sql =  "CREATE TABLE if not exists Courses ('courses_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'course' text);";

        stat = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.execute();
            System.out.println("Table created");
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

    public static void clear(String name) {
        String sql = "DROP TABLE " + name;
        stat = null;
        try{
            stat = conn.prepareStatement(sql);
            stat.executeUpdate();
            System.out.println("cleared");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    static ObservableList<String> list;
    public static ObservableList<String> outputDB(String name) {
        String sql = "select * from " + name;
        stat = null;
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(2));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        System.out.println(list);
        return list;

    }
    public static int indexDB(String name, String word){
        int i = -1;
        String sql = "select * from " + name;
        stat = null;
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                if(rs.getString(2).equals(word)){
                    i = rs.getInt(1);
                }
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return i;
    }


}
