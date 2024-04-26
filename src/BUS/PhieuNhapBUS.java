/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
    public ArrayList<PhieuNhapDTO> phieuNhapList = new ArrayList<>();
    
    public PhieuNhapBUS() {
        this.phieuNhapList = pnDAO.selectAll();
    }
    
    public ArrayList<PhieuNhapDTO> getAll(){ 
        return this.phieuNhapList;
    }
    
    public boolean addNewPN(PhieuNhapDTO pn) {
        if(pnDAO.insert(pn) != 0) {
            phieuNhapList.add(pn);
            return true;
        }
        return false;
    }
    
    public boolean addNewPNWithCTPNList(PhieuNhapDTO pn, ArrayList<CTPhieuNhapDTO> ctpnList) {
        if(pnDAO.insert(pn) != 0) {
            phieuNhapList.add(pn);
            ctpnDAO.insert(ctpnList);
            return true;
        }
        return false;
    }
}
