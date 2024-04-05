/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KhachHangBUS {
    private final KhachHangDAO khDAO = new KhachHangDAO();
    public ArrayList<KhachHangDTO> khachHangList = new ArrayList<>();
    
    public KhachHangBUS(){
        khachHangList = khDAO.selectAll();
    }
    
    public ArrayList<KhachHangDTO> getAll() {
        return this.khachHangList;
    }
    
    public ArrayList<KhachHangDTO> search(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
        text.toLowerCase();
        for(KhachHangDTO i : this.khachHangList) {
            if(Integer.toString(i.getId()).toLowerCase().contains(text) || i.getHo().toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text) || i.getDiaChi().toLowerCase().contains(text) || i.getSoDienThoai().toLowerCase().contains(text))
                result.add(i);
        }
        return result;
    }
}
