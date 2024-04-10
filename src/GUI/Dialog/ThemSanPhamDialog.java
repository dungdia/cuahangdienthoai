/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.PhienBanSanPhamBUS;
import BUS.SanPhamBUS;
import BUS.ThuongHieuBUS;
import DAO.PhienBanSanPhamDAO;
import DTO.PhienBanSanPhamDTO;
import DTO.SanPhamDTO;
import DTO.ThuongHieuDTO;
import GUI.Panel.SanPham;
import helper.Validator;
import java.awt.CardLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author DVN
 */


public class ThemSanPhamDialog extends javax.swing.JDialog {

    private CardLayout cardLayout;
    private String imageURL;
    private SanPhamBUS spBUS = new SanPhamBUS();
    private PhienBanSanPhamBUS pbspBUS = new PhienBanSanPhamBUS();
    private ThuongHieuBUS thBUS = new ThuongHieuBUS();
    private ArrayList<ThuongHieuDTO> thList = thBUS.getAll();
    SanPham panelSanPham;
    int newSPID;
    int newPBSPID;
    
    /**
     * Creates new form ThemSanPhamDialog
     */
    public ThemSanPhamDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public ThemSanPhamDialog(java.awt.Frame parent, boolean modal, String title, SanPham panelSanPham) {
        super(parent, modal);
        this.setTitle(title);
        this.panelSanPham = panelSanPham;
        initComponents();
        initComponentsCustom();
        this.setLocationRelativeTo(null);   
    }

    public void initComponentsCustom() {
        newSPID = panelSanPham.spBUS.spDAO.getAutoIncrement();
        newPBSPID = PhienBanSanPhamDAO.getInstance().getAutoIncrement();
        cardLayout = (CardLayout) contentPanel.getLayout();
        imgUploadBtn.addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                JFileChooser jfc;
                jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF images", "png", "gif", "jpg", "jpeg");
                jfc.addChoosableFileFilter(filter);
                int returnValue = jfc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    System.out.println(jfc.getSelectedFile().getPath());
                    imageURL = (String) jfc.getSelectedFile().getPath();
                    File file = jfc.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(new javax.swing.ImageIcon(String.valueOf(jfc.getSelectedFile())).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
                    BufferedImage b;
                    try {
                        b = ImageIO.read(file);
                        hinhAnhSP.setIcon(imageIcon);
                        hinhAnhSP1.setIcon(imageIcon);
                    } catch (IOException ex) {
                        Logger.getLogger(ThemSanPhamDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        
    }
    
    public String addImage(String imageURL) {
        Random randomGenerator = new Random();
        int rand = randomGenerator.nextInt(1000);
        File sourceFile = new File(imageURL);
        String destPath = "./src/image/product";
        File destFolder = new File(destPath);
        String newName = rand + sourceFile.getName();
        try {
            Path dest = Paths.get(destFolder.getPath(), newName);
            Files.copy(sourceFile.toPath(), dest);
        } catch (IOException e) {
        }
        return newName;
    }
    
    public SanPhamDTO getNewSP() {
        String ten = txtTenSP.getText();
        String hinhAnh = addImage(imageURL);
        float kichThuocMan = Float.parseFloat(txtKTMH.getText());
        String camSau = txtCamSau.getText();
        String camTruoc = txtCamTruoc.getText();
        String chipXuLy = txtChipXL.getText();
        String heDieuHanh = txtHDH.getText();
        int dungLuongPin = Integer.parseInt(txtDLPin.getText());
        int idThuongHieu = thBUS.getByIndex(cbxThuongHieu.getSelectedIndex()).getId();
        return new SanPhamDTO(newSPID, ten, hinhAnh, kichThuocMan, camSau, camTruoc, chipXuLy, heDieuHanh, dungLuongPin, idThuongHieu, 1);
    }
    
    public PhienBanSanPhamDTO getNewPBSP() {
        int ram = Integer.parseInt(txtRam.getText());
        int rom = Integer.parseInt(txtRom.getText());
        String mau = txtMau.getText();
        int giaNhap = Integer.parseInt(txtGiaNhap.getText());
        int giaXuat = Integer.parseInt(txtGiaBan.getText());
        return new PhienBanSanPhamDTO(newPBSPID, newSPID, ram, rom, mau, 0, giaNhap, giaXuat, 1);
    }
    
    public boolean ValidateInput() {
        if(Validator.isEmpty(txtTenSP.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm");
            return false;
        }
        if(Validator.isEmpty(txtKTMH.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập kích thước màn hình");
            return false;
        }
        if(Validator.isEmpty(txtCamTruoc.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông số camera trước");
            return false;
        }
        if(Validator.isEmpty(txtCamSau.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông số camera sau");
            return false;
        }
        if(Validator.isEmpty(txtDLPin.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập dung lượng pin");
            return false;
        }
        if(Validator.isEmpty(txtChipXL.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập chip xử lý");
            return false;
        }
        if(Validator.isEmpty(txtHDH.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập hệ điều hành");
            return false;
        }
        if(Validator.isEmpty(txtRam.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập dung lượng ram");
            return false;
        }
        if(Validator.isEmpty(txtRom.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập dung lượng rom");
            return false;
        }
        if(Validator.isEmpty(txtMau.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập màu");
            return false;
        }
        if(Validator.isEmpty(txtGiaNhap.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá nhập");
            return false;
        }
        if(Validator.isEmpty(txtGiaBan.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán");
            return false;
        }
        if(!Validator.isFloat(txtKTMH.getText())) {
            JOptionPane.showMessageDialog(this, "Kích thước màn hình phải là số dương");
            return false;
        }
        if(!Validator.isInteger(txtDLPin.getText())) {
            JOptionPane.showMessageDialog(this, "Dung lượng pin phải là số nguyên dương");
            return false;
        }
        if(!Validator.isInteger(txtRam.getText())) {
            JOptionPane.showMessageDialog(this, "Dung lượng ram phải là số nguyên dương");
            return false;
        }
        if(!Validator.isInteger(txtRom.getText())) {
            JOptionPane.showMessageDialog(this, "Dung lượng rom phải là số nguyên dương");
            return false;
        }
        if(!Validator.isInteger(txtGiaNhap.getText())) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số nguyên dương");
            return false;
        }
        if(!Validator.isInteger(txtGiaBan.getText())) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số nguyên dương");
            return false;
        }
        return true;
    }
    
    public void addSPEvent() {
        if(!ValidateInput())
            return;
        SanPhamDTO newSP = getNewSP();
        PhienBanSanPhamDTO newPBSP = getNewPBSP();
        if(panelSanPham.spBUS.addNewSPWithPBSP(newSP, newPBSP)) {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công !");
            panelSanPham.loadDataToTable(panelSanPham.sanPhamList);
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

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        hinhAnhSP = new javax.swing.JLabel();
        imgUploadBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKTMH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtChipXL = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCamTruoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCamSau = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtHDH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDLPin = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        themSanPhamBtn = new javax.swing.JButton();
        cbxThuongHieu = new javax.swing.JComboBox(thBUS.getStringList());
        card2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        hinhAnhSP1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tenSP1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtRam = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtRom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMau = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        themSPBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(88, 175, 232));
        headerPanel.setPreferredSize(new java.awt.Dimension(994, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM SẢN PHẨM");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setPreferredSize(new java.awt.Dimension(1000, 380));
        contentPanel.setLayout(new java.awt.CardLayout());

        card1.setBackground(new java.awt.Color(255, 255, 255));
        card1.setPreferredSize(new java.awt.Dimension(1000, 380));

        hinhAnhSP.setPreferredSize(new java.awt.Dimension(300, 300));

        imgUploadBtn.setBackground(new java.awt.Color(102, 204, 255));
        imgUploadBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        imgUploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        imgUploadBtn.setText("Chọn ảnh");
        imgUploadBtn.setBorder(null);
        imgUploadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setText("Tên sản phẩm");
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel3.setText("Kích thước màn hình");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel4.setText("Chip xử lí");
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel12.setText("Camera trước");
        jLabel12.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel13.setText("Camera sau");
        jLabel13.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel14.setText("Hệ điều hành");
        jLabel14.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel16.setText("Dung lượng pin");
        jLabel16.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel17.setText("Thương hiệu");
        jLabel17.setPreferredSize(new java.awt.Dimension(80, 20));

        themSanPhamBtn.setBackground(new java.awt.Color(247, 179, 43));
        themSanPhamBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        themSanPhamBtn.setForeground(new java.awt.Color(255, 255, 255));
        themSanPhamBtn.setText("Thêm phiên bản sản phẩm");
        themSanPhamBtn.setBorder(null);
        themSanPhamBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        themSanPhamBtn.setFocusPainted(false);
        themSanPhamBtn.setPreferredSize(new java.awt.Dimension(180, 50));
        themSanPhamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                themSanPhamBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hinhAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(imgUploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(themSanPhamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCamTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(card1Layout.createSequentialGroup()
                                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSP)
                                    .addComponent(txtDLPin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCamSau)
                                    .addComponent(txtChipXL, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(card1Layout.createSequentialGroup()
                                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 120, Short.MAX_VALUE))
                                    .addComponent(cbxThuongHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKTMH)
                            .addComponent(txtHDH, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hinhAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(card1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKTMH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(card1Layout.createSequentialGroup()
                                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(cbxThuongHieu))))
                        .addGap(18, 18, 18)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(card1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCamTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(card1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCamSau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDLPin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHDH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(card1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChipXL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(themSanPhamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgUploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.add(card1, "card1");

        card2.setBackground(new java.awt.Color(255, 255, 255));
        card2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        hinhAnhSP1.setBackground(new java.awt.Color(255, 255, 255));
        hinhAnhSP1.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel5.setText("Tên sản phẩm");
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 20));

        tenSP1.setFocusable(false);

        jLabel15.setText("Dung lượng RAM");
        jLabel15.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel18.setText("Dung lượng ROM");
        jLabel18.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel6.setText("Màu");
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel19.setText("Giá nhập");
        jLabel19.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabel20.setText("Giá bán");
        jLabel20.setPreferredSize(new java.awt.Dimension(80, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hinhAnhSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hinhAnhSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(47, 47, 47))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addComponent(txtRom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(47, 47, 47))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(7, 7, 7))
        );

        card2.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 60));

        themSPBtn.setBackground(new java.awt.Color(61, 220, 151));
        themSPBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        themSPBtn.setForeground(new java.awt.Color(255, 255, 255));
        themSPBtn.setText("Thêm sản phẩm");
        themSPBtn.setBorder(null);
        themSPBtn.setPreferredSize(new java.awt.Dimension(180, 50));
        themSPBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                themSPBtnMousePressed(evt);
            }
        });

        jButton2.setText("Quay lại");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 50));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(themSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        card2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        contentPanel.add(card2, "card2");

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themSanPhamBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themSanPhamBtnMousePressed
        cardLayout.show(contentPanel, "card2");
        tenSP1.setText(txtTenSP.getText());
    }//GEN-LAST:event_themSanPhamBtnMousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        cardLayout.show(contentPanel, "card1");
    }//GEN-LAST:event_jButton2MousePressed

    private void themSPBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themSPBtnMousePressed
        addSPEvent();
    }//GEN-LAST:event_themSPBtnMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JComboBox cbxThuongHieu;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel headerPanel;
    public javax.swing.JLabel hinhAnhSP;
    public javax.swing.JLabel hinhAnhSP1;
    private javax.swing.JButton imgUploadBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField tenSP1;
    private javax.swing.JButton themSPBtn;
    private javax.swing.JButton themSanPhamBtn;
    private javax.swing.JTextField txtCamSau;
    private javax.swing.JTextField txtCamTruoc;
    private javax.swing.JTextField txtChipXL;
    private javax.swing.JTextField txtDLPin;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHDH;
    private javax.swing.JTextField txtKTMH;
    private javax.swing.JTextField txtMau;
    private javax.swing.JTextField txtRam;
    private javax.swing.JTextField txtRom;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
