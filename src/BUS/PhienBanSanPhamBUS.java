/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhienBanSanPhamDAO;
import DTO.PhienBanSanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhienBanSanPhamBUS {
    private final PhienBanSanPhamDAO pbspDAO = new PhienBanSanPhamDAO();
    private ArrayList<PhienBanSanPhamDTO> pbSPList = new ArrayList<PhienBanSanPhamDTO>();
    
    public PhienBanSanPhamBUS() {
//        pbSPList = pbspDAO.getAll();
    }
    
    public ArrayList<PhienBanSanPhamDTO> getAll() {
        return this.pbSPList;
    }
    
    public ArrayList<PhienBanSanPhamDTO> getAllPBSPBySPId(int spId) {
        return pbspDAO.getAllPBSPBySPId(spId);
    }
}
