package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Courses {
    public static Connection conn;
    public static Statement stat;
    public static void connectToDB() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:TEST1.db");

        System.out.println("База Подключена!");

    }
    public static void createDB() throws ClassNotFoundException, SQLException
    {
        stat = conn.createStatement();


        stat.execute("CREATE TABLE if not exists Courses ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'course' text);");

        System.out.println("Таблица создана");
    }
    public static void writeDB(String course) throws SQLException, ClassNotFoundException{
        stat.execute("INSERT INTO Courses(course) VALUES("+course+")");
    }
}
