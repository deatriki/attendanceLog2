package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Attendance {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists attendance('student' text," +
                "'lesson_name' text, " +
                "'attend' VARCHAR(2) NOT NULL, " +
                "'month' text, " +
                "'day' INTEGER, " +
                "'group' text)";

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

    public static ObservableList<String> outputDB(String group, String lesson_name, int day, String month){
        stat = null;
        rs = null;
        String sql = "SELECT [attend] from attendance where [group]='"+group+"' and [lesson_name]='"+lesson_name+"' and [day]='"+day+"' " +
                "and [month]='"+ month+"'";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String sql2 = "SELECT [attend] FROM attendance where [group]='"+group+"' and [lesson_name]";
            stat = Facult.conn.prepareStatement(sql2);
            rs = stat.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                list.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return list;
    }

    public static void writeDB(String student, String group, String lesson_name, String month, String day){
        stat = null;
        String sql = "INSERT INTO attendance([student], [lesson_name], [attend], [month], [day], [group]) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, student);
            stat.setString(2, lesson_name);
            stat.setString(3, "_");
            stat.setString(4, month);
            stat.setString(5, day);
            stat.setString(6, group);
            stat.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    public static ObservableList<String> outputDB(String group, String subject){
        stat = null;
        rs = null;
        String sql = "SELECT [student] FROM attendance WHERE [group]='"+ group+"' and [month]='January' and [day]=1 and [lesson_name]='"+subject+"'";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                list.add(rs.getString(1));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return list;
    }

    public static void clearWhere(String group){
        String sql = "DELETE FROM attendance WHERE [group]='"+group+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e) {e.printStackTrace();}
    }

    public static void updateDBWhere(String student,String lesson_name, String group, String set){
        String sql = "UPDATE attendance set [student]='"+set+"' WHERE [group]='"+group+"' and [student]='"+student+"' and [lesson_name]='"+lesson_name+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    public static void updateDBWhere(String student,String lesson_name, String group, String set, String day, String month){
        String sql = "UPDATE attendance set [attend]='"+set+"' WHERE [group]='"+group+"' and [student]='"+student+"'" +
                " and [lesson_name]='"+lesson_name+"' and [day]="+day+" and [month]='"+month+"'";
        stat = null;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
