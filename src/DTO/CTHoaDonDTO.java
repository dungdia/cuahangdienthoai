/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DVN
 */
public class CTHoaDonDTO {
    private int idHoaDon;
    private int idPBSanPham;
    private int soLuong;
    private int giaBanRa;
    private int tongTien;

    public CTHoaDonDTO(int idHoaDon, int idPBSanPham, int soLuong, int giaBanRa, int tongTien) {
        this.idHoaDon = idHoaDon;
        this.idPBSanPham = idPBSanPham;
        this.soLuong = soLuong;
        this.giaBanRa = giaBanRa;
        this.tongTien = tongTien;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdPBSanPham() {
        return idPBSanPham;
    }

    public void setIdPBSanPham(int idPBSanPham) {
        this.idPBSanPham = idPBSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaBanRa() {
        return giaBanRa;
    }

    public void setGiaBanRa(int giaBanRa) {
        this.giaBanRa = giaBanRa;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    
}
