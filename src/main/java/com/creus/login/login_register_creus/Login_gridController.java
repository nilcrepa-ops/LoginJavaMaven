/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.creus.login.login_register_creus;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author Nil
 */
public class Login_gridController implements Initializable {


    @FXML
    private ImageView imgSegurata;
    @FXML
    private TextField lblName;
    @FXML
    private TextField lblId;
    @FXML
    private TextField lblPostal;
    @FXML
    private TextField lblBirth;
    @FXML
    private TextField lblMail;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogIn;
    @FXML
    private Label lblVerificate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
