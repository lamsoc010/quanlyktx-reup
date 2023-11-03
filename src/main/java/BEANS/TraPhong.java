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
public class TraPhong {
    int maPhieu, maPhong;
    String maSV, maQL, liDo;
    Date ngayTra;

    public TraPhong() {
    }

    public TraPhong(int maPhieu, int maPhong, String maSV, String maQL, String liDo, Date ngayTra) {
        this.maPhieu = maPhieu;
        this.maPhong = maPhong;
        this.maSV = maSV;
        this.maQL = maQL;
        this.liDo = liDo;
        this.ngayTra = ngayTra;
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

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
