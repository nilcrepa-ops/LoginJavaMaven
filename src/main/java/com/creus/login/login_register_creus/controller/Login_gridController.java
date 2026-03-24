package com.creus.login.login_register_creus.controller;

import com.creus.login.login_register_creus.App;
import com.creus.login.login_register_creus.model.ConnectionBBDD;
import static com.creus.login.login_register_creus.model.ConnectionBBDD.insertUser;
import com.creus.login.login_register_creus.model.RegisteredUsersManagement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ficheros.ClassFichero;

import com.creus.login.login_register_creus.model.UserDataValidations;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.time.LocalDate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login_gridController implements Initializable {

    @FXML
    private ImageView imgSegurata;
    @FXML
    private Label lblInfo;
    @FXML
    private TextField txtName;    // Faltaba @FXML
    @FXML
    private TextField txtId;      // Faltaba @FXML
    @FXML
    private TextField txtPostal;  // Faltaba @FXML
    @FXML
    private TextField txtBirth;   // Faltaba @FXML
    @FXML
    private TextField txtMail;    // Faltaba @FXML
    @FXML
    private Label lblDNI;         // Faltaba @FXML
    @FXML
    private Label lblPostal;      // Faltaba @FXML
    @FXML
    private Label lblBirth;       // Faltaba @FXML
    @FXML
    private Label lblMail;        // Faltaba @FXML
    @FXML
    private Label lblName;        // Faltaba @FXML
    @FXML
    private MediaView videoSeg;   // Faltaba @FXML
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Hyperlink hLinkLogin;
    @FXML
    private Label lblPass;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ClassFichero.createFile("RegistroUsuarios.csv");
            String line = "name" + ";" + "id" + ";" + "postalCode" + ";" + "birthDate" + ";" + "mail" + ";" + "password" + "\n";
            ClassFichero.writeFile(line);
        } catch (Exception e) {
            System.out.println("Error al crear fichero");
        }
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
        String pass = txtPass.getText();        
        
        //Si hay algun campo vacio, lanzamos advertencia y cambiamos imagen
        if (UserDataValidations.comprobarCampos(name, id, postalCode, birth, mail, pass)) {
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

        if (UserDataValidations.checkPassword(pass)) {
            lblPass.setStyle("-fx-text-fill: red");
            Image imgNo = new Image(getClass().getResourceAsStream("/img/segurata_no.png"));
            imgSegurata.setImage(imgNo);
            camposIncorrectos++;
            todoOk = false;
        }
        if (todoOk) { //Si estan todos los campos bien "reseteamos" los labels a color negro
            lblInfo.setText(adverts[6]);
            lblInfo.setStyle("-fx-text-fill: green");
            lblName.setStyle("-fx-text-fill: black");
            lblDNI.setStyle("-fx-text-fill: black");
            lblPostal.setStyle("-fx-text-fill: black");
            lblBirth.setStyle("-fx-text-fill: black");
            lblMail.setStyle("-fx-text-fill: black");
            lblPass.setStyle("-fx-text-fill: black");

            Image imgSi = new Image(getClass().getResourceAsStream("/img/segurata_si.png"));
            imgSegurata.setImage(imgSi);

            txtName.setEditable(false);
            txtId.setEditable(false);
            txtPostal.setEditable(false);
            txtBirth.setEditable(false);
            txtMail.setEditable(false);
            txtPass.setEditable(false);
            btnRegister.setDisable(true);
            
            //Registramos la fecha del registro
            LocalDate localDate = LocalDate.now();
            String date = localDate.toString();
            
            ConnectionBBDD.insertUser(id, name, postalCode, birth, mail, pass, date);
        }

        if (camposIncorrectos > 0) {
            lblInfo.setText(adverts[7]);
            lblInfo.setStyle("-fx-text-fill: red");
        }
    }

    private MediaPlayer mediaPlayer;

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

    @FXML
    private void limpiar(ActionEvent event) {
        txtName.setEditable(true);
        txtId.setEditable(true);
        txtPostal.setEditable(true);
        txtBirth.setEditable(true);
        txtMail.setEditable(true);
        btnRegister.setDisable(false);
        txtPass.setDisable(false);

        txtName.setText("");
        txtId.setText("");
        txtPostal.setText("");
        txtBirth.setText("");
        txtMail.setText("");
        txtPass.setText("");
        lblInfo.setText("");

        Image imgNeutro = new Image(getClass().getResourceAsStream("/img/segurata.png"));
        imgSegurata.setImage(imgNeutro);
    }

    @FXML
    private void switchLogin(ActionEvent event) {
        try {
            // Reemplaza "nombre_de_tu_archivo" por el nombre del FXML al que quieres ir
            // (sin la extensión .fxml)
            App.setRoot("login_login");
        } catch (Exception e) {
            System.err.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

}
