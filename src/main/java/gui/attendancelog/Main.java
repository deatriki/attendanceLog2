package gui.attendancelog;

import BD.Facult;
import BD.Lessons;
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

        Scene scene = new Scene(fxmlLoader.load(), 700, 400);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Facult.connectToDB();
        Facult.createDB();
        Lessons.createDB();


        launch();
    }
}