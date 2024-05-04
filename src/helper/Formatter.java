/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class Formatter {
    public static String FormatVND(int vnd) {
        return String.format(Locale.US, "%,d", vnd) + "đ";
    }
    
    public static String FormatDateTime(Timestamp thoigian) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatDate.format(thoigian);
    }
}
