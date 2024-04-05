/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author DVN
 */
public class NhanVienBUS {
    private final NhanVienDAO nvDAO = new NhanVienDAO();
    public ArrayList<NhanVienDTO> nhanVienList = new ArrayList<NhanVienDTO>();
    
    public NhanVienBUS(){
        nhanVienList = nvDAO.selectAll();
    }
    
    public ArrayList<NhanVienDTO> getAll(){
        return this.nhanVienList;
    }
    
    public ArrayList<NhanVienDTO> search(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
        text.toLowerCase();
        for(NhanVienDTO i : nhanVienList) {
            if(Integer.toString(i.getId()).toLowerCase().contains(text) || i.getHo().toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text) || i.getGioiTinh().toLowerCase().contains(text) || i.getSoDienThoai().toLowerCase().contains(text) || i.getEmail().toLowerCase().contains(text))
               result.add(i);
        }
        return result;
    }
}
