/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

/**
 *
 * @author Admin
 */
public class Validator {
    
    public static boolean isEmpty(String input) {
        if(input == null)
            return true;
        return input.equals("");
    }
    
    public static boolean isInteger(String num) {
        if (num == null) return false;
        try {
            if(Integer.valueOf(num) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isFloat(String num) {
        if (num == null) return false;
        try {
            if(Float.valueOf(num) < 0)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
