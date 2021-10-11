/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Vinh
 */
public class MenuManagnments {
    Tool tool = new Tool();
    public void printMenu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" Welcome to Vaccine Management - @ 2021 by SE150131 - Nguyễn Quốc Vinh");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|  STT  |         Select the options below                               |");                     
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|   1   |         Show information all students have been injected       |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   2   |         Add student's vaccine injection information            |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   3   |         Updating information of students' vaccine injection    |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   4   |         Delete student vaccine injection information           |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   5   |         Search for injection information                       |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   6   |         Save to file                                           |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   7   |         search by vaccine ID                                   |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|   8   |         Quit                                                   |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("your choice: ");
    }
    public void printConfirmMenu(String msg) {
        System.out.println(msg);
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
    public int getUserChoice() {
        int choice = tool.getInt(1, 2, " ");
        return choice;
    }
}
