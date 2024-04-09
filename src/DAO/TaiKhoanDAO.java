/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {
    
    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }
    
    public TaiKhoanDTO selectByUserName(String t) {
        TaiKhoanDTO result = null;
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM taikhoan WHERE tenTaiKhoan=?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idNhanVien = rs.getInt("nhanVien_id");
                int idQuyen = rs.getInt("quyen_id");
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
                int trangThai = rs.getInt("trangThai");
                TaiKhoanDTO tk = new TaiKhoanDTO(id, idNhanVien, idQuyen, tenTaiKhoan, matKhau, trangThai);
                result = tk;
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
