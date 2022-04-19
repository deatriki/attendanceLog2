package BD;

import java.sql.SQLException;

public class MainBD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Facult.connectToDB();
        Facult.createDB();
        Course.createDB();
        Speciality.createDB();
//        Speciality.writeDB("1", "5","БСДМ-51");
//        Speciality.writeDB("1", "5","БСДМ-52");
//        Speciality.writeDB("1", "5","БСДМ-53");
////        Speciality.writeDB("1", "4","БСД-44");
//        Speciality.writeDB("1", "5","ПУДМ-51");
//        Speciality.writeDB("1", "5","СЗДМ-51");
////        Speciality.writeDB("1", "4","СЗД-42");
//        Speciality.writeDB("1", "5","УБДМ-51");
//        Speciality.writeDB("1", "2","УБД-22");

        Speciality.outputDB("Speciality","1","5");









//        Course.writeDB("1");
//        Course.writeDB("2");
//        Course.writeDB("3");
//        Course.writeDB("4");
//        Course.writeDB("5");



//
//        Facult.writeDB("Навчально-науковий інститут захисту інформації");
//        Facult.writeDB("Навчально-науковий інститут інформаційних технологій");
//        Facult.writeDB("Навчально-науковий інститут телекомунікацій");
//        Facult.writeDB("Навчально-науковий інститут менеджементу та підприємства");
//        Facult.writeDB("Навчально-науковий інститут заочного та дистанційного навчання");
//        //вывод бд
//        Courses.outputDB ("Courses");
//        Course.outputDB("Course");

//        MainWindowController.SplitMenuButtonInPut();





        //КАФЕДРЫ
//        Facult.writeDB("Кафедра Англійської мови");
//        Facult.writeDB("Кафедра Безпеки життєдіяльності та фізичного виховання");
//        Facult.writeDB("Кафедра Вищої математики, математичного моделювання та фізики");
//        Facult.writeDB("Кафедра Військової підготовки");
//        Facult.writeDB("Кафедра Документознавства та інформаційної діяльності");
//        Facult.writeDB("Кафедра Економіки");
//        Facult.writeDB("Кафедра Інженерії програмного забезпечення");
//        Facult.writeDB("Кафедра Інженерії програмного забезпечення автоматизованих систем");
//        Facult.writeDB("Кафедра Інформаційної та кібернетичної безпеки");
//        Facult.writeDB("Кафедра Комп'ютерних наук");
//        Facult.writeDB("Кафедра Комп'ютерної інженерії");
//        Facult.writeDB("Кафедра Маркетингу");
//        Facult.writeDB("Кафедра Менеджменту");
//        Facult.writeDB("Кафедра Мобільних та відеоінформаційних технологій");
//        Facult.writeDB("Кафедра Підприємництва, торгівлі та біржової діяльності");
//        Facult.writeDB("Кафедра Публічного управління та адміністрування");
//        Facult.writeDB("Кафедра Систем інформаційного та кібернетичного захисту");
//        Facult.writeDB("Кафедра Системного аналізу");
//        Facult.writeDB("Кафедра Соціології");
//        Facult.writeDB("Кафедра Телекомунікаційних систем та мереж");
//        Facult.writeDB("Кафедра Української мови");
//        Facult.writeDB("Кафедра Управління інформаційною та кібернетичною безпекою");
//        Facult.writeDB("Кафедра Штучного інтелекту");
//        Facult.clear("Speciality");
    }
}
