/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CTQuyenDTO;
import config.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CTQuyenDAO {
    
    public static CTQuyenDAO getInstance() {
        return new CTQuyenDAO();
    }
    
    public ArrayList<CTQuyenDTO> selectAll() {
        ArrayList<CTQuyenDTO> result = new ArrayList<CTQuyenDTO>();
        try {
            Connection conn = (Connection) DBConnector.getConnection();
            String query = "SELECT * FROM ctquyen";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int idQuyen = rs.getInt("quyen_id");
                int idChucNang = rs.getInt("chucNang_id");
                String hanhDong =  rs.getString("hanhDong");
                CTQuyenDTO quyen = new CTQuyenDTO(idQuyen, idChucNang, hanhDong);
                result.add(quyen);
            }
            DBConnector.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
