/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.CTPhieuNhapDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import helper.Formatter;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public ArrayList<PhieuNhapDTO> phieuNhapList = new ArrayList<>();
    
    public PhieuNhapBUS() {
        this.phieuNhapList = pnDAO.selectAll();
    }
    
    public ArrayList<PhieuNhapDTO> getAll(){ 
        return this.phieuNhapList;
    }
    
    public long getTotalMoney() {
        long result = 0;
        for(PhieuNhapDTO i : pnDAO.selectAll()) {
            result += i.getTongTien();
        }
        return result;
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
    
    public ArrayList<PhieuNhapDTO> search(String text, String type){
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        text = text.toLowerCase();
        switch(type){
            case "Tất cả":
                for(PhieuNhapDTO i : phieuNhapList) {
                    if(Integer.toString(i.getId()).toLowerCase().contains(text) || nccBUS.getNameByID(i.getId()).toLowerCase().contains(text) || nvBUS.getNameByID(i.getId()).toLowerCase().contains(text) || Formatter.FormatDateTime(i.getNgayNhap()).contains(text) || Formatter.FormatVND(i.getTongTien()).contains(text))
                        result.add(i);
                }
                break;
            case "Mã":
                for(PhieuNhapDTO i : phieuNhapList){
                    if(Integer.toString(i.getId()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Nhà cung cấp":
                for(PhieuNhapDTO i : phieuNhapList){
                    if(nccBUS.getNameByID(i.getId()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Nhân viên nhập":
                for(PhieuNhapDTO i : phieuNhapList){
                    if(nvBUS.getNameByID(i.getId()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Ngày và giờ nhập":
                for(PhieuNhapDTO i : phieuNhapList){
                    if(Formatter.FormatDateTime(i.getNgayNhap()).contains(text))
                        result.add(i);
                }
                break;
            case "Tổng tiền":
                for(PhieuNhapDTO i : phieuNhapList){
                    if(Formatter.FormatVND(i.getTongTien()).contains(text))
                        result.add(i);
                }
                break;
             default:
                    throw new AssertionError();
        }
        return result;
    }
}
