module gui.attendancelog {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens gui to javafx.fxml;
    exports gui;
    exports gui.settings;
    opens gui.settings to javafx.fxml;
    exports gui.windows;
    opens gui.windows to javafx.fxml;
}