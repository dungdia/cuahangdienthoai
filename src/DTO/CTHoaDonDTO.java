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
    private String imei;
    private int soLuong;
    private int giaBanRa;
    private int tongTien;

    public CTHoaDonDTO(int idHoaDon, String imei,int soLuong, int giaBanRa, int tongTien) {
        this.idHoaDon = idHoaDon;
        this.imei = imei;
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
    
    public String getImeiSanPham() {
        return imei;
    }

    public void setImeiPBSanPham(String imei) {
        this.imei = imei;
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
