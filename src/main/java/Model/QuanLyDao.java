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
import BEANS.QuanLy;

/**
 *
 * @author Admin
 */
public class QuanLyDao {
    Connection conn;
    
    public List<QuanLy> getAllQuanLys() {
        List<QuanLy> listQuanLys = new ArrayList<QuanLy>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM QUANLY";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                QuanLy qL = new QuanLy();
                qL.setMaQL(rs.getString(1));
                qL.setAnh(rs.getString(2));
                qL.setHoTen(rs.getString(3));
                qL.setSdt(rs.getString(4));
                qL.setDiaChi(rs.getString(5));
                qL.setPhuTrach(rs.getString(6));
                qL.setMatKhau(rs.getString(7));
                qL.setTrangThai(rs.getString(8));
                listQuanLys.add(qL);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listQuanLys;
    }
    
    public void updateQuanLy(QuanLy qL) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE QUANLY SET ANH = ?, HOTEN = ?, SDT = ?, DIACHI = ?, PHUTRACH = ?, MATKHAU = ?, TRANGTHAI = ? WHERE MAQL = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qL.getAnh());
            ps.setString(2, qL.getHoTen());
            ps.setString(3, qL.getSdt());
            ps.setString(4, qL.getDiaChi());
            ps.setString(5, qL.getPhuTrach());
            ps.setString(6, qL.getMatKhau());
            ps.setString(7, qL.getTrangThai());
            ps.setString(8, qL.getMaQL());
            
            int rs = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
    }
    
    public void insertQuanLy(QuanLy qL) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO QUANLY VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qL.getMaQL());
            ps.setString(2, qL.getAnh());
            ps.setString(3, qL.getHoTen());
            ps.setString(4, qL.getSdt());
            ps.setString(5, qL.getDiaChi());
            ps.setString(6, qL.getPhuTrach());
            ps.setString(7, qL.getMatKhau());
            ps.setString(8, qL.getTrangThai());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public QuanLy getQuanLyByMaQL(String maQL) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM QUANLY WHERE MAQL = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                QuanLy qL = new QuanLy();
                qL.setMaQL(rs.getString(1));
                qL.setAnh(rs.getString(2));
                qL.setHoTen(rs.getString(3));
                qL.setSdt(rs.getString(4));
                qL.setDiaChi(rs.getString(5));
                qL.setPhuTrach(rs.getString(6));
                qL.setMatKhau(rs.getString(7));
                qL.setTrangThai(rs.getString(8));
                return qL;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
}
