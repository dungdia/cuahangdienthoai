/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhaCungCapBUS {
    private final NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> nhaCungCapList = new ArrayList<NhaCungCapDTO>();
    
    public NhaCungCapBUS() {
        nhaCungCapList = nccDAO.getAll();
    }
    
    public ArrayList<NhaCungCapDTO> getAll() {
        return this.nhaCungCapList;
    }
    
    public ArrayList<NhaCungCapDTO> search(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<NhaCungCapDTO>();
        text.toLowerCase();
        for(NhaCungCapDTO i : nhaCungCapList) {
            if(Integer.toString(i.getId()).toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text) || i.getDiaChi().toLowerCase().contains(text) || i.getSoDienThoai().toLowerCase().contains(text) || i.getEmail().toLowerCase().contains(text))
                result.add(i);
        }
        return result;
    }
}
