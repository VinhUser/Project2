/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vinh
 */
public class StudentManagnments implements Function<Student>, Serializable{
    ArrayList<Student> studentList = new ArrayList<Student>();
    FileReader in = null;
    FileWriter out = null;
    BufferedReader br = null;
    String decoyString;
    String[] listString;
    Tool tool = new Tool();
    public void loadFromFile() {
        try {

            in = new FileReader("student.dat");
            br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                listString = line.split(";");
                Student newStudent = new Student(listString[0], listString[1]);
                addStudent(newStudent);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }
    
    @Override
    public boolean isIdDuplicate(String ID) {
        for (Student student : studentList) {
            if (student.ID.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Student searchByID(String ID) {
        for (Student student : studentList) {
            if (student.ID.equals(ID)) {
                return student;
            }
        }
        return null;
    }
    @Override
    public void print() {
        System.out.println(" -----------------------------");
        System.out.printf("|%-15s|%-15s|\n", "ID", "Name");
        System.out.println(" -----------------------------");
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).print();
        }
        System.out.println(" -----------------------------");
    }

    @Override
    public void delete() {
        String id;
        int n;
        System.out.print("input Student to search: ");
        id = tool.inputString("id: ", "id :");
        Student xxx = searchByID(id);
        if (xxx == null) {
            System.out.println("Not found!! No Student to be remove");
        } else {
            System.out.println("Student found!!!");
            System.out.println("here Student you want to remove");
            xxx.print();
            System.out.println("Do you want to remove the student?");
            System.out.println("'Yes' input 1 | 'No' input 2");
            System.out.print("Your choice: ");
            n = tool.getInt(1, 2, "input 1 or 2");

            if (n == 1) {
                studentList.remove(xxx);
            }
            System.out.println("after remove student");
            for (int i = 0; i < studentList.size(); i++) {
               studentList.get(i).print();
            }
        }
    }

    @Override
    public int size() {
        return studentList.size();
    }
}
