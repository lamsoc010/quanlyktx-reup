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
import BEANS.HoaDonDien;

/**
 *
 * @author Admin
 */
public class HoaDonDienDao {
    Connection conn;
    
    public List<HoaDonDien> getAllHoaDonDiens() {
        List<HoaDonDien> listHDD = new ArrayList<>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADONDIEN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoaDonDien hDD = new HoaDonDien();
                hDD.setMaHDD(rs.getString(1));
                hDD.setMaPhong(rs.getInt(2));
                hDD.setThang(rs.getInt(3));
                hDD.setSoCu(rs.getInt(4));
                hDD.setSoMoi(rs.getInt(5));
                hDD.setDonGia(rs.getFloat(6));
                hDD.setThanhTien(rs.getFloat(7));
                hDD.setMaHD(rs.getString(8));
                
                listHDD.add(hDD);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listHDD;
    }
    
    public HoaDonDien getTienDienByMaHD(String maHD){
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADONDIEN WHERE MAHD = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                HoaDonDien hDD = new HoaDonDien();
                hDD.setMaHDD(rs.getString(1));
                hDD.setMaPhong(rs.getInt(2));
                hDD.setThang(rs.getInt(3));
                hDD.setSoCu(rs.getInt(4));
                hDD.setSoMoi(rs.getInt(5));
                hDD.setDonGia(rs.getFloat(6));
                hDD.setThanhTien(rs.getFloat(7));
                hDD.setMaHD(rs.getString(8));
                
                return hDD;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertHoaDonDien(HoaDonDien hDD) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO HOADONDIEN VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hDD.getMaHDD());
            ps.setInt(2, hDD.getMaPhong());
            ps.setInt(3, hDD.getThang());
            ps.setInt(4, hDD.getSoCu());
            ps.setInt(5, hDD.getSoMoi());
            ps.setFloat(6, hDD.getDonGia());
            ps.setFloat(7, hDD.getThanhTien());
            ps.setString(8, hDD.getMaHD());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateHoaDonDien(HoaDonDien hDD) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE HOADONDIEN SET SOMOI = ?, THANHTIEN = ? WHERE MAHDD =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hDD.getSoMoi());
            ps.setFloat(2, hDD.getThanhTien());
            ps.setString(3, hDD.getMaHDD());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
