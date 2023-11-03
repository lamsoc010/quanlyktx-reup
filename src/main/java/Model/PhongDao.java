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
import BEANS.Phong;

/**
 *
 * @author Admin
 */
public class PhongDao {
    Connection conn;
    
    public List<Phong> getAllPhongs() {
        List<Phong> listPhongs = new ArrayList<Phong>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM PHONG";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getInt(1));
                p.setLoaiPhong(rs.getString(2));
                p.setSoGiuong(rs.getInt(3));
                p.setSoNguoi(rs.getInt(4));
                p.setGiaTien(rs.getDouble(5));
                p.setTrangThai(rs.getString(6));
                
                listPhongs.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listPhongs;
    }
    
    public void updatePhong(Phong p) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE PHONG SET LOAIPHONG = ?, SOGIUONG = ?, SONGUOI = ?, GIATIEN = ?, TRANGTHAI = ? WHERE MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getLoaiPhong());
            ps.setInt(2, p.getSoGiuong());
            ps.setInt(3, p.getSoNguoi());
            ps.setDouble(4, p.getGiaTien());
            String trangThai = "Còn Trống";
            if(p.getSoNguoi() >= p.getSoGiuong() * 2) {
                trangThai = "Đủ Người";
            }
            ps.setString(5, trangThai);
            ps.setInt(6, p.getMaPhong());
            
            int rs = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertPhong(Phong p) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO PHONG VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getMaPhong());
            ps.setString(2, p.getLoaiPhong());
            ps.setInt(3, p.getSoGiuong());
            ps.setInt(4, p.getSoNguoi());
            ps.setDouble(5, p.getGiaTien());
            ps.setString(6, p.getTrangThai());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deletePhong(int maPhong) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE PHONG WHERE MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhong);
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Phong getPhongByMaPhong(int maPhong) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM PHONG WHERE MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Phong p = new Phong();
                p.setMaPhong(rs.getInt(1));
                p.setLoaiPhong(rs.getString(2));
                p.setSoGiuong(rs.getInt(3));
                p.setSoNguoi(rs.getInt(4));
                p.setGiaTien(rs.getDouble(5));
                p.setTrangThai(rs.getString(6));
                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
