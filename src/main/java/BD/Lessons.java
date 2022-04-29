package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lessons {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB() throws ClassNotFoundException, SQLException
    {


        String sql =  "CREATE TABLE if not exists Lesson('group_id' INT, 'lesson' text);";

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
        String sql = "INSERT INTO Lesson('group_id', 'lesson') VALUES(?, ?)";

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


        sql = "select * from Lesson where 'group_id'="+group_id+"";

        stat = null;
        List<String> list = new ArrayList<>();

        String o = "";

        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
//                list.add(rs.getString(1));
//                list.add(rs.getString(2));
                list.add(rs.getString(2));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(1));
            }

        }
        catch (SQLException e){e.printStackTrace();}
        for(String i : list) {
            o += i + "\n";
        }
        System.out.println(o);


    }



    public static ObservableList<String> outputDB(String group_id) {
        String sql = "select * from Lesson where group_id="+group_id;
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
}
