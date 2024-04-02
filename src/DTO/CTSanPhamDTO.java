/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class CTSanPhamDTO {
    private int imei;
    private int idSanPham;
    private int idPBSanPham;
    private int idPhieuNhap;
    private int idHoaDon;
    private int trangThai;

    public CTSanPhamDTO(int imei, int idSanPham, int idPBSanPham, int idPhieuNhap, int idHoaDon, int trangThai) {
        this.imei = imei;
        this.idSanPham = idSanPham;
        this.idPBSanPham = idPBSanPham;
        this.idPhieuNhap = idPhieuNhap;
        this.idHoaDon = idHoaDon;
        this.trangThai = trangThai;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdPBSanPham() {
        return idPBSanPham;
    }

    public void setIdPBSanPham(int idPBSanPham) {
        this.idPBSanPham = idPBSanPham;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
