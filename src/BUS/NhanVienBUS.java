/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author DVN
 */
public class NhanVienBUS {
    private final NhanVienDAO nvDAO = new NhanVienDAO();
    public ArrayList<NhanVienDTO> nhanVienList = new ArrayList<>();
    
    public NhanVienBUS(){
        nhanVienList = nvDAO.selectAll();
    }
    
    public ArrayList<NhanVienDTO> getAll(){
        return this.nhanVienList;
    }
    
    public void printAll(){
        for(int i = 0; i < nhanVienList.size(); i++){
            System.out.println(nhanVienList.get(i));
        }
    }
}
