
package com.creus.login.login_register_creus.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionBBDD {
    private static final String URL = "jdbc:sqlite:RegisterBBDD.db";
    
    public static void insertUser(String user_id, String name, String postal_code, String birth_date, String mail, String password){
        String sql = "INSERT INTO usuarios(user_id, name, postal_code, birth_date, mail, password) VALUES(?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user_id);
            pstmt.setString(2, name);
            pstmt.setString(3, postal_code);
            pstmt.setString(4, birth_date);
            pstmt.setString(5, mail);
            pstmt.setString(6, password);
            pstmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("Error al insertar en SQLite: " + e.getMessage());
        }
    }
}
