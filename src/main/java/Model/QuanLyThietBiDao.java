/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import BEANS.QuanLyThietBi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyThietBiDao {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection conn;
    
    public List<QuanLyThietBi> getAllQLTBs() {
        conn = JDBCConnection.getJDBCConnection();
        List<QuanLyThietBi> listQLTB = new ArrayList<>();
        String sql = "SELECT * FROM QUANLYTHIETBI";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                QuanLyThietBi qLTB = new QuanLyThietBi();
                qLTB.setMaTB(rs.getString(1));
                qLTB.setMaPhong(rs.getInt(2));
                qLTB.setSoLuong(rs.getInt(3));
                qLTB.setNgayBanGiao(rs.getDate(4));
                qLTB.setNgayKiemTra(rs.getDate(5));
                qLTB.setMaQL(rs.getString(6));
                qLTB.setGhiChu(rs.getString(7));
                listQLTB.add(qLTB);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQLTB;
    }
    
    public QuanLyThietBi getQLTBByMaTB(String maTB, int maPhong) {
        conn =JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM QUANLYTHIETBI WHERE MATB = ? and MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maTB);
            ps.setInt(2, maPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                QuanLyThietBi qLTB = new QuanLyThietBi();
                qLTB.setMaTB(rs.getString(1));
                qLTB.setMaPhong(rs.getInt(2));
                qLTB.setSoLuong(rs.getInt(3));
                qLTB.setNgayBanGiao(rs.getDate(4));
                qLTB.setNgayKiemTra(rs.getDate(5));
                qLTB.setMaQL(rs.getString(6));
                qLTB.setGhiChu(rs.getString(7));
                return qLTB;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertQLTB(QuanLyThietBi qLTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO QUANLYTHIETBI VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qLTB.getMaTB());
            ps.setInt(2, qLTB.getMaPhong());
            ps.setInt(3, qLTB.getSoLuong());
            ps.setString(4, df.format(qLTB.getNgayBanGiao()));
            ps.setString(5, df.format(qLTB.getNgayKiemTra()));
            ps.setString(6, qLTB.getMaQL());
            ps.setString(7, qLTB.getGhiChu());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateQLTB(QuanLyThietBi qLTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE QUANLYTHIETBI SET SOLUONG = ?, NGAYKIEMTRA = ?, GHICHU = ? WHERE MATB = ? AND MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, qLTB.getSoLuong());
            ps.setString(2, df.format(qLTB.getNgayKiemTra()));
            ps.setString(3, qLTB.getGhiChu());
            ps.setString(4, qLTB.getMaTB());
            ps.setInt(5, qLTB.getMaPhong());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeQLTB(QuanLyThietBi qLTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE QUANLYTHIETBI WHERE MATB = ? AND MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qLTB.getMaTB());
            ps.setInt(2, qLTB.getMaPhong());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
