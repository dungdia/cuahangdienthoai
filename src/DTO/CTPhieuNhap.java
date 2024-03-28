/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DVN
 */
public class CTPhieuNhap {
    private int idPhieuNhap;
    private int idSanPham;
    private int soLuong;
    private int donGia;
    private int tongTien;

    public CTPhieuNhap(int idPhieuNhap, int idSanPham, int soLuong, int donGia, int tongTien) {
        this.idPhieuNhap = idPhieuNhap;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}
