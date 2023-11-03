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
import BEANS.KyLuat;
import BEANS.ThongKeKL;

/**
 *
 * @author Admin
 */
public class KyLuatDao {
    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    public List<KyLuat> getAllKyLuats() {
        List<KyLuat> listKL = new ArrayList<>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM KYLUAT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KyLuat kL = new KyLuat();
                kL.setMaPhieu(rs.getInt(1));
                kL.setLoaiKL(rs.getString(2));
                kL.setNoiDung(rs.getString(3));
                kL.setHinhThucPhat(rs.getString(4));
                kL.setMaSV(rs.getString(5));
                kL.setMaQL(rs.getString(6));
                kL.setNgayViPham(rs.getDate(7));
                
                listKL.add(kL);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKL;
    }
    
    public void updateKyLuat(KyLuat kL) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE KYLUAT SET NOIDUNG = ?, HINHTHUCPHAT = ?, NGAYVIPHAM = ? WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kL.getNoiDung());
            ps.setString(2, kL.getHinhThucPhat());
            ps.setString(3, df.format(kL.getNgayViPham()));
            ps.setInt(4, kL.getMaPhieu());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertKyLuat(KyLuat kL) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO KYLUAT VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, kL.getMaPhieu());
            ps.setString(2, kL.getLoaiKL());
            ps.setString(3, kL.getNoiDung());
            ps.setString(4, kL.getHinhThucPhat());
            ps.setString(5, kL.getMaSV());
            ps.setString(6, kL.getMaQL());
            ps.setString(7, df.format(kL.getNgayViPham()));
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public KyLuat getKyLuatByMaPhieu(int maPhieu) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM KYLUAT WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KyLuat kL = new KyLuat();
                kL.setMaPhieu(rs.getInt(1));
                kL.setLoaiKL(rs.getString(2));
                kL.setNoiDung(rs.getString(3));
                kL.setHinhThucPhat(rs.getString(4));
                kL.setMaSV(rs.getString(5));
                kL.setMaQL(rs.getString(6));
                kL.setNgayViPham(rs.getDate(7));
                return kL;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<KyLuat> thongKeKL(String sql) {
        conn = JDBCConnection.getJDBCConnection();
        List<KyLuat> listKL = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KyLuat kL = new KyLuat();
                kL.setMaPhieu(rs.getInt(1));
                kL.setLoaiKL(rs.getString(2));
                kL.setNoiDung(rs.getString(3));
                kL.setHinhThucPhat(rs.getString(4));
                kL.setMaSV(rs.getString(5));
                kL.setMaQL(rs.getString(6));
                kL.setNgayViPham(rs.getDate(7));
                
                listKL.add(kL);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKL;
    }
    
    public List<ThongKeKL> thongKeKLSV(String sql) {
        conn = JDBCConnection.getJDBCConnection();
        List<ThongKeKL> listTKKL = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThongKeKL tKKL = new ThongKeKL();
                tKKL.setSoSV(rs.getInt(1));
                tKKL.setNgayViPham(rs.getDate(2));
                listTKKL.add(tKKL);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTKKL;
    }
}
