package gui;

import BD.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 520, 340);
        stage.setResizable(false);
        stage.setTitle("attendance log v2");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Facult.connectToDB();
        Facult.createDB();
        Subjects.createDB();
        Course.createDB();
        Students.createDB();
        Group.createDB();
//        Facult.clear("attendance");
        Attendance.createDB();
//        Facult.clear("days");
        Facult.clear("month");
        Month.createDB();
//        Days.createDB();
        Month.writeDB("January");
//        Days.writeDB(31,"January");
        Month.writeDB("February");
//        Days.writeDB(28,"February");
        Month.writeDB("March");
//        Days.writeDB(31,"March");
        Month.writeDB("April");
//        Days.writeDB(30,"April");
        Month.writeDB("May");
//        Days.writeDB(31,"May");
        Month.writeDB("June");
//        Days.writeDB(30,"June");
        Month.writeDB("July");
//        Days.writeDB(31,"July");
        Month.writeDB("August");
//        Days.writeDB(31,"August");
        Month.writeDB("September");
//        Days.writeDB(30,"September");
        Month.writeDB("October");
//        Days.writeDB(31,"October");
        Month.writeDB("November");
//        Days.writeDB(30,"November");
        Month.writeDB("December");
//        Days.writeDB(31,"December");
        launch();
    }
}