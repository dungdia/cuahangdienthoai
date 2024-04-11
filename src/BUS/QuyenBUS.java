/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.QuyenDAO;
import DTO.QuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QuyenBUS {
    public QuyenDAO qDAO = new QuyenDAO();
    private ArrayList<QuyenDTO> quyenList = new ArrayList<>();
    
    public QuyenBUS() {
        quyenList = qDAO.selectAll();
    }
    
    public ArrayList<QuyenDTO> getAll() {
        return this.quyenList;
    }
    
    public int getIndexById(int id) {
        for(int i=0; i<quyenList.size(); i++) {
            if(quyenList.get(i).getId() == id)
                return i;
        }
        return -1;
    }
    
    public String getNameById(int id) {
        return quyenList.get(getIndexById(id)).getTen();
    }
}
