/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhienBanSanPhamDAO;
import DAO.SanPhamDAO;
import DTO.PhienBanSanPhamDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamBUS {

    public SanPhamDAO spDAO = new SanPhamDAO();
    private PhienBanSanPhamDAO pbspDAO = new PhienBanSanPhamDAO();
    public ArrayList<SanPhamDTO> sanPhamList = new ArrayList<SanPhamDTO>();
    
    public SanPhamBUS() {
        sanPhamList = spDAO.selectAll();
    }
    
    public ArrayList<SanPhamDTO> getAll() {
        return this.sanPhamList;
    }
    
    public int getLength() {
        return this.sanPhamList.size();
    }
    
    public boolean addNewSP(SanPhamDTO sp) {
        if(spDAO.insert(sp) != 0) {
            sanPhamList.add(sp);
            return true;
        }
        return false;
    }
    
    public boolean addNewSPWithPBSP(SanPhamDTO sp, PhienBanSanPhamDTO pbsp) {
        if(spDAO.insert(sp) != 0) {
            sanPhamList.add(sp);
            pbspDAO.insert(pbsp);
            return true;
        }
        return false;
    }
    
    public ArrayList<SanPhamDTO> search(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<SanPhamDTO>();
        text.toLowerCase();
        for(SanPhamDTO i : sanPhamList) {
            if(Integer.toString(i.getId()).toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text) || Float.toString(i.getKichThuocMan()).toLowerCase().contains(text) || i.getCameraSau().toLowerCase().contains(text) || i.getCameraTruoc().toLowerCase().contains(text) || i.getChipXuLy().toLowerCase().contains(text) || i.getHeDieuHanh().toLowerCase().contains(text) || Integer.toString(i.getDungLuongPin()).toLowerCase().contains(text))
                result.add(i);
        }
        return result;
    }
}
