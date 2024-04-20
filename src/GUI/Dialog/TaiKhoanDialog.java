/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.NhanVienBUS;
import BUS.QuyenBUS;
import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
import DTO.QuyenDTO;
import DTO.TaiKhoanDTO;
import GUI.Panel.TaiKhoan;
import helper.Validator;
import javax.swing.JOptionPane;

/**
 *
 * @author DVN
 */
public class TaiKhoanDialog extends javax.swing.JDialog {
    
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private NhanVienDTO nhanVien;
    private QuyenBUS qBUS = new QuyenBUS();
    private QuyenDTO quyen;
    private TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    private TaiKhoanDTO taiKhoan;
    private TaiKhoanDTO newTaiKhoan;
    private String mode;
    private TaiKhoan tkPanel;
    /**
     * Creates new form TaiKhoanDialog
     */
    public TaiKhoanDialog(java.awt.Frame parent, boolean modal, TaiKhoan tkPanel, TaiKhoanDTO taiKhoan, String mode) {
        super(parent, modal);
        this.tkPanel = tkPanel;
        this.taiKhoan = taiKhoan;
        this.mode = mode;
        initComponents();
        initComponentsCustom();
    }
    
    public void initComponentsCustom(){
        this.setLocationRelativeTo(null);
        if(mode.equals("detail"))
            initDetailMode();
        if(mode.equals("add"))
            initAddMode();
        if(mode.equals("edit"))
            initEditMode();
    }
    
    public void initDetailMode(){
        header.setText("Chi tiết tài khoản");
        addTaiKhoanBtn.setVisible(false);
        txtTenTaiKhoan.setText(this.taiKhoan.getTenTaiKhoan());
        txtTenTaiKhoan.setFocusable(false);
        txtMatKhau.setText(this.taiKhoan.getMatKhau());
        txtMatKhau.setFocusable(false);
        txtTenNhanVien.setText(this.nvBUS.getNameByID(this.taiKhoan.getIdNhanVien()));
        txtTenNhanVien.setFocusable(false);
        txtQuyen.setText(this.qBUS.getNameById(this.taiKhoan.getIdQuyen()));
        txtQuyen.setFocusable(false);
    }
    
    public void initAddMode(){
        header.setText("Thêm tài khoản mới");
        addTaiKhoanBtn.setText("Thêm tài khoản");
    }
    
    public void initEditMode(){
        header.setText("Sửa thông tin tài khoản");
        addTaiKhoanBtn.setText("Lưu thông tin");
        txtTenTaiKhoan.setText(this.taiKhoan.getTenTaiKhoan());
        txtMatKhau.setText(this.taiKhoan.getMatKhau());
        txtTenNhanVien.setText(this.nvBUS.getNameByID(this.taiKhoan.getIdNhanVien()));
        txtQuyen.setText(this.qBUS.getNameById(this.taiKhoan.getIdQuyen()));
    }
    
    public boolean ValidateInput(){
        if(Validator.isEmpty(txtTenTaiKhoan.getText())){
            JOptionPane.showMessageDialog(this, "Ban chưa nhập tên tài khoản");
            return false;
        }
        if(Validator.isEmpty(txtMatKhau.getText())){
            JOptionPane.showMessageDialog(this, "Ban chưa nhập mật khẩu tài khoản");
            return false;
        }
        if(Validator.isEmpty(txtTenNhanVien.getText())){
            JOptionPane.showMessageDialog(this, "Ban chưa nhập tên nhân viên của tài khoản");
            return false;
        }
        return true;
    }
    
    public boolean ValidateDuplication(){
        for(TaiKhoanDTO i : tkBUS.getAll()){
            if(i.getTenTaiKhoan().equals(txtTenNhanVien.getText()) && nvBUS.getNameByID(i.getIdNhanVien()).equals(txtTenNhanVien.getText())){
                JOptionPane.showMessageDialog(this, "Tên tài khoản hoặc tên nhân viên đã tồn tại!");
                return false;
            }
        }
        return true;
    }
    
    public int getIdNvByName (String name){
        int result = -1;
        for(NhanVienDTO i : nvBUS.getAll()){
            if(i.getTen().equals(name))
                result = i.getId();
        }
        return result;
    }
    
    public int getIdQuyenByName (String name){
        int result = -1;
        for(QuyenDTO i : qBUS.getAll()){
            if(i.getTen().equals(name))
                result = i.getId();
        }
        return result;
    }
 
    public TaiKhoanDTO getNewTK(){
        String tenTk = txtTenTaiKhoan.getText();
        String matKhau = txtMatKhau.getText();
        int idQuyen = getIdQuyenByName(txtQuyen.getText());
        int idNhanVien = getIdNvByName(txtTenNhanVien.getText());
        return new TaiKhoanDTO(tkDAO.getAutoIncrement(), idNhanVien, idQuyen, tenTk, matKhau, 1);
    }
    
    public void setEditedTK(){
        taiKhoan.setTenTaiKhoan(txtTenTaiKhoan.getText());
        taiKhoan.setMatKhau(txtMatKhau.getText());
        taiKhoan.setIdNhanVien(getIdNvByName(txtTenNhanVien.getText()));
        taiKhoan.setIdQuyen(getIdQuyenByName(txtQuyen.getText()));
    }
    
    public void addEvent(){
        if(!ValidateInput())
            return;
        if(!ValidateDuplication())
            return;
        newTaiKhoan = getNewTK();
        if(tkPanel.tkBUS.add(newTaiKhoan)){
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thanh công!");
            tkPanel.loadDataToTable(tkPanel.tkList);
            dispose();
        }
    }
    
    public void editEvent(){
        if(!ValidateInput())
            return;
        setEditedTK();
        if(tkPanel.tkBUS.update(taiKhoan)){
            JOptionPane.showMessageDialog(this, "Sửa thông tin tài khoản thành công!");
            tkPanel.loadDataToTable(tkPanel.tkList);
            dispose();
        }
    }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTenTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuyen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        addTaiKhoanBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(88, 175, 232));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 50));

        header.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Tài Khoản Dialog");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Tên tài khoản");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Tên nhân viên");

        jLabel5.setText("Quyền");

        cancelBtn.setBackground(new java.awt.Color(255, 107, 107));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelBtnMousePressed(evt);
            }
        });

        addTaiKhoanBtn.setBackground(new java.awt.Color(78, 205, 196));
        addTaiKhoanBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addTaiKhoanBtn.setForeground(new java.awt.Color(255, 255, 255));
        addTaiKhoanBtn.setText("Thêm tài khoản");
        addTaiKhoanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addTaiKhoanBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtQuyen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenNhanVien)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMatKhau)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addTaiKhoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTaiKhoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelBtnMousePressed

    private void addTaiKhoanBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTaiKhoanBtnMousePressed
        // TODO add your handling code here:
        if(mode.equals("add"))
            addEvent();
        if(mode.equals("edit"))
            editEvent();
    }//GEN-LAST:event_addTaiKhoanBtnMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaiKhoanBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtQuyen;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
