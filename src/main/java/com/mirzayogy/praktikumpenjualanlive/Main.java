package com.mirzayogy.praktikumpenjualanlive;

import com.mirzayogy.praktikumpenjualanlive.db.Database;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        
        Database db = new Database();
        Connection con = db.getConnection();
    }
}