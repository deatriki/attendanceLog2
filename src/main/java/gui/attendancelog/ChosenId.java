package gui.attendancelog;

public class ChosenId {
    public static String getFacult_id() {
        return facult_id;
    }

    public static void setFacult_id(String facult_id) {
        ChosenId.facult_id = facult_id;
    }

    public static String getCourse_id() {
        return course_id;
    }

    public static void setCourse_id(String course_id) {
        ChosenId.course_id = course_id;
    }

    private static String facult_id = "";
    private static String course_id = "";

    public static String getGroup() {
        return group;
    }

    public static void setGroup(String group) {
        ChosenId.group = group;
    }

    private static String group = "";
}
