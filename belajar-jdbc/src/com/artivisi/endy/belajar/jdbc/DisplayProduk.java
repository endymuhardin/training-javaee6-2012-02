/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.endy.belajar.jdbc;

import java.sql.*;

/**
 *
 * @author student14
 */
public class DisplayProduk {
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
        String sql = "select * from produk";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Integer id = rs.getInt("id");
            String kode = rs.getString("kode");
            String nama = rs.getString("nama");
            
            System.out.println("ID : "+id+", Kode : "+kode+", Nama : "+nama);
        }
        
        // 5. close koneksi database
        conn.close();
    }
}
