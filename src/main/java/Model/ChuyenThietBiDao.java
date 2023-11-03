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
import BEANS.ChuyenThietBi;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class ChuyenThietBiDao {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection conn;
    
    public List<ChuyenThietBi> getAllChuyenTBs() {
        conn = JDBCConnection.getJDBCConnection();
        List<ChuyenThietBi> listCTB = new ArrayList<ChuyenThietBi>();
        String sql = "SELECT * FROM CHUYENTHIETBI";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ChuyenThietBi cTB = new ChuyenThietBi();
                cTB.setMaPhieu(rs.getInt(1));
                cTB.setMaPhongCu(rs.getInt(2));
                cTB.setMaTB(rs.getString(3));
                cTB.setSoLuong(rs.getInt(4));
                cTB.setMaPhongMoi(rs.getInt(5));
                cTB.setGhiChu(rs.getString(6));
                cTB.setNgayChuyen(rs.getDate(7));
                listCTB.add(cTB);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listCTB;
    }
    
    public void insertCTB(ChuyenThietBi cTB) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO CHUYENTHIETBI VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cTB.getMaPhieu());
            ps.setInt(2, cTB.getMaPhongCu());
            ps.setString(3, cTB.getMaTB());
            ps.setInt(4, cTB.getSoLuong());
            ps.setInt(5, cTB.getMaPhongMoi());
            ps.setString(6, cTB.getGhiChu());
            ps.setString(7, df.format(cTB.getNgayChuyen()));
            
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
