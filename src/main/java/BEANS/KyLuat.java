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
public class KyLuat {
    int maPhieu;
    String loaiKL, noiDung, hinhThucPhat, maSV, maQL;
    Date ngayViPham;

    public KyLuat() {
    }

    public KyLuat(int maPhieu, String loaiKL, String noiDung, String hinhThucPhat, String maSV, String maQL, Date ngayViPham) {
        this.maPhieu = maPhieu;
        this.loaiKL = loaiKL;
        this.noiDung = noiDung;
        this.hinhThucPhat = hinhThucPhat;
        this.maSV = maSV;
        this.maQL = maQL;
        this.ngayViPham = ngayViPham;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getLoaiKL() {
        return loaiKL;
    }

    public void setLoaiKL(String loaiKL) {
        this.loaiKL = loaiKL;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhThucPhat() {
        return hinhThucPhat;
    }

    public void setHinhThucPhat(String hinhThucPhat) {
        this.hinhThucPhat = hinhThucPhat;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaQL() {
        return maQL;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public Date getNgayViPham() {
        return ngayViPham;
    }

    public void setNgayViPham(Date ngayViPham) {
        this.ngayViPham = ngayViPham;
    }
    
}
