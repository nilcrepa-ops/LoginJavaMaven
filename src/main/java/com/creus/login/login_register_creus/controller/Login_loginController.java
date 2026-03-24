/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.creus.login.login_register_creus.controller;

import com.creus.login.login_register_creus.App;
import com.creus.login.login_register_creus.model.ConnectionBBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.creus.login.login_register_creus.model.RegisteredUsersManagement;

import com.creus.login.login_register_creus.model.UserDataValidations;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nil
 */
public class Login_loginController {

    @FXML
    private Label lblName;
    @FXML
    private Label lblPass;
    @FXML
    private TextField txtNombre;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnIniciar;
    @FXML
    private Hyperlink HLinkReg;
    @FXML
    private Label txtInfo;
    @FXML
    private ImageView imgSegurata;
    @FXML
    private Button btnEntrar;

    @FXML
    private void switchReg(ActionEvent event) {
        try {
            // Reemplaza "nombre_de_tu_archivo" por el nombre del FXML al que quieres ir
            // (sin la extensión .fxml)
            App.setRoot("login_grid");
        } catch (Exception e) {
            System.err.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

    @FXML
    private void pulsarIniciar(ActionEvent event) {
        boolean todoOk = true;

        String nombre = txtNombre.getText();
        String pass = txtPass.getText();

        if (UserDataValidations.comprobarCamposLogin(nombre, pass)) {
            txtInfo.setText("Atención: Campos sin rellenar");
            txtInfo.setStyle("-fx-text-fill: red");
            lblName.setStyle("-fx-text-fill: red");
            lblPass.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            todoOk = false;
        }
        if (todoOk) {
            if (ConnectionBBDD.validateLogin(nombre, pass)) {
                txtInfo.setText("Inicio de sesión correcto");

                txtInfo.setStyle("-fx-text-fill: green");
                lblName.setStyle("-fx-text-fill: black");
                lblPass.setStyle("-fx-text-fill: black");
                Image imgSi = new Image(getClass().getResourceAsStream("/img/segurata_si.png"));
                imgSegurata.setImage(imgSi);

                txtNombre.setEditable(false);
                txtPass.setEditable(false);
                btnEntrar.setDisable(false);
            } else {
                txtInfo.setText("Inicio de sesión incorrecto");
                txtInfo.setStyle("-fx-text-fill: red");
                lblName.setStyle("-fx-text-fill: black");
                lblPass.setStyle("-fx-text-fill: black");
                Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
                imgSegurata.setImage(imgNo);

//                txtNombre.setEditable(false);
//                txtPass.setEditable(false);
//                btnEntrar.setDisable(false);
            }

//            if (RegisteredUsersManagement.checkLogin(nombre, pass)) {
//                txtInfo.setText("Inicio de sesión correcto");
//
//                txtInfo.setStyle("-fx-text-fill: green");
//                lblName.setStyle("-fx-text-fill: black");
//                lblPass.setStyle("-fx-text-fill: black");
//                Image imgSi = new Image(getClass().getResourceAsStream("/img/segurata_si.png"));
//                imgSegurata.setImage(imgSi);
//
//                txtNombre.setEditable(false);
//                txtPass.setEditable(false);
//                btnEntrar.setDisable(false);
//            } else {
//                txtInfo.setText("Inicio de sesión incorrecto");
//                txtInfo.setStyle("-fx-text-fill: red");
//                lblName.setStyle("-fx-text-fill: black");
//                lblPass.setStyle("-fx-text-fill: black");
//                Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
//                imgSegurata.setImage(imgNo);
//
//                txtNombre.setEditable(false);
//                txtPass.setEditable(false);
//                btnEntrar.setDisable(false);
//            }

        }
    }

    @FXML
    private void botonLimpiar(ActionEvent event) {
        try {
            App.setRoot("Surprise");
        } catch (Exception e) {
            System.err.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

}
