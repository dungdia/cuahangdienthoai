/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTPhieuNhapDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CTPhieuNhapDAO {
    
    public static CTPhieuNhapDAO getInstance() {
        return new CTPhieuNhapDAO();
    }
    
    public ArrayList<CTPhieuNhapDTO> selectAll() {
        ArrayList<CTPhieuNhapDTO> result = new ArrayList<CTPhieuNhapDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctphieunhap";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int idPhieuNhap = rs.getInt("phieuNhap_id");
                int idPBSP = rs.getInt("pbsanPham_id");
                int soLuong = rs.getInt("soLuong");
                int donGia = rs.getInt("donGia");
                int tongTien = rs.getInt("tongTien");
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO(idPhieuNhap, idPBSP, soLuong, donGia, tongTien);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public ArrayList<CTPhieuNhapDTO> selectAllByID(int pnId) {
        ArrayList<CTPhieuNhapDTO> result = new ArrayList<CTPhieuNhapDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctphieunhap WHERE phieuNhap_id="+pnId;
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int idPhieuNhap = rs.getInt("phieuNhap_id");
                int idPBSP = rs.getInt("pbsanPham_id");
                int soLuong = rs.getInt("soLuong");
                int donGia = rs.getInt("donGia");
                int tongTien = rs.getInt("tongTien");
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO(idPhieuNhap, idPBSP, soLuong, donGia, tongTien);
                result.add(ctpn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
