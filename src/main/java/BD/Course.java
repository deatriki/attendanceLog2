package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB() throws ClassNotFoundException, SQLException
    {


        String sql =  "CREATE TABLE if not exists Course ('course' INT);";

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
    public static void writeDB(String course) throws SQLException, ClassNotFoundException{
        System.out.println(course);
        String sql = "INSERT INTO Course(course) VALUES(?)";

        stat = null;
        try{
            stat = Facult.conn.prepareStatement(sql);
            stat.setString(1, course);
            stat.execute();
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
            stat = Facult.conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        System.out.println(list);
        return list;

    }

}
