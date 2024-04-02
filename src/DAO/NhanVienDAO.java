/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DVN
 */
public class NhanVienDAO {
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM nhanvien";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String ho = rs.getString("ho");
                String ten = rs.getNString("ten");
                String gioiTinh = rs.getString("gioitinh");
                String sdt = rs.getString("soDienThoai");
                String chucVu = rs.getString("chucVu");
                NhanVienDTO nv = new NhanVienDTO(id, ho, ten, gioiTinh, sdt, chucVu);
                result.add(nv);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}