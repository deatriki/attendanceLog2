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


        String sql =  "CREATE TABLE if not exists Attendance('group_id' INTEGER,'student_id' INTEGER, 'lesson_name' text, 'attend' TEXT)";

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

    public static List<String> outputDB(String group_id, String lesson_name){
        stat = null;
        rs = null;
        String sql = "SELECT [attend] from Attendance where [group_id]="+group_id+" and [lesson_name]+'"+lesson_name+"'";
        List<String> list = new ArrayList<>();
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
}
