/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class SanPhamDTO {
    private int id;
    private String ten;
    private String hinhAnh;
    private int idThuongHieu;
    private int trangThai;

    public SanPhamDTO(int id, String ten, String hinhAnh, int idThuongHieu, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.hinhAnh = hinhAnh;
        this.idThuongHieu = idThuongHieu;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void getId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
