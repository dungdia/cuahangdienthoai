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
    
    public static NhanVienDAO getInstance() {
        return new NhanVienDAO();
    }
    
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
                String email = rs.getString("email");
                String chucVu = rs.getString("chucVu");
                int trangThai = rs.getInt("trangThai");
                NhanVienDTO nv = new NhanVienDTO(id, ho, ten, gioiTinh, sdt, email, chucVu, trangThai);
                result.add(nv);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public NhanVienDTO selectByAccountId(String t) {
        NhanVienDTO nv = null;
        try{
            Connection con = DBConnector.getConnection();
            String query = "SELECT * FROM taikhoan tk join nhanvien nv on tk.nhanVien_id=nv.id where tk.id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ho = rs.getString("ho");
                String ten = rs.getNString("ten");
                String gioiTinh = rs.getString("gioitinh");
                String sdt = rs.getString("soDienThoai");
                String email = rs.getString("email");
                String chucVu = rs.getString("chucVu");
                int trangThai = rs.getInt("trangThai");
                nv = new NhanVienDTO(id, ho, ten, gioiTinh, sdt, email, chucVu, trangThai);
            }
            DBConnector.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception           
        }
        return nv;
    }
}