package com.mirzayogy.praktikumpenjualanlive.model;

import java.sql.Connection;


public class JenisBarang {

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
    
    
    
    
    
}
