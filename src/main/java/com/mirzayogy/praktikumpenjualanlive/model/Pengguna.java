/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirzayogy.praktikumpenjualanlive.model;

import com.mirzayogy.praktikumpenjualanlive.utils.MD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mirza
 */
public class Pengguna {
    Connection connection;
    
    private int id;
    private String username;
    private String password;
    private String namaLengkap;
    private boolean isAdmin;
    
    public Pengguna(Connection connection) {
        this.connection = connection;
    }
    
    public Pengguna(int id, String username, String namaLengkap, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.namaLengkap = namaLengkap;
        this.isAdmin = isAdmin;
    }
    
    public Pengguna login(){
        Pengguna pengguna = null;
        
        String loginSQL = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
        
        PreparedStatement ps;
        try {
            ps = this.connection.prepareStatement(loginSQL);
            
            String md5Password = MD5.getMd5(this.password);
            
            ps.setString(1, this.username);
            ps.setString(2, md5Password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pengguna = new Pengguna(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getBoolean(5)
                );
            }
        } catch (SQLException ex) {
            System.out.println("Gagal login");
        }
        
        return pengguna;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
}
