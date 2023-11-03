/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEANS;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class QuanLyThietBi {
    int maPhong, soLuong;
    String maTB, maQL, ghiChu;
    Date ngayBanGiao, ngayKiemTra;

    public QuanLyThietBi() {
    }

    public QuanLyThietBi(int maPhong, int soLuong, String maTB, String maQL, String ghiChu, Date ngayBanGiao, Date ngayKiemTra) {
        this.maPhong = maPhong;
        this.soLuong = soLuong;
        this.maTB = maTB;
        this.maQL = maQL;
        this.ghiChu = ghiChu;
        this.ngayBanGiao = ngayBanGiao;
        this.ngayKiemTra = ngayKiemTra;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getMaQL() {
        return maQL;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayBanGiao() {
        return ngayBanGiao;
    }

    public void setNgayBanGiao(Date ngayBanGiao) {
        this.ngayBanGiao = ngayBanGiao;
    }

    public Date getNgayKiemTra() {
        return ngayKiemTra;
    }

    public void setNgayKiemTra(Date ngayKiemTra) {
        this.ngayKiemTra = ngayKiemTra;
    }
    
    
}
