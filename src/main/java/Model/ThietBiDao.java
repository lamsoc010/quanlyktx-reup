/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import BEANS.ThietBi;

/**
 *
 * @author Admin
 */
public class ThietBiDao {
    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    public List<ThietBi> getAllThietBis() {
        List<ThietBi> listTB = new ArrayList<ThietBi>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM THIETBI";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThietBi tB = new ThietBi();
                tB.setMaTB(rs.getString(1));
                tB.setTenTB(rs.getString(2));
                tB.setLoaiTB(rs.getString(3));
                tB.setSoLuong(rs.getInt(4));
                tB.setTinhTrang(rs.getString(5));
                tB.setGhiChu(rs.getString(6));
                
                listTB.add(tB);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTB;
    }
    
    public List<ThietBi> getAllTBByLoaiTB(String loaiTB) {
        conn = JDBCConnection.getJDBCConnection();
        List<ThietBi> listTB = new ArrayList<>();
        String sql = "SELECT * FROM THIETBI WHERE LOAITB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loaiTB);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThietBi tB = new ThietBi();
                tB.setMaTB(rs.getString(1));
                tB.setTenTB(rs.getString(2));
                tB.setLoaiTB(rs.getString(3));
                tB.setSoLuong(rs.getInt(4));
                tB.setTinhTrang(rs.getString(5));
                tB.setGhiChu(rs.getString(6));
                
                listTB.add(tB);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTB;
    }
    
    public List<ThietBi> getAllTBByMaPhong(int maPhong) {
        conn = JDBCConnection.getJDBCConnection();
        List<ThietBi> listTB = new ArrayList<>();
        String sql = "SELECT * FROM THIETBI WHERE MAPHONG = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThietBi tB = new ThietBi();
                tB.setMaTB(rs.getString(1));
                tB.setTenTB(rs.getString(2));
                tB.setLoaiTB(rs.getString(3));
                tB.setSoLuong(rs.getInt(4));
                tB.setTinhTrang(rs.getString(5));
                tB.setGhiChu(rs.getString(6));
                
                listTB.add(tB);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTB;
    }
    
    public ThietBi getTBByMaTB(String maTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM THIETBI WHERE MATB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maTB);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThietBi tB = new ThietBi();
                
                tB.setMaTB(rs.getString(1));
                tB.setTenTB(rs.getString(2));
                tB.setLoaiTB(rs.getString(3));
                tB.setSoLuong(rs.getInt(4));
                tB.setTinhTrang(rs.getString(5));
                tB.setGhiChu(rs.getString(6));
                
                return tB;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertThietBi(ThietBi tB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO THIETBI VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tB.getMaTB());
            ps.setString(2, tB.getTenTB());
            ps.setString(3, tB.getLoaiTB());
            ps.setInt(4, tB.getSoLuong());
            ps.setString(5, tB.getTinhTrang());
            ps.setString(6, tB.getGhiChu());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateThietBi(ThietBi tB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE THIETBI SET TENTB = ?,LOAITB = ?, SOLUONG = ?, TINHTRANG = ?, GHICHU = ?"
                + " WHERE MATB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tB.getTenTB());
            ps.setString(2, tB.getLoaiTB());
            ps.setInt(3, tB.getSoLuong());
            ps.setString(4, tB.getTinhTrang());
            ps.setString(5, tB.getGhiChu());
            ps.setString(6, tB.getMaTB());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteTB(String maTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE THIETBI WHERE MATB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maTB);
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
