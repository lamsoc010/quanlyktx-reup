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
import BEANS.ChuyenPhong;

/**
 *
 * @author Admin
 */
public class ChuyenPhongDao {
    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public List<ChuyenPhong> getAllChuyenPhongs() {
        List<ChuyenPhong> listCP = new ArrayList<ChuyenPhong>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM CHUYENPHONG";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ChuyenPhong cP = new ChuyenPhong();
                cP.setMaPhieu(rs.getInt(1));
                cP.setMaSV(rs.getString(2));
                cP.setMaPhongCu(rs.getInt(3));
                cP.setMaPhongMoi(rs.getInt(4));
                cP.setMaQL(rs.getString(5));
                cP.setNgayChuyen(rs.getDate(6));
                cP.setLiDo(rs.getString(7));
                
                listCP.add(cP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listCP;
    }
    
    public void insertChuyenPhong(ChuyenPhong cP) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO CHUYENPHONG VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cP.getMaPhieu());
            ps.setString(2, cP.getMaSV());
            ps.setInt(3, cP.getMaPhongCu());
            ps.setInt(4, cP.getMaPhongMoi());
            ps.setString(5, cP.getMaQL());
            ps.setString(6, df.format(cP.getNgayChuyen()));
            ps.setString(7, cP.getLiDo());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateChuyenPhong(ChuyenPhong cP) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE CHUYENPHONG SET NGAYCHUYEN = ?, LIDO = ? WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, df.format(cP.getNgayChuyen()));
            ps.setString(2, cP.getLiDo());
            ps.setInt(3, cP.getMaPhieu());
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public ChuyenPhong getChuyenPhongByMaPhieu(int maPhieu) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM CHUYENPHONG WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ChuyenPhong cP = new ChuyenPhong();
                cP.setMaPhieu(rs.getInt(1));
                cP.setMaSV(rs.getString(2));
                cP.setMaPhongCu(rs.getInt(3));
                cP.setMaPhongMoi(rs.getInt(4));
                cP.setMaQL(rs.getString(5));
                cP.setNgayChuyen(rs.getDate(6));
                cP.setLiDo(rs.getString(7));
                
                return cP;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
