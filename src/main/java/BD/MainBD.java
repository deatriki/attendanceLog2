package BD;

import gui.attendancelog.MainWindowController;

import java.sql.SQLException;

public class MainBD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Courses.connectToDB();
        Courses.createDB();


        //вывод бд
//        Courses.writeDB("Courses");

//        MainWindowController.SplitMenuButtonInPut();





        //КАФЕДРЫ
//        Courses.writeDB("Кафедра Англійської мови");
//        Courses.writeDB("Кафедра Безпеки життєдіяльності та фізичного виховання");
//        Courses.writeDB("Кафедра Вищої математики, математичного моделювання та фізики");
//        Courses.writeDB("Кафедра Військової підготовки");
//        Courses.writeDB("Кафедра Документознавства та інформаційної діяльності");
//        Courses.writeDB("Кафедра Економіки");
//        Courses.writeDB("Кафедра Інженерії програмного забезпечення");
//        Courses.writeDB("Кафедра Інженерії програмного забезпечення автоматизованих систем");
//        Courses.writeDB("Кафедра Інформаційної та кібернетичної безпеки");
//        Courses.writeDB("Кафедра Комп'ютерних наук");
//        Courses.writeDB("Кафедра Комп'ютерної інженерії");
//        Courses.writeDB("Кафедра Маркетингу");
//        Courses.writeDB("Кафедра Менеджменту");
//        Courses.writeDB("Кафедра Мобільних та відеоінформаційних технологій");
//        Courses.writeDB("Кафедра Підприємництва, торгівлі та біржової діяльності");
//        Courses.writeDB("Кафедра Публічного управління та адміністрування");
//        Courses.writeDB("Кафедра Систем інформаційного та кібернетичного захисту");
//        Courses.writeDB("Кафедра Системного аналізу");
//        Courses.writeDB("Кафедра Соціології");
//        Courses.writeDB("Кафедра Телекомунікаційних систем та мереж");
//        Courses.writeDB("Кафедра Української мови");
//        Courses.writeDB("Кафедра Управління інформаційною та кібернетичною безпекою");
//        Courses.writeDB("Кафедра Штучного інтелекту");
//        Courses.clear("Courses");
    }
}
