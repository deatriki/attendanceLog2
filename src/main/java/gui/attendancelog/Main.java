package gui.attendancelog;

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

        stage.setTitle("пошел на хуй");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Facult.connectToDB();
        Facult.createDB();
        Lessons.createDB();
        Course.createDB();
        Students.createDB();
        Speciality.createDB();
        Attendance.createDB();

        launch();
    }
}