package com.creus.login.login_register_creus;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {


    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
