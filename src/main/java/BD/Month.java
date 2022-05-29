package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Month {
    public static PreparedStatement stat;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists month ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'month' text);";

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

    public static ObservableList<String> outputDB() {
        ResultSet rs;
        String sql = "select * from month";
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



    public static void writeDB(String month){
        String sql = "INSERT INTO month([month]) VALUES(?)";
        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, month);
            stat.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
