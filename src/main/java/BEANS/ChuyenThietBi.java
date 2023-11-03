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
public class ChuyenThietBi {
    int maPhieu, maPhongCu, SoLuong, maPhongMoi;
    String maTB, ghiChu;
    Date ngayChuyen;

    public ChuyenThietBi() {
    }

    public ChuyenThietBi(int maPhieu, int maPhongCu, int SoLuong, int maPhongMoi, String maTB, String ghiChu, Date ngayChuyen) {
        this.maPhieu = maPhieu;
        this.maPhongCu = maPhongCu;
        this.SoLuong = SoLuong;
        this.maPhongMoi = maPhongMoi;
        this.maTB = maTB;
        this.ghiChu = ghiChu;
        this.ngayChuyen = ngayChuyen;
    }

    public Date getNgayChuyen() {
        return ngayChuyen;
    }

    public void setNgayChuyen(Date ngayChuyen) {
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaPhongMoi() {
        return maPhongMoi;
    }

    public void setMaPhongMoi(int maPhongMoi) {
        this.maPhongMoi = maPhongMoi;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
