package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Facult {
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
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists facult ('facult_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'facult' text);";

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
    public static void writeDB(String facult) throws SQLException, ClassNotFoundException{
        System.out.println(facult);
        String sql = "INSERT INTO facult (facult) VALUES(?)";

        stat = null;
        try{
            stat = conn.prepareStatement(sql);
            stat.setString(1, facult);
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
    public static String indexDB(String name, String word){
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
        return Integer.toString(i);
    }

    public static void updateBDWhere(String facult, String set){
        String sql = "update facult set [facult]='"+ set + "' where [facult]='" + facult +"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }


}
