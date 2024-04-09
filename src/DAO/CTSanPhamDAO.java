/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTSanPhamDTO;
import java.sql.Connection;
import config.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CTSanPhamDAO {
    
    public static CTSanPhamDAO getInstance() {
        return new CTSanPhamDAO();
    }
    
    public ArrayList<CTSanPhamDTO> getAll() {
        ArrayList<CTSanPhamDTO> result = new ArrayList<CTSanPhamDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctsanpham WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String imei = rs.getString("imei");
                int idSanPham = rs.getInt("sanPham_id");
                int idPBSanPham = rs.getInt("pbSanPham_id");
                int idPhieuNhap = rs.getInt("phieuNhap_id");
                int idHoaDon = rs.getInt("hoaDon_id");
                int trangThai = rs.getInt("trangThai");
                CTSanPhamDTO ctsp = new CTSanPhamDTO(imei, idSanPham, idPBSanPham, idPhieuNhap, idHoaDon, trangThai);
                result.add(ctsp);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
