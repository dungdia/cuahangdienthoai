/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
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
public class KhachHangDAO {
    
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM khachhang WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String ho = rs.getString("ho");
                String ten = rs.getString("ten");
                String sdt = rs.getString("soDienThoai");
                Timestamp ngayThamGia = rs.getTimestamp("ngayThamGia");
                int trangThai = rs.getInt("trangThai");
                KhachHangDTO kh = new KhachHangDTO(id, ho, ten, sdt, ngayThamGia, trangThai);
                result.add(kh);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
