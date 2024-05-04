/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.TaiKhoanDTO;
import GUI.Panel.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import config.DBConnector;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    public SideMenu sideMenu;
    public JPanel Content = new JPanel();
    public CardLayout cardLayout;
    public Home home;
    public SanPham sanPham;
    public PhieuNhap phieuNhap;
    public HoaDon hoaDon;
    public KhachHang khachHang;
    public NhanVien nhanVien;
    public NhaCungCap nhaCungCap;
    public PhanQuyen phanQuyen;
    public ThongKe thongKe;
    public TaiKhoan taiKhoan;
    private Color MainColor = new Color(255, 255, 255);
    private TaiKhoanDTO currentUser;
    
    /**
     * Creates new form Main
     */
    public Main(TaiKhoanDTO currentUser) {
        initComponents();
//        DBConnector.checkConnection();
        this.currentUser = currentUser;
        initComponentsCustom();
    }
    
    public TaiKhoanDTO getCurrentUser(){
        return this.currentUser;
    }
    
    public void initComponentsCustom() {
        home = new Home();
        sanPham = new SanPham(this, currentUser);
        phieuNhap = new PhieuNhap(this, currentUser);
        hoaDon = new HoaDon(this, currentUser);
        khachHang = new KhachHang(this, currentUser);
        nhanVien = new NhanVien(this, currentUser);
        nhaCungCap = new NhaCungCap(this, currentUser);
        phanQuyen = new PhanQuyen(this, currentUser);
        thongKe = new ThongKe();
        taiKhoan = new TaiKhoan(this, currentUser);
        this.setTitle("Cửa hàng điện thoại");
        this.setSize(new Dimension(1280, 720));
        this.setLayout(new BorderLayout(0, 0));
        
        sideMenu = new SideMenu(this, this.currentUser);
        getContentPane().add(sideMenu, BorderLayout.WEST);
        
        Content.setSize(new Dimension(1030, 720));
        Content.setBackground(MainColor);
        Content.setLayout(new CardLayout(0, 0));
        cardLayout = (CardLayout) Content.getLayout();
        Content.add(home, "home");
        Content.add(sanPham, "sanPham");
        Content.add(phieuNhap, "phieuNhap");
        Content.add(hoaDon, "hoaDon");
        Content.add(khachHang, "khachHang");
        Content.add(nhanVien, "nhanVien");
        Content.add(nhaCungCap, "nhaCungCap");
        Content.add(phanQuyen, "phanQuyen");
        Content.add(thongKe, "thongKe");
        Content.add(taiKhoan, "taiKhoan");
        getContentPane().add(Content, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
    }
    
    public void switchCard(String panelName) {
        cardLayout.show(Content, panelName);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatIntelliJLaf());        

        new Login().setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
