/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TaiKhoanBUS {
    public TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private ArrayList<TaiKhoanDTO> tkList = new ArrayList<>();
    
    public TaiKhoanBUS() {
        tkList = tkDAO.selectAll();
    }
    
    public ArrayList<TaiKhoanDTO> getAll() {
        return this.tkList;
    }
}
