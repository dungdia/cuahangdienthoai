/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTSanPhamDTO;
import DAO.PhienBanSanPhamDAO;
import java.sql.Connection;
import config.DBConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CTSanPhamDAO {
    
    public static CTSanPhamDAO getInstance() {
        return new CTSanPhamDAO();
    }
    
    public ArrayList<CTSanPhamDTO> getAll() {
        ArrayList<CTSanPhamDTO> result = new ArrayList<>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctsanpham WHERE trangThai=1";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String imei = rs.getString("imei");
                int idSanPham = rs.getInt("sanPham_id");
                int idPBSanPham = rs.getInt("pbSanPham_id");
                int idHoaDon = rs.getInt("hoaDon_id");
                int trangThai = rs.getInt("trangThai");
                CTSanPhamDTO ctsp = new CTSanPhamDTO(imei, idSanPham, idPBSanPham, idHoaDon, trangThai);
                result.add(ctsp);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public int insert(ArrayList<CTSanPhamDTO> ctspList) {
        int result = 0;
        for (int i = 0; i < ctspList.size(); i++) {
            try {
                Connection con = (Connection) DBConnector.getConnection();
                String sql = "INSERT INTO `ctsanpham`(`imei`, `sanPham_id`, `pbSanPham_id`, `hoaDon_id`) VALUES (?,?,?,?)";
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                pst.setString(1, ctspList.get(i).getImei());
                pst.setInt(2, ctspList.get(i).getIdSanPham());
                pst.setInt(3, ctspList.get(i).getIdPBSanPham());
                pst.setInt(4, ctspList.get(i).getIdHoaDon());
                result = pst.executeUpdate();
                PhienBanSanPhamDAO.getInstance().giamSoLuong(ctspList.get(i).getIdPBSanPham(), 1);
                DBConnector.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(CTPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return result;
    }
    
    public int deleteByHDId(int hdId) {
        int result = 0;
        try {
            Connection con = (Connection) DBConnector.getConnection();
            String sql = "DELETE FROM `ctsanpham` WHERE hoaDon_id = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, hdId);
            result = pst.executeUpdate();
            DBConnector.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public ArrayList<CTSanPhamDTO> selectAllByID(int hdId) {
        ArrayList<CTSanPhamDTO> result = new ArrayList<>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctsanpham WHERE hoaDon_id="+hdId;
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String imei = rs.getString("imei");
                int idSanPham = rs.getInt("sanPham_id");
                int idPBSanPham = rs.getInt("pbSanPham_id");
                int idHoaDon = rs.getInt("hoaDon_id");
                int trangThai = rs.getInt("trangThai");
                CTSanPhamDTO ctsp = new CTSanPhamDTO(imei, idSanPham, idPBSanPham, idHoaDon, trangThai);
                result.add(ctsp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
