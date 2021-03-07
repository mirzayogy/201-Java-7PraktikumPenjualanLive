/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirzayogy.praktikumpenjualanlive.template;

import java.util.ArrayList;

/**
 *
 * @author mirza
 */
public interface ViewFrameInterface {
    abstract void refresh();
    abstract void buildTable(ArrayList<Object> list);
}
