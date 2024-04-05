/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamDAO {
    
    public ArrayList<SanPhamDTO> selectAll() {
        ArrayList<SanPhamDTO> result = new ArrayList<SanPhamDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM sanpham WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String hinhAnh = rs.getString("hinhAnh");
                String kichThuocMan = rs.getString("kichThuocMan");
                String cameraSau = rs.getString("cameraSau");
                String cameraTruoc = rs.getString("cameraTruoc");
                String chipXuLy = rs.getString("chipXuLy");
                String heDieuHanh = rs.getString("heDieuHanh");
                String dungLuongPin = rs.getString("dungLuongPin");
                int thuongHieu_id = rs.getInt("thuongHieu_id");
                int trangThai = rs.getInt("trangThai");
                SanPhamDTO sp = new SanPhamDTO(id, ten, hinhAnh, kichThuocMan, cameraSau, cameraTruoc, chipXuLy, heDieuHanh, dungLuongPin, thuongHieu_id, trangThai);
                result.add(sp);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
