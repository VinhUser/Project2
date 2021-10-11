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
public class CheckTool {
    
    //check min max for integer
    public static boolean maxMinInt(int number, int max, int min) {
        return number <= max && number >= min;
    }

    public static boolean maxMinDouble(double number, double max, double min) {
        return number <= max && number >= min;
    }
}
