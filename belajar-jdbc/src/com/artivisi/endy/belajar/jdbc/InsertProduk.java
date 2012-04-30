/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author student14
 */
public class InsertProduk {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. variabel untuk koneksi ke database
        String dbDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/belajar";
        String username = "root";
        String password = "";
        
        // 2. loading database driver (tergantung merek database)
        Class.forName(dbDriver);
        
        // 3. buat koneksi ke database
        Connection conn = DriverManager.getConnection(url, username, password);
        
        // 4. jalankan sql
        String sql = "insert into produk (kode, nama) values (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "P-001");
        ps.setString(2, "Produk 001");
        ps.executeUpdate();
        
        // 5. disconnect
        conn.close();
    }
}
