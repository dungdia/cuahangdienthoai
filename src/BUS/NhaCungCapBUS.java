/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhaCungCapBUS {
    private final NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> nhaCungCapList = new ArrayList<NhaCungCapDTO>();

    public NhaCungCapBUS() {
        nhaCungCapList = nccDAO.getAll();
    }

    public ArrayList<NhaCungCapDTO> getAll() {
        return this.nhaCungCapList;
    }

    public NhaCungCapDTO getByIndex(int index) {
        return this.nhaCungCapList.get(index);
    }

    public int getIndexByID(int id) {
        for (int i = 0; i < nhaCungCapList.size(); i++) {
            if (nhaCungCapList.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public String getNameByID(int id) {
        return nhaCungCapList.get(getIndexByID(id)).getTen();
    }

    public ArrayList<NhaCungCapDTO> search(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        text = text.toLowerCase();
        for (NhaCungCapDTO i : nhaCungCapList) {
            if (Integer.toString(i.getId()).toLowerCase().contains(text) || i.getTen().toLowerCase().contains(text)
                    || i.getDiaChi().toLowerCase().contains(text) || i.getSoDienThoai().toLowerCase().contains(text)
                    || i.getEmail().toLowerCase().contains(text))
                result.add(i);
        }
        return result;
    }

    public boolean add(NhaCungCapDTO newNCC) {
        if (nccDAO.insert(newNCC) != 0) {
            nhaCungCapList.add(newNCC);
            return true;
        }
        return false;
    }

    public boolean update(NhaCungCapDTO ncc) {
        if (nccDAO.update(ncc) != 0) {
            nhaCungCapList.set(getIndexByID(ncc.getId()), ncc);
            return true;
        }
        return false;
    }

    public boolean delete(NhaCungCapDTO ncc) {
        if (nccDAO.delete(ncc.getId()) != 0) {
            nhaCungCapList.remove(ncc);
            return true;
        }
        return false;
    }

    public ArrayList<NhaCungCapDTO> search(String text, String type) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<NhaCungCapDTO>();
        text = text.toLowerCase();
        switch (type) {
            case "Tất cả":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (Integer.toString(i.getId()).toLowerCase().contains(text)
                            || i.getTen().toLowerCase().contains(text) || i.getDiaChi().toLowerCase().contains(text)
                            || i.getSoDienThoai().toLowerCase().contains(text)
                            || i.getEmail().toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            case "Mã":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (Integer.toString(i.getId()).toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            case "Tên":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (i.getTen().toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            case "Địa chỉ":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (i.getDiaChi().toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            case "Số điện thoại":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (i.getSoDienThoai().toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            case "Email":
                for (NhaCungCapDTO i : nhaCungCapList) {
                    if (i.getEmail().toLowerCase().contains(text)) {
                        result.add(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
}
