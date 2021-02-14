package com.mirzayogy.praktikumpenjualanlive.model;

import com.mirzayogy.praktikumpenjualanlive.template.MyModelInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
