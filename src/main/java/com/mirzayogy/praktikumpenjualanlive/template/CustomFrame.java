/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirzayogy.praktikumpenjualanlive.template;

/**
 *
 * @author mirza
 */
public class CustomFrame extends javax.swing.JFrame{
    public void customShow() {
        this.dispose();
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
