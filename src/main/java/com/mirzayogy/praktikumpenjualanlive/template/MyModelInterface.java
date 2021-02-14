package com.mirzayogy.praktikumpenjualanlive.template;

import java.util.ArrayList;

public interface MyModelInterface {
    
    abstract boolean create();
    abstract ArrayList<Object> read();
    abstract boolean update();
    abstract boolean delete();
    abstract ArrayList<Object> search(String keyword);
    
}
