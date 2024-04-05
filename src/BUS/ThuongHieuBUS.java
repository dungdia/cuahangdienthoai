/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieuDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThuongHieuBUS {
    private final ThuongHieuDAO thDAO = new ThuongHieuDAO();
    public ArrayList<ThuongHieuDTO> thuongHieuList = new ArrayList<ThuongHieuDTO>();
    
    public ThuongHieuBUS(){
        thuongHieuList = thDAO.selectAll();
    }
    
    public ArrayList<ThuongHieuDTO> getAll(){
        return this.thuongHieuList;
    }
}
