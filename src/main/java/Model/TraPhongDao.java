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
import BEANS.TraPhong;

/**
 *
 * @author Admin
 */
public class TraPhongDao {
    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public List<TraPhong> getAllTraPhongs() {
        List<TraPhong> listTraP = new ArrayList<>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TRAPHONG";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TraPhong tP = new TraPhong();
                tP.setMaPhieu(rs.getInt(1));
                tP.setMaSV(rs.getString(2));
                tP.setMaPhong(rs.getInt(3));
                tP.setMaQL(rs.getString(4));
                tP.setNgayTra(rs.getDate(5));
                tP.setLiDo(rs.getString(6));
                
                listTraP.add(tP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listTraP;
    }
    
    public void insertTraPhong(TraPhong tP) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO TRAPHONG VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tP.getMaPhieu());
            ps.setString(2, tP.getMaSV());
            ps.setInt(3, tP.getMaPhong());
            ps.setString(4, tP.getMaQL());
            ps.setString(5, df.format(tP.getNgayTra()));
            ps.setString(6, tP.getLiDo());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateTraPhong(TraPhong traP) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE TRAPHONG SET NGAYTRA = ?, LIDO = ? WHERE MAPHIEU = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, df.format(traP.getNgayTra()));
            ps.setString(2, traP.getLiDo());
            ps.setInt(3, traP.getMaPhieu());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public TraPhong getTraPByMaPhieu(int maPhieu) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TRAPHONG WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                TraPhong tP = new TraPhong();
                tP.setMaPhieu(rs.getInt(1));
                tP.setMaSV(rs.getString(2));
                tP.setMaPhong(rs.getInt(3));
                tP.setMaQL(rs.getString(4));
                tP.setNgayTra(rs.getDate(5));
                tP.setLiDo(rs.getString(6));
                
                return tP;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
