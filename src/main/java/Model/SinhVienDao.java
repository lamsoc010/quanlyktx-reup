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
import BEANS.Phong;
import BEANS.SinhVien;

/**
 *
 * @author Admin
 */
public class SinhVienDao {

    Connection conn;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public List<SinhVien> getAllSinhViens() {
        List<SinhVien> listSV = new ArrayList<SinhVien>();
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SINHVIEN";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sV = new SinhVien();
                sV.setMaSV(rs.getString(1));
                sV.setAnh(rs.getString(2));
                sV.setHoTen(rs.getString(3));
                sV.setSdt(rs.getString(4));
                sV.setGioiTinh(rs.getString(5));
                sV.setDiaChi(rs.getString(6));
                sV.setNgaySinh(rs.getDate(7));
                sV.setNganh(rs.getString(8));
                sV.setKhoa(rs.getString(9));
                sV.setNgayVao(rs.getDate(10));
                sV.setMaPhong(rs.getInt(11));
                sV.setSoLanViPham(rs.getInt(12));
                sV.setTrangThai(rs.getString(13));

                listSV.add(sV);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listSV;
    }

    public void insertSinhVien(SinhVien sV) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO SINHVIEN VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sV.getMaSV());
            ps.setString(2, sV.getAnh());
            ps.setString(3, sV.getHoTen());
            ps.setString(4, sV.getSdt());
            ps.setString(5, sV.getGioiTinh());
            ps.setString(6, sV.getDiaChi());
            ps.setString(7, df.format(sV.getNgaySinh()));
            ps.setString(8, sV.getNganh());
            ps.setString(9, sV.getKhoa());
            ps.setString(10, df.format(sV.getNgayVao()));
            ps.setInt(11, sV.getMaPhong());
            ps.setInt(12, sV.getSoLanViPham());
            ps.setString(13, sV.getTrangThai());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public SinhVien getAllSinhVienByMaSV(String maSV) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SINHVIEN WHERE MASV = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sV = new SinhVien();
                sV.setMaSV(rs.getString(1));
                sV.setAnh(rs.getString(2));
                sV.setHoTen(rs.getString(3));
                sV.setSdt(rs.getString(4));
                sV.setGioiTinh(rs.getString(5));
                sV.setDiaChi(rs.getString(6));
                sV.setNgaySinh(rs.getDate(7));
                sV.setNganh(rs.getString(8));
                sV.setKhoa(rs.getString(9));
                sV.setNgayVao(rs.getDate(10));
                sV.setMaPhong(rs.getInt(11));
                sV.setSoLanViPham(rs.getInt(12));
                sV.setTrangThai(rs.getString(13));

                return sV;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void updateSinhVien(SinhVien sv) {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE SINHVIEN SET"
                + " ANH = ?, HOTEN = ?, SDT = ?, GIOITINH = ?, DIACHI = ?, NGAYSINH = ?, "
                + " NGANH = ?, KHOA = ?, NGAYVAO = ?, MAPHONG = ?, SOLANVIPHAM = ?, TRANGTHAI = ?"
                + " WHERE MASV = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getAnh());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getSdt());
            ps.setString(4, sv.getGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, df.format(sv.getNgaySinh()));
            ps.setString(7, sv.getNganh());
            ps.setString(8, sv.getKhoa());
            ps.setString(9, df.format(sv.getNgayVao()));
            ps.setInt(10, sv.getMaPhong());
            ps.setInt(11, sv.getSoLanViPham());
            ps.setString(12, sv.getTrangThai());
            ps.setString(13, sv.getMaSV());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<SinhVien> searchSinhVien(String sql) {
        List<SinhVien> listSV = new ArrayList<>();
        conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SinhVien sV = new SinhVien();
                sV.setMaSV(rs.getString(1));
                sV.setAnh(rs.getString(2));
                sV.setHoTen(rs.getString(3));
                sV.setSdt(rs.getString(4));
                sV.setGioiTinh(rs.getString(5));
                sV.setDiaChi(rs.getString(6));
                sV.setNgaySinh(rs.getDate(7));
                sV.setNganh(rs.getString(8));
                sV.setKhoa(rs.getString(9));
                sV.setNgayVao(rs.getDate(10));
                sV.setMaPhong(rs.getInt(11));
                sV.setSoLanViPham(rs.getInt(12));
                sV.setTrangThai(rs.getString(13));
                listSV.add(sV);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSV;
    }

}
