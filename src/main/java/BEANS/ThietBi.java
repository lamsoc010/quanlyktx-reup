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
public class ThietBi {
    String maTB, tenTB, tinhTrang, loaiTB, ghiChu;
    int soLuong;

    public ThietBi() {
    }

    public ThietBi(String maTB, String tenTB, String tinhTrang, String loaiTB, String ghiChu, int soLuong) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.tinhTrang = tinhTrang;
        this.loaiTB = loaiTB;
        this.ghiChu = ghiChu;
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public void setLoaiTB(String loaiTB) {
        this.loaiTB = loaiTB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
    
}
