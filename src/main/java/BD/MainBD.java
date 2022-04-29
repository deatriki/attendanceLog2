package BD;
import java.sql.SQLException;
public class MainBD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Facult.connectToDB();
        Facult.createDB();
        Course.createDB();
        Speciality.createDB();
        Lessons.createDB();
        Facult.outputDB("Facult");
//        Speciality.writeDB("","","");
//        Facult.clearBDWhere("5");

//        Lessons.writeDB("БДС-11", "Инглиш");
//        Lessons.outputDB("БДС-11");
//        Facult.clear("Speciality");
//        Facult.clear("Lesson");





        //удаленние строки
//        Speciality.clearBDWhere("4", "1");


//        Speciality.outputDB("Speciality","4","5");

//        Speciality.writeDB("4","5","СТДМ-51");
//        Speciality.writeDB("4","5","УІДМ-51");
//        Speciality.writeDB("4","5","ДЗДМ-51");
//        Speciality.writeDB("4","5","МНДМ-51");
//        Speciality.writeDB("4","5","МРДМ-51");
//        Speciality.writeDB("4","5","ПТБМ-51");

//        Speciality.writeDB("4","4","СТД-41");
//        Speciality.writeDB("4","4","АЗД-41");
//        Speciality.writeDB("4","4","ДЗД-41");
//        Speciality.writeDB("4","4","МНД-41");
//        Speciality.writeDB("4","4","МРД-41");
//        Speciality.writeDB("4","4","ПТБ-41");

//        Speciality.writeDB("4","3","СТД-31");
//        Speciality.writeDB("4","3","АЗД-31");
//        Speciality.writeDB("4","3","ДЗД-31");
//        Speciality.writeDB("4","3","МНД-31");
//        Speciality.writeDB("4","3","МНД-32");
//        Speciality.writeDB("4","3","МРД-31");
//        Speciality.writeDB("4","3","ПТБ-31");

//        Speciality.writeDB("4","2","СТД-21");
//        Speciality.writeDB("4","2","АЗД-21");
//        Speciality.writeDB("4","2","ДЗД-21");
//        Speciality.writeDB("4","2","МНД-21");
//        Speciality.writeDB("4","2","МНД-22");
//        Speciality.writeDB("4","2","МРД-21");
//        Speciality.writeDB("4","2","МРД-22");
//        Speciality.writeDB("4","2","ПТБ-21");
//        Speciality.writeDB("4","2","ПТБ-22");

//        Speciality.writeDB("4","1","СТД-11");
//        Speciality.writeDB("4","1","АЗД-11");
//        Speciality.writeDB("4","1","АЗД-12");
//        Speciality.writeDB("4","1","ДЗД-11");
//        Speciality.writeDB("4","1","ДЗД-12");
//        Speciality.writeDB("4","1","МНД-11");
//        Speciality.writeDB("4","1","МРД-11");
//        Speciality.writeDB("4","1","МРД-12");
//        Speciality.writeDB("4","1","ПТБ-11");



        //Speciality.writeDB("3","5","ЕПДМ-51");
//        Speciality.writeDB("3","5","АРДМ-51");
//        Speciality.writeDB("3","5","САДМ-51");
//        Speciality.writeDB("3","5","ТСДМ-51");
//        Speciality.writeDB("3","5","ТСДМ-52");
//        Speciality.writeDB("3","5","ТСДМ-53");

//        Speciality.writeDB("3","4","САД-41");
//        Speciality.writeDB("3","4","ЕПД-41");
//        Speciality.writeDB("3","4","ТСД-41");
//        Speciality.writeDB("3","4","ТСД-42");
//        Speciality.writeDB("3","4","ТСД-43");
//        Speciality.writeDB("3","4","ТСД-44");
//        Speciality.writeDB("3","4","ТСД-45");

//        Speciality.writeDB("3","3","САД-31");
//        Speciality.writeDB("3","3","ЕПД-31");
//        Speciality.writeDB("3","3","ТСД-31");
//        Speciality.writeDB("3","3","ТСД-32");
//        Speciality.writeDB("3","3","ТСД-33");
//        Speciality.writeDB("3","3","ТСД-34");
//        Speciality.writeDB("3","3","ТСД-35");
//        Speciality.writeDB("3","3","МТД-31");
//        Speciality.writeDB("3","3","МТД-32");
//
//        Speciality.writeDB("3","2","САД-21");
//        Speciality.writeDB("3","2","ЕПД-21");
//        Speciality.writeDB("3","2","ТСД-21");
//        Speciality.writeDB("3","2","ТСД-22");
//        Speciality.writeDB("3","2","ТСД-23");
//        Speciality.writeDB("3","2","ТСД-24");

//        Speciality.writeDB("3","1","САД-11");
//        Speciality.writeDB("3","1","ЕПД-11");
//        Speciality.writeDB("3","1","МТД-11");
//        Speciality.writeDB("3","1","МТД-12");
//        Speciality.writeDB("3","1","ТСД-11");
//        Speciality.writeDB("3","1","ТСД-12");
//        Speciality.writeDB("3","1","ТСД-13");
//
//        Speciality.writeDB("2","5","КНДМ-51");
//        Speciality.writeDB("2","5","ІСДМ-51");
//        Speciality.writeDB("2","5","ПДМ-51");
//        Speciality.writeDB("2","5","ПДМ-52");
//        Speciality.writeDB("2","5","КСДМ-51");



//        Speciality.writeDB("2","4","ПД-41");
//        Speciality.writeDB("2","4","ПД-42");
//        Speciality.writeDB("2","4","ПД-43");
//        Speciality.writeDB("2","4","ПД-44");
//        Speciality.writeDB("2","4","ІСД-41");
//        Speciality.writeDB("2","4","ІСД-42");
//        Speciality.writeDB("2","4","КІД-41");
//        Speciality.writeDB("2","4","КІД-42");
//        Speciality.writeDB("2","4","КІД-43");
//        Speciality.writeDB("2","4","КНД-41");
//        Speciality.writeDB("2","4","КНД-42");



//        Speciality.writeDB("2","3","ПД-31");
//        Speciality.writeDB("2","3","ПД-32");
//        Speciality.writeDB("2","3","ПД-33");
//        Speciality.writeDB("2","3","ПД-34");
//        Speciality.writeDB("2","3","ІСД-31");
//        Speciality.writeDB("2","3","ІСД-32");
//        Speciality.writeDB("2","3","КІД-31");
//        Speciality.writeDB("2","3","КІД-32");
//        Speciality.writeDB("2","3","КНД-31");
//        Speciality.writeDB("2","3","КНД-32");
//        Speciality.writeDB("2","3","КНД-33");



//
//        Speciality.writeDB("2", "2", "ШІД-21");
//        Speciality.writeDB("2", "2", "ШІД-22");
//        Speciality.writeDB("2", "2", "ПД-21");
//        Speciality.writeDB("2", "2", "ПД-22");
//        Speciality.writeDB("2", "2", "ПД-23");
//        Speciality.writeDB("2", "2", "ПД-24");
//        Speciality.writeDB("2", "2", "ІСД-21");
//        Speciality.writeDB("2", "2", "ІСД-22");
//        Speciality.writeDB("2", "2", "КІД-21");
//        Speciality.writeDB("2", "2", "КІД-22");
//        Speciality.writeDB("2", "2", "КНД-21");
//        Speciality.writeDB("2", "2", "КНД-22");






//        Speciality.writeDB("2", "1", "ШІД-11");
//        Speciality.writeDB("2", "1", "ШІД-12");
//        Speciality.writeDB("2", "1", "ШІД-13");
//        Speciality.writeDB("2", "1", "ПД-11");
//        Speciality.writeDB("2", "1", "ПД-12");
//        Speciality.writeDB("2", "1", "ПД-13");
//        Speciality.writeDB("2", "1", "ПЛ-14");
//        Speciality.writeDB("2", "1", "ІСД-11");
//        Speciality.writeDB("2", "1", "ІСД-12");
//        Speciality.writeDB("2", "1", "ІСД-13");
//        Speciality.writeDB("2", "1", "КІД-11");
//        Speciality.writeDB("2", "1", "КІД-12");
//        Speciality.writeDB("2", "1", "КНД-11");
//        Speciality.writeDB("2", "1", "КНД-12");
//        Speciality.writeDB("2", "1", "КНД-13");
//        Speciality.writeDB("2", "1", "КНД-14");



//        Speciality.writeDB("1", "5","БСДМ-51");
//        Speciality.writeDB("1", "5","БСДМ-52");
//        Speciality.writeDB("1", "5","БСДМ-53");
////        Speciality.writeDB("1", "4","БСД-44");
//        Speciality.writeDB("1", "5","ПУДМ-51");
//        Speciality.writeDB("1", "5","СЗДМ-51");
////        Speciality.writeDB("1", "4","СЗД-42");
//        Speciality.writeDB("1", "5","УБДМ-51");
//        Speciality.writeDB("1", "2","УБД-22");











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
//        Facult.clear("Facult");
    }
}
