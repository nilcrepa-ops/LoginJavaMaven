/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.creus.login.login_register_creus.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nil
 */
public class ValidationsRescate {

    /**
     * * @param user
     * @param id
     * @param postalCode
     * @param fecha
     * @param mail
     * @return true si hay algun campo vacio
     */
    public static boolean comprobarCampos(String user, String id, String postalCode, String fecha, String mail) {
        return user.isEmpty() || id.isEmpty() || postalCode.isEmpty() || fecha.isEmpty() || mail.isEmpty();
    }

    /**
     *
     * //@param typeDoc Valida que el DNI introducido sea válido
     *
     * @param id
     * @return true si DNI es valido, false si no lo es
     */
    public static boolean checkId(/*int typeDoc,*/String id) {
        //Primera parte. Verifica que lo que introduce el usuario es coherente
        //id es el DNI que ha introducido el usuario
        if (id.length() != 9) {
            return false;
        }
        char letra = id.charAt(id.length() - 1); //Almacenar en 'letra' la letra del DNI
        String numeros = id.substring(0, id.length() - 1); //Almacenar en 'numeros' los nums del DNI
        int numsDNI = Integer.parseInt(numeros); //Convertimos el String numeros a int

        //Segunda parte. Verificar con algoritmo si el DNI es verdadero
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

        int resto = numsDNI % 23;

        return caracteres.charAt(resto) == letra;
    }

    /**
     * Valida que el formato de fecha sea válido (DD/MM/AAAA)
     *
     * @param date
     * @return true si el formato de fecha es valido, false si no lo es
     */
    public static boolean checkFormatDate(String date) {
        String[] sep = date.split("\\/");
        int diasMax = 0;
        if (sep.length != 3) { //Si la longitud del array es mayor que 3, se ha introducido una fecha rara
            return false;
        }
        //Conversion a int para verificar que dia mes y año sean coherentes
        int diaNum = Integer.parseInt(sep[0]);
        int mesNum = Integer.parseInt(sep[1]);
        int anyoNum = Integer.parseInt(sep[2]);

        switch (mesNum) {
            case 2:
                if ((anyoNum % 4 == 0 && anyoNum % 100 != 0) || (anyoNum % 400 == 0)) {
                    diasMax = 29;
                } else {
                    diasMax = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasMax = 30;
                break;
            default:
                diasMax = 31;
                break;
        }

        if ((diaNum < 1 || diaNum > diasMax) || (mesNum < 1 || mesNum > 12) || (anyoNum < 1920 || anyoNum > 2026)) {
            return false;
        }

        return sep[0].length() == 2 && sep[1].length() == 2 && sep[2].length() == 4;
    }

    /**
     * Calcula la edad en años en base a tu fecha de nacimiento
     *
     * @param birthDateStr
     * @return edad en años
     */
    public static int calculateAge(String birthDateStr) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Dar formato a la fecha
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(birthDate, fechaActual);
        int edad = periodo.getYears();
        return edad;
    }

    /**
     * Valida si el código postal es valido
     *
     * @param zip
     * @return true si el código postal es válido (Territorio español)
     */
    public static boolean checkPostalCode(String zip) {
        //Acabar cuadno este hecha la funcion de solo numeros
        //Comprobar que la longitud es exactamente 5
        if (zip.length() != 5) {
            return false;
        }

        if (!isNumeric(zip)) {
            return false;
        }
        int zipInt = Integer.parseInt(zip);

        if (zipInt < 1001 || zipInt > 52999) {
            return false;
        }
        return true;
    }

    /**
     * Valida que el input sea sólo números
     *
     * @param str
     * @return true si el input es solo numeros
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param str
     * @return true si el input es sólo letras (pueden haber espacios)
     */
    public static boolean isAlphabetic(String str) {
        str = str.trim();
        if (str.isBlank()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida que el email introducido sea válido
     *
     * @param email
     * @return true si el input es un formato de correo electrónico
     */
    public static boolean checkEmail(String email) { //Acabar de checkear que haya algo entre el @ y la terminacion
        String[] terminaciones = {".com", ".es", ".net"};
        //Comprobar espacios
        if (email.contains(" ")) {
            return false;
        }
        //Comprobar si contiene @
        if (!email.contains("@")) {
            return false;
        }
        //Comprobar que no empiece con @
        if (email.indexOf("@") == 0) {
            return false;
        }
        //Comprobar que termine con una de las terminaciones establecidas. Se pueden añadir en el array
        boolean terminaBien = false;
        for (int i = 0; i < terminaciones.length; i++) {
            if (email.endsWith(terminaciones[i])) {
                terminaBien = true;
                break;
            }
        }
        if (!terminaBien) {
            return false;
        }
        return true;
    }

    /**
     * Valida que el nombre introducido es válido
     *
     * @param name
     * @return true si el nombre es coherente (no apto para el retoño de tito
     * Musk)
     */
    public static boolean checkName(String name) {
        if (name.length() > 20) {
            return false;
        }
        if (!isAlphabetic(name)) {
            return false;
        }

        return true;
    }
}
