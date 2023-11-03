/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import BEANS.DoanhThu;

/**
 *
 * @author Admin
 */
public class DoanhThuDao {
    Connection conn;
    
    public List<DoanhThu> getAllDoanhThus() {
        List<DoanhThu> listDT = new ArrayList<>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM DOANHTHU ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DoanhThu dt = new DoanhThu();
                dt.setMaHD(rs.getString(1));
                dt.setMaPhong(rs.getInt(2));
                dt.setThang(rs.getInt(3));
                dt.setTongTien(rs.getFloat(4));
                dt.setTrangThai(rs.getString(5));
                
                listDT.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDT;
    }
    
    public DoanhThu getDoanhThuByMPAndThang(int maPhong, int thang) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM DOANHTHU WHERE MAPHONG = ? AND THANG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhong);
            ps.setInt(2, thang);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DoanhThu dt = new DoanhThu();
                dt.setMaHD(rs.getString(1));
                dt.setMaPhong(rs.getInt(2));
                dt.setThang(rs.getInt(3));
                dt.setTongTien(rs.getFloat(4));
                dt.setTrangThai(rs.getString(5));
                
                return dt;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertDoanhThu(DoanhThu dt) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO DOANHTHU VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dt.getMaHD());
            ps.setInt(2, dt.getMaPhong());
            ps.setInt(3, dt.getThang());
            ps.setFloat(4, dt.getTongTien());
            ps.setString(5, dt.getTrangThai());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateDoanhThu(DoanhThu dt) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE DOANHTHU SET TRANGTHAI = ?, TONGTIEN = ? WHERE MAHD = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dt.getTrangThai());
            ps.setFloat(2, dt.getTongTien());
            ps.setString(3, dt.getMaHD());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
}
