/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    public ArrayList<PhieuNhapDTO> phieuNhapList = new ArrayList<>();
    
    public PhieuNhapBUS() {
        this.phieuNhapList = pnDAO.selectAll();
    }
    
    public ArrayList<PhieuNhapDTO> getAll(){ 
        return this.phieuNhapList;
    }
}
