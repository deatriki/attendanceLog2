package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Speciality{
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB() throws ClassNotFoundException, SQLException
    {


        String sql =  "CREATE TABLE if not exists Speciality ('facult_id' INT, course_id INT, 'group' text);";

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
    public static void writeDB(String facult_id,String course_id, String group) throws SQLException, ClassNotFoundException{
        System.out.println(facult_id + " " + course_id +  " "  + group);
        String sql = "INSERT INTO Speciality(facult_id, course_id, 'group') VALUES(?, ?, ?)";

        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, facult_id);
            stat.setString(2, course_id);
            stat.setString(3, group);
            stat.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static ObservableList<String> outputDB(String name, String facult_id, String course_id) {
        String sql = "select * from " + name + " where facult_id= "+facult_id+" and course_id="+ course_id;
        stat = null;
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
//                list.add(rs.getString(1));
//                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        System.out.println(list);
        return list;

    }

    public static void clearBDWhere(String facult_id, String course_id){
        String sql = "delete from Speciality where facult_id=" + facult_id +" and course_id="+ course_id;
        try {
            stat = Facult.conn.prepareStatement(sql);
            stat.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
