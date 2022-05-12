package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonSettings;

    @FXML
    private ComboBox<String> comboBoxCourse;

    public ComboBox<String> getComboBoxCourse() {
        return comboBoxCourse;
    }

    public void setComboBoxCourse(ComboBox<String> comboBoxCourse) {
        this.comboBoxCourse = comboBoxCourse;
    }

    public ComboBox<String> getComboBoxFacult() {
        return comboBoxFacult;
    }

    public void setComboBoxFacult(ComboBox<String> comboBoxFacult) {
        this.comboBoxFacult = comboBoxFacult;
    }

    @FXML
    private ComboBox<String> comboBoxFacult;

    @FXML
    void initialize() {
        comboBoxFacult.getItems().addAll(Facult.outputDB("facult"));
        comboBoxCourse.getItems().addAll(Course.outputDB("course"));

        buttonNext.setOnAction(actionEvent -> {
            if(comboBoxFacult.getValue()!= null && comboBoxCourse.getValue() != null){
                ChosenId.setCourse_id(comboBoxCourse.getValue());
                ChosenId.setFacult_id(Facult.indexDB("facult", comboBoxFacult.getValue()));

                Stage stage = (Stage) buttonNext.getScene().getWindow();
                try{

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("groupWindow.fxml"));

                    Scene secondScene = new Scene(fxmlLoader.load(), 260, 200);

                    stage.setTitle("выберите группу");
                    stage.setScene(secondScene);


                    stage.show();


                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        buttonSettings.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonSettings.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsFacultCourses.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("настройки факультета и курсов");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

    }


}






//package gui.attendancelog;
//
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//import BD.*;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//import javafx.stage.WindowEvent;
//
//import static javafx.fxml.FXMLLoader.load;
//
//
//public class MainWindowController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button ButtonShowTable;
//
//    @FXML
//    private Button buttonEdLes;
//
//    @FXML
//    private ComboBox<String> comboBox;
//
//    @FXML
//    private ComboBox<String> comboBoxCourse;
//
//    @FXML
//    private ComboBox<String> comboBoxGroup;
//
//    @FXML
//    private ComboBox<String> comboBoxLesson;
//
//    @FXML
//    void initialize() {
//        comboBox.getItems().addAll(Facult.outputDB("Facult"));
//        comboBoxCourse.getItems().addAll(Course.outputDB("Course"));
//        comboBox.setOnAction(actionEvent -> {
//            ObservableList<String> i = FXCollections.observableArrayList();
//            comboBoxGroup.setItems(i);
//
//            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBox.getValue()), comboBoxCourse.getValue()));
//        } );
//        comboBoxCourse.setOnAction(actionEvent -> {
//            ObservableList<String> i = FXCollections.observableArrayList();
//            comboBoxGroup.setItems(i);
//
//            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBox.getValue()), comboBoxCourse.getValue()));
//
//        });
//        comboBoxGroup.setOnAction(actionEvent -> {
//            ObservableList<String> i = FXCollections.observableArrayList();
//            comboBoxLesson.setItems(i);
//            String[] groupAndId = new String[2];
//            comboBoxLesson.getItems().addAll(Lessons.outputDB(Speciality.outputID(comboBoxGroup.getValue().split("-"))));
//
//        });
//        buttonEdLes.setOnAction(actionEvent -> {
//            try{
//                Parent edLesWin = FXMLLoader.load(getClass().getResource("setDBLes.fxml"));
//                Stage edLesStage = new Stage();
//                edLesStage.setTitle("редактор предметов");
//                edLesStage.setScene(new Scene(edLesWin, 700, 400));
//                edLesStage.show();
//            }
//            catch (Exception e){e.printStackTrace();}
//        });
//
//        ButtonShowTable.setOnAction(actionEvent -> {
//
//            if(comboBoxLesson.getValue() != null){
//
//
//                List<String> list = Students.outputBD(Speciality.outputID(comboBoxGroup.getValue().split("-")));
//                List<String> list2 = Attendance.outputDB(Speciality.outputID(comboBoxGroup.getValue().split("-")), comboBoxLesson.getValue());
//                String temp1;
//                String temp2;
//                for(int i=0;i < list2.size(); i++){
//                    temp1 = list.get(i);
//                    temp2 = list2.get(i);
//                    AttendanceController.attendanceDate.add(new EndTable(temp1, temp2));
//                }
//                try{
//                    Parent secondWindow = FXMLLoader.load(getClass().getResource("Attendance.fxml"));
//                    Stage secondStage = new Stage();
//                    secondStage.setOnShowing(new EventHandler<WindowEvent>() {
//                        @Override
//                        public void handle(WindowEvent windowEvent) {
//
//                        }
//                    });
//                    secondStage.setTitle("BD");
//                    secondStage.setScene(new Scene(secondWindow, 270, 400));
//                    secondStage.show();
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//
////        button1.setOnAction(actionEvent -> {
////            try{
////                Parent secondWindow = FXMLLoader.load(getClass().getResource("setDBLes.fxml"));
////                Stage secondStage = new Stage();
////                secondStage.setTitle("BD");
////                secondStage.setScene(new Scene(secondWindow, 700, 400));
////                secondStage.show();
////            }
////            catch (Exception e){
////                e.printStackTrace();
////            }
////        });
//
//
//    }
//
//
//
//}