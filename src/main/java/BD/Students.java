package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Students {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists Students('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'group_id' INTEGER, 'name' text, 'last_name' text);";

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
    public static List<String> outputBD(String group_id){
        String sql = "select [name], [last_name] from Students where [group_id]="+group_id;
        stat = null;
        rs = null;
        List<String> list = new ArrayList<>();
        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()){
                list.add(rs.getString(1) + " " + rs.getString(2));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return list;
    }



}
