/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamBUS {

    private final SanPhamDAO spDAO = new SanPhamDAO();
    public ArrayList<SanPhamDTO> sanPhamList = new ArrayList<SanPhamDTO>();
    
    public SanPhamBUS() {
        sanPhamList = spDAO.selectAll();
    }
    
    public ArrayList<SanPhamDTO> getAll() {
        return this.sanPhamList;
    }
    
    public ArrayList<SanPhamDTO> search(String text) {
        ArrayList<SanPhamDTO> result = new ArrayList<SanPhamDTO>();
        text.toLowerCase();
        for(SanPhamDTO i : sanPhamList) {
            if(Integer.toString(i.getId()).contains(text) || i.getTen().toLowerCase().contains(text) || i.getKichThuocMan().toLowerCase().contains(text) || i.getCameraSau().toLowerCase().contains(text) || i.getCameraTruoc().toLowerCase().contains(text) || i.getChipXuLy().toLowerCase().contains(text) || i.getHeDieuHanh().toLowerCase().contains(text) || i.getDungLuongPin().toLowerCase().contains(text))
                result.add(i);
        }
        return result;
    }
}
