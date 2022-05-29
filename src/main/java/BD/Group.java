package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Group{
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists groups ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, [facult_id] INT, [course_id] INT, [group] text, [group_num] INT);";

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

    public static void updateDBWhere(String facult_id, String course_id, String group, String group_id, String set){
        String setId = course_id;
        int count = 1;
        String sql2 = "SELECT [group] FROM groups WHERE [group]='"+set+"' and [facult_id]="+facult_id+" and [course_id]="+course_id;
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql2);
            rs = stat.executeQuery();
            while (rs.next()){
                count++;
            }
        }
        catch (SQLException e){e.printStackTrace();}
        setId += count;
        String sql = "UPDATE groups set [group]='"+set+"', [group_num]="+setId+" WHERE [group]='"+group+"' and [facult_id]="+facult_id+" and [course_id]="+course_id+" and [group_num]=" + group_id;
        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    public static void writeDB(String facult_id,String course_id, String group){
        System.out.println(facult_id + " " + course_id +  " "  + group);
        String sql = "INSERT INTO groups(facult_id, course_id, 'group', 'group_num') VALUES(?, ?, ?, ?)";
        String group_id = course_id;
        int count = 1;
        String sql2 = "SELECT [group] FROM groups WHERE [group]='"+group+"' and [facult_id]="+facult_id+" and [course_id]="+course_id;
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql2);
            rs = stat.executeQuery();
            while (rs.next()){
                count++;
            }
        }
        catch (SQLException e){e.printStackTrace();}
        group_id += count;
        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, facult_id);
            stat.setString(2, course_id);
            stat.setString(3, group);
            stat.setString(4, group_id);
            stat.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static ObservableList<String> outputDB(String name, String facult_id, String course_id) {
        String sql = "select * from " + name + " where [facult_id]="+facult_id+" and [course_id]="+ course_id + " order by [group], [group_num]";
        stat = null;
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
//                list.add(rs.getString(1));
//                list.add(rs.getString(2));
                list.add(rs.getString(4) + "-" + rs.getString(5));


            }
        }
        catch (SQLException e){e.printStackTrace();}
        System.out.println(list);
        return list;

    }

    public static void clearWhere(String facult_id, String course_id){
        String sql = "DELETE FROM groups WHERE [facult_id]="+facult_id+" and [course_id]="+course_id;
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e) {e.printStackTrace();}
    }


}
