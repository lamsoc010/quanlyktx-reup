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
public class ChuyenPhong {
    int maPhieu, maPhongCu, maPhongMoi;
    String maSV, maQL, liDo;
    Date ngayChuyen;

    public ChuyenPhong() {
    }

    public ChuyenPhong(int maPhieu, int maPhongCu, int maPhongMoi, String maSV, String maQL, String liDo, Date ngayChuyen) {
        this.maPhieu = maPhieu;
        this.maPhongCu = maPhongCu;
        this.maPhongMoi = maPhongMoi;
        this.maSV = maSV;
        this.maQL = maQL;
        this.liDo = liDo;
        this.ngayChuyen = ngayChuyen;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhongCu() {
        return maPhongCu;
    }

    public void setMaPhongCu(int maPhongCu) {
        this.maPhongCu = maPhongCu;
    }

    public int getMaPhongMoi() {
        return maPhongMoi;
    }

    public void setMaPhongMoi(int maPhongMoi) {
        this.maPhongMoi = maPhongMoi;
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

    public Date getNgayChuyen() {
        return ngayChuyen;
    }

    public void setNgayChuyen(Date ngayChuyen) {
        this.ngayChuyen = ngayChuyen;
    }
    
}
