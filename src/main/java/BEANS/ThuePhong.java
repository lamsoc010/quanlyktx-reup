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
public class ThuePhong {
    int maPhieu, maPhong;
    String maSV, maQL, trangThai;
    Date ngayVao;

    public ThuePhong() {
        
    }

    public ThuePhong(int maPhieu, int maPhong, String maSV, String maQL, String trangThai, Date ngayVao) {
        this.maPhieu = maPhieu;
        this.maPhong = maPhong;
        this.maSV = maSV;
        this.maQL = maQL;
        this.trangThai = trangThai;
        this.ngayVao = ngayVao;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }
    
}
