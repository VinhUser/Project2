/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.Serializable;

/**
 *
 * @author Vinh
 */
public class Vaccine extends OOP implements Serializable{
    
    public Vaccine() {
    }

    public Vaccine(String ID, String name) {
        super(ID, name);
    }
    
    @Override
    public void print(){
        System.out.printf("|%-15s|%-15s|\n",
                             ID, name);
    }
}
