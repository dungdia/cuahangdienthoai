/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.CTSanPhamDAO;
import DAO.CTBaoHanhDAO;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.CTSanPhamDTO;
import DTO.CTBaoHanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class HoaDonBUS {
    private HoaDonDAO hdDAO = new HoaDonDAO();
    private CTBaoHanhDAO ctbhDAO = new CTBaoHanhDAO();
    private CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    private CTSanPhamDAO ctspDAO = new CTSanPhamDAO();
    public ArrayList<HoaDonDTO> hoaDonList = new ArrayList<>();
    
    public HoaDonBUS() {
        this.hoaDonList = hdDAO.selectAll();
    }
    
    
    public ArrayList<HoaDonDTO> getAll(){ 
        return this.hoaDonList;
    }
    
    public HoaDonDTO getByID(int id) {
        for(HoaDonDTO i : this.hoaDonList) {
            if(i.getId() == id)
                return i;
        }
        return null;
    }
    
    public boolean addNewHd(HoaDonDTO hd) {
        if(hdDAO.insert(hd) != 0) {
            hoaDonList.add(hd);
            return true;
        }
        return false;
    }
    
    public boolean addNewHDWithCTHDList(HoaDonDTO hd, ArrayList<CTHoaDonDTO> cthdList,ArrayList<CTSanPhamDTO> ctsp,ArrayList<CTBaoHanhDTO> ctbh) {
        if(hdDAO.insert(hd) != 0) {
            hoaDonList.add(hd);
            ctspDAO.insert(ctsp);
            cthdDAO.insert(cthdList);
            ctbhDAO.insert(ctbh);
            return true;
        }
        return false;
    }
    
    public boolean delete(HoaDonDTO hd) {
        if (ctbhDAO.deleteByHDId(hd.getId()) != 0)
            if(cthdDAO.deleteByHDId(hd.getId()) != 0)
                if(ctspDAO.deleteByHDId(hd.getId()) != 0)
                    if(hdDAO.delete(hd.getId()) != 0) {
                        hoaDonList.remove(hd);
                        return true;
                    }
        return false;
    }
    
    public int getAutoIncrement(){
        return hdDAO.getAutoIncrement();
    }
}
