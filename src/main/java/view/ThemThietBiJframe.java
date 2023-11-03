/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import BEANS.QuanLyThietBi;
import BEANS.ThietBi;
import Controller.QuanLyThietBiService;
import Controller.ThietBiService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ThemThietBiJframe extends javax.swing.JFrame {

    ThietBiService thietBiService;
    List<ThietBi> listTB;
    ThietBi tB;
    
    QuanLyThietBiService quanLyThietBiService;
    List<QuanLyThietBi> listQLTB;
    QuanLyThietBi qLTB;
    
    DefaultTableModel defaultTBModel;
    String maQL;
    /**
     * Creates new form ThemThietBiJframe
     */
    public ThemThietBiJframe(String maQL1) {
        initComponents();
        thietBiService = new ThietBiService();
        quanLyThietBiService = new QuanLyThietBiService();
        
        setTableTB();
        luuLaiButton.setVisible(false);
        maQL = maQL1;
    }

    private void setTableTB() {
        defaultTBModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        thietBiTable.setModel(defaultTBModel);
        defaultTBModel.addColumn("Mã TB");
        defaultTBModel.addColumn("Tên TB");
        defaultTBModel.addColumn("Loại TB");
        defaultTBModel.addColumn("Số Lượng");
        defaultTBModel.addColumn("SL Còn Lại");
        defaultTBModel.addColumn("Tình Tạng");
        defaultTBModel.addColumn("Ghi Chú");
        
        setDataTB(thietBiService.getAllThietBis());
    }
    
    private void setDataTB(List<ThietBi> listTB) {
        defaultTBModel.setRowCount(0);
        listTB.forEach(tb -> {
        int sLConLai = soLuongConLai(tb.getMaTB(), quanLyThietBiService.getAllQLTBs());
            defaultTBModel.addRow(new Object[] {
                tb.getMaTB(), tb.getTenTB(), tb.getLoaiTB(), tb.getSoLuong(), sLConLai, tb.getTinhTrang(), tb.getGhiChu()
            });
        });
    }
    
    private int soLuongConLai(String maTB, List<QuanLyThietBi> listQLTB) {
        tB = thietBiService.getTBByMaTB(maTB);
        int soLuongTong = tB.getSoLuong();
        
        listQLTB = quanLyThietBiService.getAllQLTBs();
        int soLuongDaDung = 0;
        for(QuanLyThietBi qLTB : listQLTB) {
            if(qLTB.getMaTB().equals(maTB)) {
                soLuongDaDung += qLTB.getSoLuong();
            }
        }
        int soLuongConLai = soLuongTong - soLuongDaDung;
        return soLuongConLai;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quayLaiButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tenTBTF = new javax.swing.JTextField();
        maTBTF = new javax.swing.JTextField();
        soLuongSp = new javax.swing.JSpinner();
        loaiTBCbb = new javax.swing.JComboBox<>();
        tinhTrangCbb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ghiChuTa = new javax.swing.JTextArea();
        themButton = new javax.swing.JButton();
        luuLaiButton = new javax.swing.JButton();
        suaButton = new javax.swing.JButton();
        xoaButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        thietBiTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Thiết Bị");

        quayLaiButton.setBackground(new java.awt.Color(0, 0, 102));
        quayLaiButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        quayLaiButton.setForeground(new java.awt.Color(255, 255, 255));
        quayLaiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        quayLaiButton.setText("Quay Lại");
        quayLaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayLaiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quayLaiButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quayLaiButton)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Mã TB:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Tên TB:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Loại TB:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Số Lượng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Tình Trạng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Ghi Chú:");

        maTBTF.setEditable(false);

        soLuongSp.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        loaiTBCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tủ", "Giường", "Quạt", "Vệ Sinh", "Đèn" }));

        tinhTrangCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mới", "Cũ", "Hư hỏng" }));

        ghiChuTa.setColumns(20);
        ghiChuTa.setRows(5);
        jScrollPane1.setViewportView(ghiChuTa);

        themButton.setBackground(new java.awt.Color(0, 0, 102));
        themButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        themButton.setForeground(new java.awt.Color(255, 255, 255));
        themButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        themButton.setText("Thêm");
        themButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themButtonActionPerformed(evt);
            }
        });

        luuLaiButton.setBackground(new java.awt.Color(0, 0, 102));
        luuLaiButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        luuLaiButton.setForeground(new java.awt.Color(255, 255, 255));
        luuLaiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        luuLaiButton.setText("Lưu Lại");
        luuLaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuLaiButtonActionPerformed(evt);
            }
        });

        suaButton.setBackground(new java.awt.Color(0, 0, 102));
        suaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        suaButton.setForeground(new java.awt.Color(255, 255, 255));
        suaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        suaButton.setText("Sửa");
        suaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaButtonActionPerformed(evt);
            }
        });

        xoaButton.setBackground(new java.awt.Color(0, 0, 102));
        xoaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        xoaButton.setForeground(new java.awt.Color(255, 255, 255));
        xoaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        xoaButton.setText("Xoá");
        xoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(0, 0, 102));
        refreshButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(themButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(maTBTF)
                    .addComponent(tenTBTF))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(soLuongSp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(luuLaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(loaiTBCbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(tinhTrangCbb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(maTBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loaiTBCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tinhTrangCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(tenTBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soLuongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(themButton)
                        .addComponent(luuLaiButton))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(suaButton)
                        .addComponent(xoaButton)
                        .addComponent(refreshButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        thietBiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        thietBiTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        thietBiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thietBiTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(thietBiTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themButtonActionPerformed
        // TODO add your handling code here:
        refreshButtonActionPerformed(evt);
        listTB = thietBiService.getAllThietBis();
        String maTB = listTB.get(listTB.size() - 1).getMaTB();
        int ID = Integer.parseInt(maTB.substring(maTB.length() - 2));
        if(ID < 10) {
            maTB = "TB0" + ++ID;
        } else {
            maTB = "TB" + ++ID;
        }
        maTBTF.setText(maTB);
        luuLaiButton.setVisible(true);
        
    }//GEN-LAST:event_themButtonActionPerformed

    private void thietBiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thietBiTableMouseClicked
        // TODO add your handling code here:
        int row = thietBiTable.getSelectedRow();
        if(row == -1 ) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn trường");
        } else {
            luuLaiButton.setVisible(false);
            String maTB = String.valueOf(thietBiTable.getValueAt(row, 0));
            tB = thietBiService.getTBByMaTB(maTB);
            
            maTBTF.setText(tB.getMaTB());
            tenTBTF.setText(tB.getTenTB());
            tinhTrangCbb.setSelectedItem(tB.getTinhTrang());
            loaiTBCbb.setSelectedItem(tB.getLoaiTB());
            soLuongSp.setValue(tB.getSoLuong());
            ghiChuTa.setText(tB.getGhiChu());
            
            int soLuongConLai = soLuongConLai(maTB, quanLyThietBiService.getAllQLTBs());
            int min = tB.getSoLuong() - soLuongConLai;
            min = min == 0 ? 1 : min;
            SpinnerModel sp = new SpinnerNumberModel(tB.getSoLuong(), min, 50,1);
            soLuongSp.setModel(sp);
        }
    }//GEN-LAST:event_thietBiTableMouseClicked

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        luuLaiButton.setVisible(false);
        
        maTBTF.setText("");
        tenTBTF.setText("");
        loaiTBCbb.setSelectedIndex(0);
        tinhTrangCbb.setSelectedIndex(0);
        soLuongSp.setValue(1);
        ghiChuTa.setText("");
        setDataTB(thietBiService.getAllThietBis());
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void luuLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuLaiButtonActionPerformed
        // TODO add your handling code here:
        String maTB = maTBTF.getText();
        String tenTB = tenTBTF.getText();
        String loaiTB = String.valueOf( loaiTBCbb.getSelectedItem());
        String tinhTrang = String.valueOf( tinhTrangCbb.getSelectedItem());
        int soLuong = Integer.parseInt(String.valueOf( soLuongSp.getValue()));
        String ghiChu = ghiChuTa.getText();
        
        tB = new ThietBi(maTB, tenTB, tinhTrang, loaiTB, ghiChu, soLuong);
        thietBiService.insertThietBi(tB);
        JOptionPane.showMessageDialog(rootPane, "Thêm thiết bị thành công");
        
        refreshButtonActionPerformed(evt);
    }//GEN-LAST:event_luuLaiButtonActionPerformed

    private void quayLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quayLaiButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ThietBiPhongJframe(maQL).setVisible(true);
    }//GEN-LAST:event_quayLaiButtonActionPerformed

    private void xoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xoá không?");
        if(confirm == JOptionPane.YES_OPTION) {
            int row = thietBiTable.getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn trường muốn xoá");
            } else {
                String maTB = String.valueOf(thietBiTable.getValueAt(row, 0));
                int soLuong = Integer.parseInt(String.valueOf(thietBiTable.getValueAt(row, 3)));
                int soLuongConLai = soLuongConLai(maTB, quanLyThietBiService.getAllQLTBs());
                if(soLuongConLai < soLuong) {
                    JOptionPane.showMessageDialog(rootPane, "Thiết bị này đang được dùng không thể xoá!");
                } else {
                    thietBiService.deleteTB(maTB);
                    JOptionPane.showMessageDialog(rootPane, "Xoá thiết bị thành công!");
                    refreshButtonActionPerformed(evt);
                }
                
            }
        }
    }//GEN-LAST:event_xoaButtonActionPerformed

    private void suaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn sửa không?");
        if(confirm == JOptionPane.YES_OPTION) {
            int row = thietBiTable.getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn trường muốn sửa");
            } else {
                String maTB = String.valueOf(thietBiTable.getValueAt(row, 0));
                String tenTB = tenTBTF.getText();
                String loaiTB = String.valueOf(loaiTBCbb.getSelectedItem());
                int soLuong = Integer.parseInt(String.valueOf(soLuongSp.getValue()));
                String tinhTrang = String.valueOf(tinhTrangCbb.getSelectedItem());
                String ghiChu = ghiChuTa.getText();
                
                tB = new ThietBi(maTB, tenTB, tinhTrang, loaiTB, ghiChu, soLuong);
                thietBiService.updateThietBi(tB);
                JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thành công!");
                refreshButtonActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_suaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ghiChuTa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> loaiTBCbb;
    private javax.swing.JButton luuLaiButton;
    private javax.swing.JTextField maTBTF;
    private javax.swing.JButton quayLaiButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JSpinner soLuongSp;
    private javax.swing.JButton suaButton;
    private javax.swing.JTextField tenTBTF;
    private javax.swing.JButton themButton;
    private javax.swing.JTable thietBiTable;
    private javax.swing.JComboBox<String> tinhTrangCbb;
    private javax.swing.JButton xoaButton;
    // End of variables declaration//GEN-END:variables
}
