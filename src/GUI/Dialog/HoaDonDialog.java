/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.CTSanPhamBUS;
import BUS.CTHoaDonBUS;
import BUS.KhachHangBUS;
import BUS.PhienBanSanPhamBUS;
import BUS.BaoHanhBUS;
import BUS.SanPhamBUS;
import BUS.NhanVienBUS;
import BUS.HoaDonBUS;
import BUS.CTBaoHanhBUS;
import BUS.NhanVienBUS;
import DTO.CTBaoHanhDTO;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.PhienBanSanPhamDTO;
import DTO.TaiKhoanDTO;
import DTO.CTSanPhamDTO;
import DTO.SanPhamDTO;
import GUI.Panel.HoaDon;
import helper.Formatter;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Windows
 */
public class HoaDonDialog extends javax.swing.JDialog {

    private HoaDonBUS hdBUS = new HoaDonBUS();
    private BaoHanhBUS bhBUS = new BaoHanhBUS();
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private CTHoaDonBUS cthdBUS = new CTHoaDonBUS();
    private CTBaoHanhBUS ctBhBUS = new CTBaoHanhBUS();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private CTSanPhamBUS ctspBUS = new CTSanPhamBUS();
    private PhienBanSanPhamBUS pbspBUS = new PhienBanSanPhamBUS();
    public ArrayList<SanPhamDTO> spList;
    public ArrayList<PhienBanSanPhamDTO> pbspList;
    private ArrayList<CTHoaDonDTO> newCTHDList = new ArrayList<>();
    private ArrayList<CTSanPhamDTO> newCTSPList = new ArrayList<>();
    private ArrayList<CTBaoHanhDTO> newBaoHanhList = new ArrayList<>();
    private ArrayList<CTHoaDonDTO> CTHDList = new ArrayList<>();
    private ArrayList<CTSanPhamDTO> CTSPList = new ArrayList<>();
    private ArrayList<CTBaoHanhDTO> CTBHList = new ArrayList<>();
    private HoaDonDTO hoadon;
    private HoaDonDTO newHoaDon;
    private TaiKhoanDTO currentUser;
    private HoaDon hdPanel;
    private String mode;
    private int newhdId;
    private int newctbhId;
    private long tongTien =0;
    
    private DefaultTableModel cthdTableModel;
    
    
    
    /**
     * Creates new form HoaDonDialog
     */
    public HoaDonDialog(java.awt.Frame parent, boolean modal,HoaDon hdPanel, HoaDonDTO hoadon, TaiKhoanDTO currentUser,String mode) {
        super(parent, modal);
        this.hdPanel = hdPanel;
        this.mode = mode;
        this.currentUser = currentUser;
        this.hoadon = hoadon;
        this.newctbhId = ctBhBUS.getAutoIncrement();
        initComponents();
        initComponentsCustom();
    }
    
    public void initComponentsCustom(){
        this.setLocationRelativeTo(null);
        cthdTableModel = (DefaultTableModel) ctpnTable.getModel();
        if(mode.equals("detail"))
            initDetailMode();
        if(mode.equals("add"))
            initAddMode();
    }
    
    public void initDetailMode(){
        CTHDList = cthdBUS.getAllByID(hoadon.getId());
        CTBHList = ctBhBUS.getAllByHoaDonId(hoadon.getId());
        for(CTHoaDonDTO i : CTHDList){
            CTSanPhamDTO tempSp = ctspBUS.getBySanPhamByImei(i.getImeiSanPham());
            CTSPList.add(tempSp);
        }
        txtMa.setText(Integer.toString(hoadon.getId()));
        txtMa.setFocusable(false);
        khComboBox.removeAllItems();
        khComboBox.addItem(khBUS.getNameById(hoadon.getIdKhachHang()));
        khComboBox.setFocusable(false);
        kmComboBox.removeAllItems();
        kmComboBox.setFocusable(false);
        txtNv1.setText(nvBUS.getNameByID(hoadon.getIdNhanVien()));
        txtNv1.setFocusable(false);
        txtNn.setText(Formatter.FormatDateTime(hoadon.getNgayXuat()));
        txtNn.setFocusable(false);
        this.tongTien = hoadon.getTongTien();
        txtTt.setText(Formatter.FormatVND(this.tongTien));
        txtTt.setFocusable(false);
        xuatHangBtn.setVisible(false);
        themSPBtn.setVisible(false);
        xoaSPBtn.setVisible(false);
        loadDataToTable(CTHDList,CTSPList,CTBHList);
    }
    
    public void initAddMode(){
        NhanVienDTO currentNhanVien = nvBUS.getAccountById(Integer.toString(currentUser.getId()));
        newhdId = hdBUS.getAutoIncrement();
        lblMa.setText("");
        txtMa.setFocusable(false);
        txtMa.setBorder(null);
        txtNv1.setText(currentNhanVien.getHo() + " " + currentNhanVien.getTen());
        txtNv1.setFocusable(false);
        lblNn.setText("");
        txtNn.setFocusable(false);
        txtNn.setBorder(null);
        txtTt.setText(Formatter.FormatVND(this.tongTien));
        txtTt.setFocusable(false);
        this.spList = new ArrayList<>();
        this.pbspList = new ArrayList<>();
        ArrayList<SanPhamDTO> allSP = spBUS.getAll();
        for(SanPhamDTO i : allSP) {
            ArrayList<PhienBanSanPhamDTO> tempPBSPList = pbspBUS.getAllPBSPBySPId(i.getId());
            for(PhienBanSanPhamDTO j : tempPBSPList) {
                if(j.getSoLuong() > 0){
                    this.spList.add(i);
                    break;
                }
            }
        }
        for(SanPhamDTO i : this.spList) {
            ArrayList<PhienBanSanPhamDTO> tempPBSPList = pbspBUS.getAllPBSPBySPId(i.getId());
            for(PhienBanSanPhamDTO j : tempPBSPList) {
                if(j.getSoLuong() > 0){
                    this.pbspList.add(j);
                }
            }
        }
    }
    
    public void loadDataToTable(ArrayList<CTHoaDonDTO> cthdList,ArrayList<CTSanPhamDTO> ctspList,ArrayList<CTBaoHanhDTO> ctbhList) {
        cthdTableModel.setRowCount(0);
        for(int i=0; i<cthdList.size(); i++) {
            PhienBanSanPhamDTO pbspIndex = pbspBUS.getObjectById(ctspList.get(i).getIdPBSanPham());
            Timestamp ngayKetThuc = ctbhList.get(i).getNgayKetThuc();
            int ngay = ngayKetThuc.getDate();
            int thang = ngayKetThuc.getMonth() +1;
            int nam = ngayKetThuc.getYear() +1900;
            String displayDate = (ngay < 10 ? "0"+ngay : ngay) + "/" + (thang < 10 ? "0"+thang : thang) + "/" + nam;
            cthdTableModel.addRow(new Object[]{
                i+1,
                ctspList.get(i).getImei(),
                spBUS.getNameByID(ctspList.get(i).getIdSanPham()),
                pbspIndex.getRam(),
                pbspIndex.getRom(),
                pbspIndex.getMau(),
                displayDate,
                Formatter.FormatVND(cthdList.get(i).getTongTien()),
            });
        }
    }

    public String getImei(){
        boolean inputAccepted = false;
        String result = "";
        while(!inputAccepted){
                String input = JOptionPane.showInputDialog("Nhập IMEI");
                if(input == null)
                    return "";
                Pattern pattern = Pattern.compile("^[0-9]{15}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(input);
                boolean matchFound = matcher.find();
                if(!matchFound){
                    JOptionPane.showMessageDialog(this, "Imei phải là số có 15 chữ số");
                }else{
                    inputAccepted = true;
                    return input;
                } 
        }
        
        return result;
    }
    
    public int getSoThang(){
       int result =0;
       try {
            JComboBox jc = new JComboBox(bhBUS.getStringList());
            int input = JOptionPane.showConfirmDialog(this,jc,"Chọn số tháng bảo hành",JOptionPane.DEFAULT_OPTION);
            if(input == JOptionPane.OK_OPTION){
                String str = (String) jc.getSelectedItem();
                result = Integer.parseInt(str);
            }
       } catch (Exception e) {
           return 0;
       }
       return result;
   }
        
   public boolean isExisted(String imei) {
        for(CTHoaDonDTO i : newCTHDList) {
            if(i.getImeiSanPham().equals(imei))
                return true;
        }
        return false;
    }
   
    public void setTongTien() {
        long sum=0;
        for(CTHoaDonDTO i : newCTHDList) {
            sum += i.getTongTien();
        }
        this.tongTien = sum;
    }
    
    public long getTongTien() {
        setTongTien();
        return this.tongTien;
    }
    
    public HoaDonDTO getNewHoaDon(){
        int khid = khBUS.getByIndex(khComboBox.getSelectedIndex()).getId();
        long now = System.currentTimeMillis();
        Timestamp ngayXuat = new Timestamp(now);
        int kmid =kmComboBox.getSelectedIndex();
        return new HoaDonDTO(this.newhdId , khid, this.currentUser.getIdNhanVien(), ngayXuat, this.tongTien, kmid);
    }
    
    public void reloadEvent() {
        loadDataToTable(newCTHDList,newCTSPList,newBaoHanhList);
        txtTt.setText(Formatter.FormatVND(getTongTien()));
    }
    
    public void addHdEvent(){
        newHoaDon = getNewHoaDon();
        if (hdPanel.hdBUS.addNewHDWithCTHDList(newHoaDon, newCTHDList,newCTSPList,newBaoHanhList)) {
            JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công !");
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
        headerLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        lblMa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNn = new javax.swing.JTextField();
        lblNn = new javax.swing.JLabel();
        txtTt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        xuatHangBtn = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ctpnTable = new javax.swing.JTable();
        themSPBtn = new javax.swing.JButton();
        xoaSPBtn = new javax.swing.JButton();
        txtNv1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kmComboBox = new javax.swing.JComboBox<>();
        khComboBox = new javax.swing.JComboBox(khBUS.getStringList());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(88, 175, 232));
        headerPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        headerPanel.setPreferredSize(new java.awt.Dimension(700, 50));

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Chi tiết hóa đơn");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        headerLabel.getAccessibleContext().setAccessibleName("Chi tiết Hoá Đơn");

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblMa.setText("Mã");

        jLabel2.setText("Khách hàng");

        jLabel3.setText("Nhân viên bán");

        lblNn.setText("Ngày bán");

        jLabel5.setText("Tổng tiền");

        xuatHangBtn.setBackground(new java.awt.Color(61, 220, 151));
        xuatHangBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xuatHangBtn.setForeground(new java.awt.Color(255, 255, 255));
        xuatHangBtn.setText("Xuất hóa đơn");
        xuatHangBtn.setBorder(null);
        xuatHangBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        xuatHangBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xuatHangBtnMousePressed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 107, 107));
        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Đóng");
        closeButton.setBorder(null);
        closeButton.setPreferredSize(new java.awt.Dimension(120, 40));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeButtonMousePressed(evt);
            }
        });

        ctpnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "IMEI", "Tên sản phẩm", "RAM", "ROM", "Màu", "Bảo hành đến", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ctpnTable.setFocusable(false);
        ctpnTable.setRowHeight(32);
        ctpnTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        ctpnTable.setShowGrid(true);
        ctpnTable.getTableHeader().setResizingAllowed(false);
        ctpnTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(ctpnTable);
        if (ctpnTable.getColumnModel().getColumnCount() > 0) {
            ctpnTable.getColumnModel().getColumn(0).setResizable(false);
            ctpnTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            ctpnTable.getColumnModel().getColumn(1).setResizable(false);
            ctpnTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            ctpnTable.getColumnModel().getColumn(2).setResizable(false);
            ctpnTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            ctpnTable.getColumnModel().getColumn(3).setResizable(false);
            ctpnTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ctpnTable.getColumnModel().getColumn(4).setResizable(false);
            ctpnTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            ctpnTable.getColumnModel().getColumn(5).setResizable(false);
            ctpnTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            ctpnTable.getColumnModel().getColumn(6).setResizable(false);
            ctpnTable.getColumnModel().getColumn(6).setPreferredWidth(150);
            ctpnTable.getColumnModel().getColumn(7).setResizable(false);
            ctpnTable.getColumnModel().getColumn(7).setPreferredWidth(200);
        }

        themSPBtn.setBackground(new java.awt.Color(102, 204, 255));
        themSPBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        themSPBtn.setForeground(new java.awt.Color(255, 255, 255));
        themSPBtn.setText("Thêm sản phẩm");
        themSPBtn.setBorder(null);
        themSPBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        themSPBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                themSPBtnMousePressed(evt);
            }
        });

        xoaSPBtn.setBackground(new java.awt.Color(26, 83, 92));
        xoaSPBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xoaSPBtn.setForeground(new java.awt.Color(255, 255, 255));
        xoaSPBtn.setText("Xóa sản phẩm");
        xoaSPBtn.setBorder(null);
        xoaSPBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        xoaSPBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xoaSPBtnMousePressed(evt);
            }
        });

        jLabel4.setText("Khuyến mãi");

        kmComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMa)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(khComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNv1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtTt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(themSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(xoaSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xuatHangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMa, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(khComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(kmComboBox)
                            .addComponent(txtMa)
                            .addComponent(txtNv1)
                            .addComponent(txtNn)
                            .addComponent(txtTt)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblNn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xuatHangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMousePressed
        dispose();
    }//GEN-LAST:event_closeButtonMousePressed

    private void themSPBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themSPBtnMousePressed
        // TODO add your handling code here:
        ChonSanPhamDialog dialog = new ChonSanPhamDialog(hdPanel.main, true, this.spList, this.pbspList, "xuat");
        dialog.setVisible(true);
        try {
            int pbspId = dialog.getSelectedId();
            PhienBanSanPhamDTO currPbSp = pbspBUS.getObjectById(pbspId);
            if(currPbSp.getSoLuong()==0){
                JOptionPane.showMessageDialog(this, "Đã Hết Hàng");
                return;
            }
            if(pbspId == -1)
            return;
            String imei = getImei();

            if(imei.equals(""))
            return;

            if(ctspBUS.checkExisted(imei) || isExisted(imei)){
                JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn hoặc bán ra");
                return;
            }
            int soThang = getSoThang();
            long now = System.currentTimeMillis();
            Date nowDate = new Date(now);
            nowDate.setMonth(nowDate.getMonth() + soThang);
            Timestamp bhTime = new Timestamp(nowDate.getTime());

            PhienBanSanPhamDTO pbsp = pbspBUS.getObjectById(pbspId);
            for(PhienBanSanPhamDTO i : this.pbspList) {
                if(i.getId() == pbsp.getId()) {
                    i.setSoLuong(i.getSoLuong() - 1);
                    break;
                }
            }
            this.tongTien += (long) pbsp.getGiaXuat();
            newCTHDList.add(new CTHoaDonDTO(this.newhdId, imei, 1, pbsp.getGiaXuat(), pbsp.getGiaXuat()));
            newCTSPList.add(new CTSanPhamDTO(imei, pbsp.getIdSanPham(), pbspId, this.newhdId, 1));
            newBaoHanhList.add(new CTBaoHanhDTO(this.newctbhId++,bhBUS.getIdBySoThang(soThang),this.newhdId,imei,bhTime));
            loadDataToTable(newCTHDList,newCTSPList,newBaoHanhList);
            txtTt.setText(Formatter.FormatVND(getTongTien()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_themSPBtnMousePressed

    private void xoaSPBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaSPBtnMousePressed
        // TODO add your handling code here:
        int index = ctpnTable.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xóa");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này không?", "", JOptionPane.YES_NO_OPTION) == 0) {
                for(PhienBanSanPhamDTO i : this.pbspList) {
                    if(i.getId() == newCTSPList.get(index).getIdPBSanPham()) {
                        i.setSoLuong(i.getSoLuong() + 1);
                        break;
                    }
                }
                newCTHDList.remove(index);
                newCTSPList.remove(index);
                newBaoHanhList.remove(index);
                reloadEvent();
            }
        }
    }//GEN-LAST:event_xoaSPBtnMousePressed

    private void xuatHangBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xuatHangBtnMousePressed
        // TODO add your handling code here:
        if(ctpnTable.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Phải có ít nhất 1 sản phẩm để tạo hoá đon");
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xuất hóa đơn không?", "", JOptionPane.YES_NO_OPTION)== 0)
            addHdEvent();
    }//GEN-LAST:event_xuatHangBtnMousePressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTable ctpnTable;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> khComboBox;
    private javax.swing.JComboBox<String> kmComboBox;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblNn;
    private javax.swing.JButton themSPBtn;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNn;
    private javax.swing.JTextField txtNv1;
    private javax.swing.JTextField txtTt;
    private javax.swing.JButton xoaSPBtn;
    private javax.swing.JButton xuatHangBtn;
    // End of variables declaration//GEN-END:variables
}
