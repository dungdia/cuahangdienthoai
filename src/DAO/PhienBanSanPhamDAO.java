/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhienBanSanPhamDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhienBanSanPhamDAO {
    public ArrayList<PhienBanSanPhamDTO> getAll() {
        ArrayList<PhienBanSanPhamDTO> result = new ArrayList<PhienBanSanPhamDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM pbsanpham WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int sanPham_id = rs.getInt("sanPham_id");
                int ram = rs.getInt("ram");
                int rom = rs.getInt("rom");
                String mau = rs.getString("mau");
                int soLuong = rs.getInt("soLuong");
                int giaNhap = rs.getInt("giaNhap");
                int giaXuat = rs.getInt("giaXuat");
                int trangThai = rs.getInt("trangThai");
                PhienBanSanPhamDTO sp = new PhienBanSanPhamDTO(id, sanPham_id, ram, rom, mau, soLuong, giaNhap, giaXuat, trangThai);
                result.add(sp);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public ArrayList<PhienBanSanPhamDTO> getAllPBSPBySPId(int spId) {
        ArrayList<PhienBanSanPhamDTO> result = new ArrayList<PhienBanSanPhamDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM pbsanpham WHERE trangThai=1 AND sanPham_id="+spId;
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int sanPham_id = rs.getInt("sanPham_id");
                int ram = rs.getInt("ram");
                int rom = rs.getInt("rom");
                String mau = rs.getString("mau");
                int soLuong = rs.getInt("soLuong");
                int giaNhap = rs.getInt("giaNhap");
                int giaXuat = rs.getInt("giaXuat");
                int trangThai = rs.getInt("trangThai");
                PhienBanSanPhamDTO sp = new PhienBanSanPhamDTO(id, sanPham_id, ram, rom, mau, soLuong, giaNhap, giaXuat, trangThai);
                result.add(sp);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
