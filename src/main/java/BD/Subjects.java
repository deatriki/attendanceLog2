package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Subjects {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists subject('group' text, 'subject' text);";

        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.execute();
            System.out.println("Table created");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void writeDB(String group, String lesson) throws SQLException, ClassNotFoundException{
        System.out.println(group + " " + lesson);
        String sql = "INSERT INTO subject('group', 'subject') VALUES(?, ?)";

        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, group);
            stat.setString(2, lesson);
            stat.execute();
            System.out.println("добавленно");
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }



    public static ObservableList<String> outputDB(String group) {
        String sql = "select * from subject where [group]='"+group+"'";
        stat = null;
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(2));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        System.out.println(list);
        return list;

    }

    public static void updateDBWhere(String group, String subject, String set){
        String sql = "UPDATE subject set [subject]='"+set+"' WHERE [group]='"+group+"' and [subject]='"+subject+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    public static void clearWhere(String group){
        String sql = "DELETE FROM subject WHERE [group]='"+group+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e) {e.printStackTrace();}
    }
}
