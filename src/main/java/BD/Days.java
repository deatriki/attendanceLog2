package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Days {
    public static PreparedStatement stat;
    private static ResultSet rs;
    public static void createDB()
    {


        String sql =  "CREATE TABLE if not exists days ('day' INTEGER, 'month' text);";

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

    public static void writeDB(int days, String month){
        String sql = "INSERT INTO days([day], [month]) values(?,?)";
        stat = null;
        for(int i = 1; i<days+1;i++) {
            try {
                stat = Facult.conn.prepareStatement(sql);
                stat.setString(1, Integer.toString(i));
                stat.setString(2, month);
                stat.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
