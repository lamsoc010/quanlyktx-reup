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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import BEANS.ThongKeSV;
import BEANS.ThuePhong;

/**
 *
 * @author Admin
 */
public class ThuePhongDao {
    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    public List<ThuePhong> getAllThuePhongs() {
        List<ThuePhong> listTP = new ArrayList<ThuePhong>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM THUEPHONG";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThuePhong tP = new ThuePhong();
                tP.setMaPhieu(rs.getInt(1));
                tP.setMaSV(rs.getString(2));
                tP.setMaQL(rs.getString(3));
                tP.setMaPhong(rs.getInt(4));
                tP.setNgayVao(rs.getDate(5));
                
                listTP.add(tP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listTP;
    }
    
    public void insertThuePhong(ThuePhong tP) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO THUEPHONG VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tP.getMaPhieu());
            ps.setString(2, tP.getMaSV());
            ps.setString(3, tP.getMaQL());
            ps.setInt(4, tP.getMaPhong());
            ps.setString(5, df.format(tP.getNgayVao()));
            ps.setString(6, tP.getTrangThai());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateNgayVaoThuePhong(Date ngayVao, int maPhieu) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE THUEPHONG SET NGAYVAO = ? WHERE MAPHIEU = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, df.format(ngayVao));
            ps.setInt(2, maPhieu);
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<ThongKeSV> thongKeSVTP(String sql) {
        conn = JDBCConnection.getJDBCConnection();
        List<ThongKeSV> listTKSV = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThongKeSV tK = new ThongKeSV();
                tK.setSoSV(rs.getInt(1));
                tK.setNgayVao(rs.getDate(2));
                listTKSV.add(tK);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTKSV;
    }
}
