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


        String sql =  "CREATE TABLE if not exists subject('group_id' INT, 'subject' text);";

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

    public static void writeDB(String group_id, String lesson) throws SQLException, ClassNotFoundException{
        System.out.println(group_id + " " + lesson);
        String sql = "INSERT INTO subject('group_id', 'subject') VALUES(?, ?)";

        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, group_id);
            stat.setString(2, lesson);
            stat.execute();
            System.out.println("добавленно");
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }



    public static ObservableList<String> outputDB(String group_id) {
        String sql = "select * from subject where [group_id]="+group_id;
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

    public static void updateDBWhere(String group_id, String subject, String set){
        String sql = "UPDATE subject set [subject]='"+set+"' WHERE [group_id]="+group_id+" and [subject]='"+subject+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
