package com.creus.login.login_register_creus.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import com.creus.login.login_register_creus.model.UserDataValidations;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Login_gridController implements Initializable {

    @FXML
    private ImageView imgSegurata;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnMagico;
    @FXML
    private Label lblInfo;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPostal;
    @FXML
    private TextField txtBirth;
    @FXML
    private TextField txtMail;
    @FXML
    private Label lblDNI;
    @FXML
    private Label lblPostal;
    @FXML
    private Label lblBirth;
    @FXML
    private Label lblMail;
    @FXML
    private Label lblName;
    @FXML
    private MediaView videoSeg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pulsarRegister() {
        boolean todoOk = true;
        int camposIncorrectos = 0;
        String[] adverts = { //Lo dejo por si me sirve mas adelante
            "Atención: Debes rellenar todos los campos.",
            "Atención: Datos de campo 'Nombre' no válido.",
            "Atención: Datos de campo 'DNI' no válidos.",
            "Atención: Datos de campo 'Código Postal' no válidos.",
            "Atención: Datos de campo 'Fecha de nacimiento' no válidos (DD/MM/AAAA).",
            "Atención: Datos de campo 'Correo Electrónico' no válidos.",
            "Usuario registrado con éxito",
            "Uno o más campos con datos no válidos."
        };
        //capturamos en String's los datos introducidos por el usuario
        String name = txtName.getText();
        String id = txtId.getText();
        String postalCode = txtPostal.getText();
        String birth = txtBirth.getText();
        String mail = txtMail.getText();

        //Si hay algun campo vacio, lanzamos advertencia y cambiamos imagen
        if (UserDataValidations.comprobarCampos(name, id, postalCode, birth, mail)) {
            lblInfo.setText(adverts[0]);
            lblInfo.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            todoOk = false;

        }
        if (!UserDataValidations.checkName(name)) {
            lblName.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;

        }
        if (!UserDataValidations.checkId(id)) {
            lblDNI.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;

        }
        if (!UserDataValidations.checkPostalCode(postalCode)) {
            lblPostal.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;

        }
        if (!UserDataValidations.checkFormatDate(birth)) {
            lblBirth.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;

        }
        if (!UserDataValidations.checkEmail(mail)) {
            lblMail.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;

        }
        if (todoOk){ //Si estan todos los campos bien "reseteamos" los labels a color negro
            lblInfo.setText(adverts[6]);
            lblInfo.setStyle("-fx-text-fill: green");
            lblName.setStyle("-fx-text-fill: black");
            lblDNI.setStyle("-fx-text-fill: black");
            lblPostal.setStyle("-fx-text-fill: black");
            lblBirth.setStyle("-fx-text-fill: black");
            lblMail.setStyle("-fx-text-fill: black");

            Image imgSi = new Image(getClass().getResourceAsStream("/img/segurata_si.png"));
            imgSegurata.setImage(imgSi);
            
        }

        if (camposIncorrectos > 0) {
            lblInfo.setText(adverts[7]);
            lblInfo.setStyle("-fx-text-fill: red");
        }
    }
    private MediaPlayer mediaPlayer;

    @FXML
    public void pulsarMagico() {
        imgSegurata.setVisible(false);
        videoSeg.setVisible(true);

        String pathVideo = getClass().getResource("/img/segurata_vid.mp4").toExternalForm();

        Media media = new Media(pathVideo);
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(() -> {
            imgSegurata.setVisible(true);
            videoSeg.setVisible(false);
        });

        videoSeg.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

    }

}
