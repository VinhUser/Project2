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
public class Student extends OOP implements Serializable{

    public Student() {
    }

    public Student(String ID, String name) {
        super(ID, name);
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + ID + ", studentName=" + name + '}';
    }
    @Override
    public void print(){
        System.out.printf("|%-15s|%-15s|\n",
                            ID, name);
    }
}
