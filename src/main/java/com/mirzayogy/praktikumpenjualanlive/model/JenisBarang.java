package com.mirzayogy.praktikumpenjualanlive.model;

import com.mirzayogy.praktikumpenjualanlive.template.MyModelInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JenisBarang implements MyModelInterface{

    Connection con;

    
    private int id;
    private String namaJenisBarang;

    public JenisBarang(Connection con) {
        this.con = con;
    }

    public JenisBarang(int id, String namaJenisBarang) {
        this.id = id;
        this.namaJenisBarang = namaJenisBarang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJenisBarang() {
        return namaJenisBarang;
    }

    public void setNamaJenisBarang(String namaJenisBarang) {
        this.namaJenisBarang = namaJenisBarang;
    }

    @Override
    public boolean create() {
        boolean berhasil = false;
        
        String insertSQL = "INSERT INTO jenisbarang VALUES "
                + "(NULL,?)";
        
        try {
            PreparedStatement ps = this.con.prepareStatement(insertSQL);
            ps.setString(1, this.namaJenisBarang);
            ps.execute();
            berhasil = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return berhasil;
    }

    @Override
    public ArrayList<Object> read() {
        ArrayList<Object> list =  new ArrayList<>();
        
        String selectSQL = "SELECT * FROM jenisbarang";
        
        try {
            Statement statement = this.con.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);
            
            while(resultSet.next()){
                JenisBarang jb = new JenisBarang(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                list.add(jb);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return list;
    }

    @Override
    public boolean update() {
        
        boolean berhasil = false;
        
        String updateSQL = "UPDATE jenisbarang SET "
                + "namajenisbarang = ? WHERE id = ?";
        
        try {
            PreparedStatement ps = this.con.prepareStatement(updateSQL);
            ps.setString(1, this.namaJenisBarang);
            ps.setInt(2, this.id);

            ps.execute();
            berhasil = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return berhasil;
    }

    @Override
    public boolean delete() {
        boolean berhasil = false;
        
        String deleteSQL = "DELETE FROM jenisbarang WHERE id = ?";
        
        try {
            PreparedStatement ps = this.con.prepareStatement(deleteSQL);
            ps.setInt(1, this.id);

            ps.execute();
            berhasil = true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return berhasil;
    }

    @Override
    public ArrayList<Object> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
