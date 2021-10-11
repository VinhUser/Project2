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
public class VaccineManagnments implements Function<Vaccine>, Serializable{
    ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
    FileReader in = null;
    FileWriter out = null;
    BufferedReader br = null;
    String decoyString;
    String[] listString;
    Tool tool = new Tool();
    public void loadFromFile() {
        try {
            in = new FileReader("vaccine.dat");
            br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                listString = line.split(";");
                Vaccine newVaccine = new Vaccine(listString[0], listString[1]);
                addVaccine(newVaccine);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void addVaccine(Vaccine vaccine) {
        vaccineList.add(vaccine);
    }
    @Override
    public Vaccine searchByID(String ID) {
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.ID.equals(ID)) {
                return vaccine;
            }
        }
        return null;
    }

    @Override
    public boolean isIdDuplicate(String ID) {
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.ID.equals(ID)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void print() {
        System.out.println(" -----------------------------");
        System.out.printf("|%-15s|%-15s|\n", "ID", "Name");
        System.out.println(" -----------------------------");
        for (int i = 0; i < vaccineList.size(); i++) {
            vaccineList.get(i).print();
        }
        System.out.println(" -----------------------------");
    }

    @Override
    public void delete() {
        String id;
        int n;
        System.out.print("input vaccine to search: ");
        id = tool.inputString("id: ", "id :");
        Vaccine xxx = searchByID(id);
        if (xxx == null) {
            System.out.println("Not found!! No Vaccine to be remove");
        } else {
            System.out.println("Vaccine found!!!");
            System.out.println("here Vaccine you want to remove");
            xxx.print();
            System.out.println("Do you want to remove the Vaccine?");
            System.out.println("'Yes' input 1 | 'No' input 2");
            System.out.print("Your choice: ");
            n = tool.getInt(1, 2, "input 1 or 2");

            if (n == 1) {
                vaccineList.remove(xxx);
            }
            System.out.println("after remove Vaccine");
            for (int i = 0; i < vaccineList.size(); i++) {
               vaccineList.get(i).print();
            }
        }
    }

    @Override
    public int size() {
        return vaccineList.size();
    }
}
