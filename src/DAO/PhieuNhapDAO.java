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
import java.util.Date;

/**
 *
 * @author Admin
 */
public class PhieuNhapDAO {
    
    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    
    public ArrayList<PhieuNhapDTO> getAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<PhieuNhapDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM phieunhap WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idNhaCungCap = rs.getInt("nhaCungCap_id");
                int idNhanVien = rs.getInt("nhanVien_id");
                Date ngayNhap = rs.getDate("ngayNhap");
                int tongTien = rs.getInt("tongTien");
                PhieuNhapDTO sp = new PhieuNhapDTO(id, idNhaCungCap, idNhanVien, ngayNhap, tongTien);
                result.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
