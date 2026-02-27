module com.creus.login.login_register_creus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.creus.login.login_register_creus to javafx.fxml;
    exports com.creus.login.login_register_creus;
}
