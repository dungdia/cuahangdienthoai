/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuNhapDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class PhieuNhapDAO {
    
    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    
    public ArrayList<PhieuNhapDTO> selectAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<PhieuNhapDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM phieunhap";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idNhaCungCap = rs.getInt("nhaCungCap_id");
                int idNhanVien = rs.getInt("nhanVien_id");
                Timestamp ngayNhap = rs.getTimestamp("ngayNhap");
                int tongTien = rs.getInt("tongTien");
                PhieuNhapDTO pn = new PhieuNhapDTO(id, idNhaCungCap, idNhanVien, ngayNhap, tongTien);
                result.add(pn);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
