/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class KhuyenMaiDTO {
    private int id;
    private int idPBSanPham;
    private float tiLe;
    private int dieuKien;

    public KhuyenMaiDTO(int id, int idPBSanPham, float tiLe, int dieuKien) {
        this.id = id;
        this.idPBSanPham = idPBSanPham;
        this.tiLe = tiLe;
        this.dieuKien = dieuKien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPBSanPham() {
        return idPBSanPham;
    }

    public void setIdPBSanPham(int idPBSanPham) {
        this.idPBSanPham = idPBSanPham;
    }

    public float getTiLe() {
        return tiLe;
    }

    public void setTiLe(float tiLe) {
        this.tiLe = tiLe;
    }

    public int getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(int dieuKien) {
        this.dieuKien = dieuKien;
    }
    
    
}
