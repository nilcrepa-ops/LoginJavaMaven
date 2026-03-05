module com.creus.login.login_register_creus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.media;

    opens com.creus.login.login_register_creus.controller to javafx.fxml;
    exports com.creus.login.login_register_creus;
}
