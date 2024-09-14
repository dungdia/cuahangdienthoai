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
import DTO.KhachHangDTO;
import helper.Formatter;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class HoaDonBUS {
    private KhachHangBUS khBUS = new KhachHangBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
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
    
    public long getTotalMoney() {
        long result = 0;
        for(HoaDonDTO i : hdDAO.selectAll()) {
            result += i.getTongTien();
        }
        return result;
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
            ctspDAO.setTrangThaiTo0(ctsp);
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
    
    public ArrayList<HoaDonDTO> search (String text, String type){
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        text = text.toLowerCase();
        switch (type) {
            case "Tất cả":
                for(HoaDonDTO i : hoaDonList){
                    if(Integer.toString(i.getId()).toLowerCase().contains(text) || khBUS.getNameById(i.getIdKhachHang()).toLowerCase().contains(text) || nvBUS.getNameByID(i.getIdNhanVien()).toLowerCase().contains(text) || /*Khuyến mãi quăng vào đây*/ Formatter.FormatVND(i.getTongTien()).contains(text) || Formatter.FormatDateTime(i.getNgayXuat()).contains(text))
                        result.add(i);
                }
                break;
            case "Mã":
                for(HoaDonDTO i : hoaDonList){
                    if(Integer.toString(i.getId()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Khách hàng":
                for(HoaDonDTO i : hoaDonList){
                    if(khBUS.getNameById(i.getIdKhachHang()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Nhân viên":
                for(HoaDonDTO i : hoaDonList){
                    if(nvBUS.getNameByID(i.getIdNhanVien()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Khuyến mãi":
                // quăng khuyến mãi vào đây
                break;
            case "Tổng tiền":
                for(HoaDonDTO i : hoaDonList){
                    if(Formatter.FormatVND(i.getTongTien()).contains(text))
                        result.add(i);
                }
                break;
            case "Ngày xuất":
                for(HoaDonDTO i : hoaDonList){
                    if(Formatter.FormatDateTime(i.getNgayXuat()).contains(text))
                        result.add(i);
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
}
