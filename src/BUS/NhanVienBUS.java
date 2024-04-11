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
    
    public int getIndexByID(int id) {
        for(int i=0; i<nhanVienList.size(); i++) {
            if(nhanVienList.get(i).getId() == id)
                return i;
        }
        return -1;
    }
    
    public String getNameByID(int id) {
        return nhanVienList.get(getIndexByID(id)).getHo() + " " +nhanVienList.get(getIndexByID(id)).getTen();
    }
    
    public boolean add(NhanVienDTO newNV) {
        if(nvDAO.insert(newNV) != 0) {
            nhanVienList.add(newNV);
            return true;
        }
        return false;
    }
    
    public boolean update(NhanVienDTO nv) {
        if(nvDAO.update(nv) != 0) {
            nhanVienList.set(getIndexByID(nv.getId()), nv);
            return true;
        }
        return false;
    }
    
    public boolean delete(NhanVienDTO nv) {
        if(nvDAO.delete(nv.getId()) != 0) {
            nhanVienList.remove(nv);
            return true;
        }
        return false;
    }
    
    public ArrayList<NhanVienDTO> search(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
        text = text.toLowerCase();
        for(NhanVienDTO i : nhanVienList) {
            if(Integer.toString(i.getId()).toLowerCase().contains(text) || i.getHo().toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text) || i.getGioiTinh().toLowerCase().contains(text) || i.getSoDienThoai().toLowerCase().contains(text) || i.getEmail().toLowerCase().contains(text))
               result.add(i);
        }
        return result;
    }
}
