/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BEANS.DoanhThu;
import BEANS.HoaDonDien;
import BEANS.Phong;
import Controller.DoanhThuService;
import Controller.HoaDonDienService;
import Controller.PhongService;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class TinhTienJframe extends javax.swing.JFrame {
    PhongService phongService;
    Phong p;
    List<Phong> listPhong;
   
    DefaultTableModel defaultTinhTienModel;
    
    DoanhThuService doanhThuService;
    DoanhThu dT;
    List<DoanhThu> listDT;
    
    HoaDonDienService hoaDonDienService;
    List<HoaDonDien> listHDD;
    HoaDonDien hDD;
    
    
    
    private Locale localeVN = new Locale("vi", "VN");
    private NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    /**
     * Creates new form TinhTienJframe
     */
    public TinhTienJframe() {
        initComponents();
        phongService = new PhongService();
        doanhThuService = new DoanhThuService();
        hoaDonDienService = new HoaDonDienService();
        
        listPhong = phongService.getAllPhongs();
        setChonPhongCbb(phongService.getAllPhongs());
        donGiaDienTF.setText("" + 4000);
        luuLaiButton.setVisible(false);
        setTableAllTinhTien();
//        TableRowSorter<DefaultTableModel> sorterTT = new TableRowSorter<DefaultTableModel>(defaultTinhTienModel);
//        tinhTienTable.setRowSorter(sorterTT);
        
    }
    
    private void setTableTinhTien(int maPhong, int thang) {
        defaultTinhTienModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tinhTienTable.setModel(defaultTinhTienModel);
        defaultTinhTienModel.addColumn("Mã HD");
        defaultTinhTienModel.addColumn("Mã Phòng");
        defaultTinhTienModel.addColumn("Tháng");
        defaultTinhTienModel.addColumn("Tổng Tiền");
        defaultTinhTienModel.addColumn("Trạng Thái");
        
        setDataTinhTien(doanhThuService.getDoanhThuByMPAndThang(maPhong, thang));
    }
    
    private void setDataTinhTien(DoanhThu dt) {
        if(dt != null) {
            defaultTinhTienModel.addRow(new Object[] {
                dt.getMaHD(), dt.getMaPhong(), dt.getThang(), currencyVN.format(dt.getTongTien()), dt.getTrangThai()
            });
            
        }
    }
    
    private void setTableAllTinhTien() {
        defaultTinhTienModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tinhTienTable.setModel(defaultTinhTienModel);
        defaultTinhTienModel.addColumn("Mã HD");
        defaultTinhTienModel.addColumn("Mã Phòng");
        defaultTinhTienModel.addColumn("Tháng");
        defaultTinhTienModel.addColumn("Tổng Tiền");
        defaultTinhTienModel.addColumn("Trạng Thái");
        
        setDataAllTinhTien(doanhThuService.getAllDoanhThus());
    }
    private void setDataAllTinhTien(List<DoanhThu> listDT) {
        defaultTinhTienModel.setRowCount(0);
        listDT.forEach(dt -> {
            defaultTinhTienModel.addRow(new Object[] {
                dt.getMaHD(), dt.getMaPhong(), dt.getThang(), currencyVN.format(dt.getTongTien()), dt.getTrangThai()
            });
        });
    }
    
    private void setDataAllTinhTienByMaPhong(List<DoanhThu> listDT, int maPhong) {
        defaultTinhTienModel.setRowCount(0);
        listDT.forEach(dt -> {
            if(dt.getMaPhong() == maPhong) {
                defaultTinhTienModel.addRow(new Object[] {
                    dt.getMaHD(), dt.getMaPhong(), dt.getThang(), currencyVN.format(dt.getTongTien()), dt.getTrangThai()
                });
            }
        });
    }
    
    
    
    private void setChonPhongCbb(List<Phong> listPhong) {
        listPhong.forEach(p -> {
            chonPhongCbb.addItem(p.getMaPhong());
        });
        for(int i = 1; i <= 12; i++) {
            chonThangCbb.addItem(i);
        }
    }
    
    private void setAutoMoney() {
        int soCuDien = Integer.parseInt(soCuDienTF.getText());
        if(soMoiDienTF.getText().length() != 0) {
            int soMoiDien = Integer.parseInt(soMoiDienTF.getText()); 
            if(soMoiDien <= soCuDien) {
                JOptionPane.showMessageDialog(rootPane, "Số điện mới không thể nhỏ hơn số điện cũ");
                soMoiDienTF.setText("");
            } else {
                float donGiaDien = Float.parseFloat(donGiaDienTF.getText());
                int tienNuoc = Integer.parseInt(tienNuocTF.getText());
                float tienPhong = Float.parseFloat(tienPhongTF.getText());

                int tongSoDien = soMoiDien - soCuDien;
                float thanhTienDien = tongSoDien * donGiaDien;

                tongSoDienTF.setText(""+tongSoDien);
                thanhTienDienTF.setText(""+thanhTienDien);

                float tongTien = thanhTienDien + tienNuoc + tienPhong;
                tongTienTF.setText(""+ tongTien);
            }
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quayLaiButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chonPhongCbb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        soCuDienTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        soMoiDienTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tongSoDienTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        donGiaDienTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        thanhTienDienTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tienPhongTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tongTienTF = new javax.swing.JTextField();
        lapHoaDonButton = new javax.swing.JButton();
        suaButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        chonThangCbb = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        maHDTF = new javax.swing.JTextField();
        checkTraTienButton = new javax.swing.JButton();
        luuLaiButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        tienNuocTF = new javax.swing.JTextField();
        refreshButton = new javax.swing.JButton();
        trangThaiTF = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tinhTienTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phiếu Tính Tiền");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quayLaiButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quayLaiButton)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Chọn phòng:");

        chonPhongCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonPhongCbbActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Tiền điện:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Số Cũ:");

        soCuDienTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                soCuDienTFFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Số Mới:");

        soMoiDienTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                soMoiDienTFFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Tổng Số:");

        tongSoDienTF.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Đơn Giá: ");

        donGiaDienTF.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Thành Tiền:");

        thanhTienDienTF.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Tiền Nước:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Tiền Phòng:");

        tienPhongTF.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Tổng Tiền:");

        tongTienTF.setEditable(false);

        lapHoaDonButton.setBackground(new java.awt.Color(0, 0, 102));
        lapHoaDonButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapHoaDonButton.setForeground(new java.awt.Color(255, 255, 255));
        lapHoaDonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        lapHoaDonButton.setText("Lập Hoá Đơn");
        lapHoaDonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapHoaDonButtonActionPerformed(evt);
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Trạng Thái:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("Chọn tháng:");

        chonThangCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonThangCbbActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("Mã HD:");

        maHDTF.setEditable(false);

        checkTraTienButton.setBackground(new java.awt.Color(0, 0, 102));
        checkTraTienButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkTraTienButton.setForeground(new java.awt.Color(255, 255, 255));
        checkTraTienButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dollar.png"))); // NOI18N
        checkTraTienButton.setText("Thanh Toán");
        checkTraTienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTraTienButtonActionPerformed(evt);
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

        tienNuocTF.setEditable(false);

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

        trangThaiTF.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(chonPhongCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(chonThangCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tienNuocTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(maHDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(soCuDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tongTienTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lapHoaDonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(trangThaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(luuLaiButton)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tienPhongTF)
                                            .addComponent(soMoiDienTF))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(suaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(tongSoDienTF))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(donGiaDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkTraTienButton))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thanhTienDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(chonPhongCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(chonThangCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(maHDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(soCuDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(soMoiDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tongSoDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(donGiaDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(thanhTienDienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tienNuocTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(tienPhongTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tongTienTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(trangThaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lapHoaDonButton)
                    .addComponent(suaButton)
                    .addComponent(luuLaiButton)
                    .addComponent(checkTraTienButton)
                    .addComponent(refreshButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tinhTienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tinhTienTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tinhTienTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tinhTienTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tinhTienTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
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

    private void chonPhongCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonPhongCbbActionPerformed
        // TODO add your handling code here:
        int maPhong = Integer.parseInt(String.valueOf(chonPhongCbb.getSelectedItem()));
        p = phongService.getPhongByMaPhong(maPhong);
        tienPhongTF.setText(""+p.getGiaTien());
        tienNuocTF.setText(""+(p.getSoNguoi() * 20000));
        setTableAllTinhTien();
//        Lỗi ở setdataalltinhtien lỗi luôn ở cái chọn phòng chọn tháng luôn
        setDataAllTinhTienByMaPhong(doanhThuService.getAllDoanhThus(), maPhong);
//Check phòng có người ở chưa?
        
    }//GEN-LAST:event_chonPhongCbbActionPerformed

    private void chonThangCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonThangCbbActionPerformed
        // TODO add your handling code here:
        int maPhong = Integer.parseInt(String.valueOf(chonPhongCbb.getSelectedItem()));
        int thang = Integer.parseInt(String.valueOf(chonThangCbb.getSelectedIndex() + 1));
        
        setTableTinhTien(maPhong, thang);
    }//GEN-LAST:event_chonThangCbbActionPerformed

    private void luuLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuLaiButtonActionPerformed
        // TODO add your handling code here:
        String maHD = maHDTF.getText();
        int maPhong = Integer.parseInt(String.valueOf(chonPhongCbb.getSelectedItem()));
        int thang = Integer.parseInt(String.valueOf(chonThangCbb.getSelectedIndex() + 1));
        
//        Kiểm tra xem tháng đó có hoá đơn chưa, nếu có rồi không được lập nữa
        dT = doanhThuService.getDoanhThuByMPAndThang(maPhong, thang);
        if(dT == null) {
            int soCuDien = Integer.parseInt(soCuDienTF.getText());
            int soMoiDien = Integer.parseInt(soMoiDienTF.getText());
            int tongSoDien = Integer.parseInt(tongSoDienTF.getText());
            float donGiaDien = Float.parseFloat(donGiaDienTF.getText());
            float thanhTienDien = Float.parseFloat(thanhTienDienTF.getText());

            int tienNuoc = Integer.parseInt(tienNuocTF.getText());

            float tienPhong = Float.parseFloat(tienPhongTF.getText());
            float tongTien = Float.parseFloat(tongTienTF.getText());

    //        Xét vào doanh thu
            dT = new DoanhThu();
            dT.setMaHD(maHD);
            dT.setMaPhong(maPhong);
            dT.setThang(thang);
            dT.setTongTien(tongTien);
            dT.setTrangThai("Chưa thanh toán");

            doanhThuService.insertDoanhThu(dT);
            setTableTinhTien(maPhong, thang);

    //        Xét vào hoá đơn điện
            listHDD = hoaDonDienService.getAllHoaDonDiens();
            String maHDD = null;
            if(listHDD.size() != 0) {
                maHDD = listHDD.get(listHDD.size() - 1).getMaHDD();
            }
            if(maHDD == null) {
                maHDD = "HDD01";
            } else {
                int IDHDD = Integer.parseInt(maHDD.substring(maHDD.length() - 2));
                if(IDHDD < 10) {
                    maHDD = "HDD0" + ++IDHDD;
                } else {
                    maHDD = "HDD" + ++IDHDD;
                }
            }
            hDD = new HoaDonDien();
            hDD.setMaHDD(maHDD);
            hDD.setMaPhong(maPhong);
            hDD.setThang(thang);
            hDD.setSoCu(soCuDien);
            hDD.setSoMoi(soMoiDien);
            hDD.setDonGia(donGiaDien);
            hDD.setThanhTien(thanhTienDien);
            hDD.setMaHD(maHD);

            hoaDonDienService.insertHoaDonDien(hDD);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tháng này đã lập hoá đơn rồi");
        }
        
        
    }//GEN-LAST:event_luuLaiButtonActionPerformed

    private void soMoiDienTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_soMoiDienTFFocusLost
        // TODO add your handling code here:
        setAutoMoney();
    }//GEN-LAST:event_soMoiDienTFFocusLost

    private void lapHoaDonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapHoaDonButtonActionPerformed
        // TODO add your handling code here:
//      Kiểm tra xem tháng đó đã lập hoá đnơ chưa
        int maPhong = Integer.parseInt(String.valueOf(chonPhongCbb.getSelectedItem()));
        int thang = Integer.parseInt(String.valueOf(chonThangCbb.getSelectedIndex() + 1));
        dT = doanhThuService.getDoanhThuByMPAndThang(maPhong, thang);
        if(dT == null) {
//        Mã HD tự tăng theo ngày tháng và số ID
            luuLaiButton.setVisible(true);
            soCuDienTF.setEditable(true);
            LocalDate ngay = LocalDate.now();
            String ngayHienTai = ngay.toString().replaceAll("-", "");

            listDT = doanhThuService.getAllDoanhThus();
            String maHD = null;
            if(listDT.size() != 0) {
                maHD = listDT.get(listDT.size() - 1).getMaHD();
            }
            if(maHD != null) {
                int ID = Integer.parseInt(maHD.substring(maHD.length() - 2));
                if(ID < 9) {
                    maHD = ngayHienTai + "0" + ++ID;
                } else {
                    maHD = ngayHienTai + ++ID;
                }
            } else {
                maHD = ngayHienTai + "01";
            }
            maHDTF.setText(maHD);

//      Xét mà số cũ từ mã số mới của tháng trước
            dT = doanhThuService.getDoanhThuByMPAndThang(maPhong, thang - 1);
            if(dT != null) {
                String maHDThangTruoc = dT.getMaHD();
                hDD = hoaDonDienService.getTienDienByMaHD(maHDThangTruoc);
                soCuDienTF.setText(""+ hDD.getSoMoi());
            } else {
                soCuDienTF.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tháng này đã lập hoá đơn rồi");
        }
        

    }//GEN-LAST:event_lapHoaDonButtonActionPerformed

    private void checkTraTienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTraTienButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thanh toán hoá đơn này không?");
        if(confirm == JOptionPane.YES_OPTION) {
            int row = tinhTienTable.getSelectedRow();

            int maPhong = Integer.parseInt(String.valueOf(tinhTienTable.getValueAt(row, 1)));
            int thang = Integer.parseInt(String.valueOf(tinhTienTable.getValueAt(row, 2)));

            dT = doanhThuService.getDoanhThuByMPAndThang(maPhong, thang);
            if(dT.getTrangThai().equals("Đã thanh toán")) {
                JOptionPane.showMessageDialog(rootPane, "Hoá đơn này đã thanh toán");
            } else {
                dT.setTrangThai("Đã thanh toán");

                doanhThuService.updateDoanhThu(dT);
                setTableTinhTien(maPhong, thang);
            }
        }
        
    }//GEN-LAST:event_checkTraTienButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        luuLaiButton.setVisible(false);
        soCuDienTF.setEditable(true);
        chonPhongCbb.setSelectedIndex(0);
        chonThangCbb.setSelectedIndex(0);
        maHDTF.setText("");
        soCuDienTF.setText("");
        soMoiDienTF.setText("");
        tongSoDienTF.setText("");
        thanhTienDienTF.setText("");
        tienNuocTF.setText("");
        tienPhongTF.setText("");
        tongTienTF.setText("");
        
        setTableAllTinhTien();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void tinhTienTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tinhTienTableMouseClicked
        // TODO add your handling code here:
        luuLaiButton.setVisible(false);
        int row = tinhTienTable.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn trường");
        } else {
            String maHD = String.valueOf(tinhTienTable.getValueAt(row, 0));
            int phong = Integer.parseInt(String.valueOf(tinhTienTable.getValueAt(row, 1)));
            
            p = phongService.getPhongByMaPhong(phong);
            hDD = hoaDonDienService.getTienDienByMaHD(maHD);
            
            maHDTF.setText(hDD.getMaHD());
            soCuDienTF.setText(""+ hDD.getSoCu());
            soMoiDienTF.setText("" + hDD.getSoMoi());
            tienNuocTF.setText(""+ (p.getSoNguoi() * 20000));
            tienPhongTF.setText("" + p.getGiaTien());
            
            soCuDienTF.setEditable(false);
            setAutoMoney();
        }
    }//GEN-LAST:event_tinhTienTableMouseClicked

    private void suaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaButtonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa không?");
        if(confirm == JOptionPane.YES_OPTION) {
            int row = tinhTienTable.getSelectedRow();
            int maPhong = Integer.parseInt(String.valueOf(tinhTienTable.getValueAt(row, 1)));
            int thang = Integer.parseInt(String.valueOf(tinhTienTable.getValueAt(row, 2)));
            dT = doanhThuService.getDoanhThuByMPAndThang(maPhong, thang);
            if(dT.getTrangThai().equalsIgnoreCase("Chưa thanh toán")) {
                hDD = hoaDonDienService.getTienDienByMaHD(dT.getMaHD());

                int soDienMoi = Integer.parseInt(soMoiDienTF.getText());
                float thanhTien = Float.parseFloat(thanhTienDienTF.getText());
                float tongTien = Float.parseFloat(tongTienTF.getText());

                hDD.setSoMoi(soDienMoi);
                hDD.setThanhTien(thanhTien);

                dT.setTongTien(tongTien);

                hoaDonDienService.updateHoaDonDien(hDD);
                doanhThuService.updateDoanhThu(dT);
                setTableTinhTien(maPhong, thang);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hoá đơn đã thanh toán không thể sửa");
            }
            
        }
        
    }//GEN-LAST:event_suaButtonActionPerformed

    private void soCuDienTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_soCuDienTFFocusLost
        // TODO add your handling code here:
        int soDienCu = Integer.parseInt(soCuDienTF.getText());
        if(soDienCu < 0) {
           JOptionPane.showMessageDialog(rootPane, "Số điện không thể âm");
            soCuDienTF.setText("");
        }
        
    }//GEN-LAST:event_soCuDienTFFocusLost

    private void quayLaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quayLaiButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quayLaiButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TinhTienJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkTraTienButton;
    private javax.swing.JComboBox<Integer> chonPhongCbb;
    private javax.swing.JComboBox<Integer> chonThangCbb;
    private javax.swing.JTextField donGiaDienTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton lapHoaDonButton;
    private javax.swing.JButton luuLaiButton;
    private javax.swing.JTextField maHDTF;
    private javax.swing.JButton quayLaiButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField soCuDienTF;
    private javax.swing.JTextField soMoiDienTF;
    private javax.swing.JButton suaButton;
    private javax.swing.JTextField thanhTienDienTF;
    private javax.swing.JTextField tienNuocTF;
    private javax.swing.JTextField tienPhongTF;
    private javax.swing.JTable tinhTienTable;
    private javax.swing.JTextField tongSoDienTF;
    private javax.swing.JTextField tongTienTF;
    private javax.swing.JTextField trangThaiTF;
    // End of variables declaration//GEN-END:variables
}
