/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhanVienBUS;
import BUS.QuyenBUS;
import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.Component.SearchBar;
import GUI.Component.ToolBarButton;
import GUI.Main;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TaiKhoan extends javax.swing.JPanel implements ActionListener {

    public TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    public NhanVienBUS nvBUS = new NhanVienBUS();
    public QuyenBUS qBUS = new QuyenBUS();
    public ArrayList<TaiKhoanDTO> tkList = tkBUS.getAll();
    public Main main;
    
    private DefaultTableModel tableModel;
    public SearchBar searchBar;
    public ToolBarButton chiTietBtn = new ToolBarButton("Chi tiết", "toolBar_detail.svg", "detail");
    public ToolBarButton themBtn = new ToolBarButton("Thêm", "toolBar_add.svg", "add");
    public ToolBarButton suaBtn = new ToolBarButton("Sửa", "toolBar_edit.svg", "edit");
    public ToolBarButton xoaBtn = new ToolBarButton("Xóa", "toolBar_delete.svg", "delete");
    /**
     * Creates new form TaiKhoan
     */
    public TaiKhoan(Main main) {
        initComponents();
        initComponentsCustom();
        this.main = main;
        loadDataToTable(this.tkList);
    }

    public void initComponentsCustom() {
        searchBar = new SearchBar(new String[]{"Tất cả", "Mã", "Tên", "Giới tính", "Số điện thoại", "Email", "Chức vụ"});
        searchBar.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
//                searchEvent();
            }
        });
        searchBar.lamMoiBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
//                reloadEvent();
            }
        });
        searchBar.cbxType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
//                searchEvent();
            }
        });
        topPanel.add(searchBar, BorderLayout.CENTER);
        toolBar.add(chiTietBtn);
        toolBar.add(themBtn);
        toolBar.add(suaBtn);
        toolBar.add(xoaBtn);
        chiTietBtn.addActionListener(this);
        themBtn.addActionListener(this);
        suaBtn.addActionListener(this);
        xoaBtn.addActionListener(this);
        tkTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableModel = (DefaultTableModel) tkTable.getModel(); 
    }
    
    public void loadDataToTable(ArrayList<TaiKhoanDTO> tkList) {
        tableModel.setRowCount(0);
        for(TaiKhoanDTO i : tkList) {
            tableModel.addRow(new Object[]{i.getId(), nvBUS.getNameByID(i.getIdNhanVien()), qBUS.getNameById(i.getIdQuyen()), i.getTenTaiKhoan(), i.getMatKhau()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tkTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(221, 221, 221)));
        topPanel.setPreferredSize(new java.awt.Dimension(1030, 100));
        topPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setBackground(new java.awt.Color(255, 255, 255));
        toolBar.setRollover(true);
        toolBar.setPreferredSize(new java.awt.Dimension(400, 100));
        topPanel.add(toolBar, java.awt.BorderLayout.LINE_END);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 620));

        tkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên nhân viên", "Quyền", "Tên tài khoản", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tkTable.setRowHeight(32);
        tkTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        tkTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tkTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tkTable.setShowGrid(true);
        tkTable.getTableHeader().setResizingAllowed(false);
        tkTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tkTable);
        if (tkTable.getColumnModel().getColumnCount() > 0) {
            tkTable.getColumnModel().getColumn(0).setResizable(false);
            tkTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            tkTable.getColumnModel().getColumn(1).setResizable(false);
            tkTable.getColumnModel().getColumn(2).setResizable(false);
            tkTable.getColumnModel().getColumn(3).setResizable(false);
            tkTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tkTable;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chiTietBtn) {

        }
        
        if(e.getSource() == themBtn) {
            
        }
        
        if(e.getSource() == xoaBtn) {
            
        }
        
        if(e.getSource() == suaBtn) {
            
        }
        
    }
    
}
