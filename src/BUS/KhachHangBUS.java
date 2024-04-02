/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KhachHangBUS {
    private final KhachHangDAO khDAO = new KhachHangDAO();
    public ArrayList<KhachHangDTO> khachHangList = new ArrayList<>();
    
    public KhachHangBUS(){
        khachHangList = khDAO.selectAll();
    }
    
    public ArrayList<KhachHangDTO> getAll() {
        return this.khachHangList;
    }
    
    public void printAll() {
        for(int i=0; i< khachHangList.size(); i++) {
            System.out.println(khachHangList.get(i));
        }
    }
}
