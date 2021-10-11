/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.File;
import java.io.IOException;
//import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author Vinh
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        TimeZone zone = TimeZone.getDefault();
        System.out.println(zone.getDisplayName());
        System.out.println(zone.getID());
        Date now = new Date();
        System.out.println(now);
        MenuManagnments menu = new MenuManagnments();
        Tool tool = new Tool();
        Scanner sc = new Scanner(System.in);
        int choice;
        InjectionManagnments injectionManager = new InjectionManagnments();
        StudentManagnments studentManager = new StudentManagnments();
        VaccineManagnments vaccineManager = new VaccineManagnments();
        studentManager.loadFromFile();
        vaccineManager.loadFromFile();
        injectionManager.loadFromFile();
        Injection newInjection;
        File file = new File("injection.dat");
        do {
            System.out.println("-------------------------------------------------------------");
            menu.printMenu();
            choice = tool.getInt(1, 8, "input >= 1 || <= 8");
            switch (choice) {
                case 1: {
                    injectionManager.print();
                    break;
                }
                case 2: {
                    int n = 0;

                    do {
                        newInjection = injectionManager.addInjection(studentManager, vaccineManager);
                        injectionManager.addInjcetion(newInjection);
                        System.out.println("Do you want to continue to search to a dish? ");
                        System.out.println("choice 1 if you want to continue or 2 if you want to exit");
                        System.out.print("Your choice: ");
                        n = tool.getInt(1, 2, "input n is 1 or 2");
                        if (n == 2) {
                            break;
                        }
                    } while (true);
                    break;
                }

                case 3: {
                    int n = 0;

                    do {
                        injectionManager.updateInjection();
                        System.out.println("Do you want to continue to remove to a dish? ");
                        System.out.println("choice 1 if you want to continue or 2 if you want to exit");
                        System.out.print("Your choice: ");
                        n = tool.getInt(1, 2, "input n is 1 or 2");
                        if (n == 2) {
                            break;
                        }
                    } while (true);
                    break;
                }

                case 4: {
                    int n = 0;

                    do {
                        injectionManager.delete();
                        System.out.println("Do you want to continue to remove to a dish? ");
                        System.out.println("choice 1 if you want to continue or 2 if you want to exit");
                        System.out.print("Your choice: ");
                        n = tool.getInt(1, 2, "input n is 1 or 2");
                        if (n == 2) {
                            break;
                        }
                    } while (true);
                    break;
                }
                case 5: {
                    int n = 0;
                    String id;

                    do {
                        studentManager.print();
                        id = tool.inputString("input id ", "input id ").toUpperCase();
                        injectionManager.searchInjectionByStudentID(id);
                        System.out.println("Do you want to continue to remove to a dish? ");
                        System.out.println("choice 1 if you want to continue or 2 if you want to exit");
                        System.out.print("Your choice: ");
                        n = tool.getInt(1, 2, "input n is 1 or 2");
                        if (n == 2) {
                            break;
                        }
                    } while (true);
                    break;
                }
                case 6: {
                    injectionManager.writeFile(file);
                    System.out.println("UPDATED INTO FILE");
                    break;
                }
                case 7: {
                    String id;
                    vaccineManager.print();
                    id = tool.inputString("input id you want to search", "input id ");
                    injectionManager.searchInjectionByVaccineID(id);
                    break;
                }
                case 8: {
                    int n = 0;

                    System.out.println("Do you want to exit program? ");
                    System.out.println("'Yes' Enter number 1 | 'No' Enter number 2");
                    n = tool.getInt(1, 2, "input n is 1 or 2");
                    System.out.println(n);
                    if (n == 1) {
                        System.out.println("bye bye, see you the next time");
                        break;
                    }
                    choice = 1;
                }
                default:
                    System.out.println("please choose 1..5");
                    break;
            }
        } while (choice != 8);
    }

}
