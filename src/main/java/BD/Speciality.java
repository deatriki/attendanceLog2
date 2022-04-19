package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Speciality {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB() throws ClassNotFoundException, SQLException
    {


        String sql =  "CREATE TABLE if not exists Speciality (courses_id INT, 'course' text, 'spec' text);";

        stat = null;
        try {
            stat = Courses.conn.prepareStatement(sql);
            stat.execute();
            System.out.println("Table created");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void writeDB(String courses_id, String spec) throws SQLException, ClassNotFoundException{
        System.out.println(courses_id + " " + spec);
        String sql = "INSERT INTO Speciality(courses_id, spec) VALUES(?, ?)";

        stat = null;
        try{
            stat = Courses.conn.prepareStatement(sql);
            stat.setString(1, courses_id);
            stat.setString(2, spec);
            stat.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
