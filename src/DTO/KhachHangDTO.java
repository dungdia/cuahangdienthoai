/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DVN
 */
public class KhachHangDTO {
    private int id;
    private String ho;
    private String ten;
    private String diaChi;
    private String soDienThoai;

    public KhachHangDTO(int id, String ho, String ten, String diaChi, String soDienThoai) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "id=" + id + ", ho=" + ho + ", ten=" + ten + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + '}';
    }
    
}
