/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEANS;

/**
 *
 * @author Admin
 */
public class HoaDonDien {
    String maHDD, maHD;
    int maPhong, thang, soCu, soMoi;
    float donGia, thanhTien;

    public HoaDonDien() {
    }

    public HoaDonDien(String maHDD, String maHD, int maPhong, int thang, int soCu, int soMoi, float donGia, float thanhTien) {
        this.maHDD = maHDD;
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.thang = thang;
        this.soCu = soCu;
        this.soMoi = soMoi;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHDD() {
        return maHDD;
    }

    public void setMaHDD(String maHDD) {
        this.maHDD = maHDD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSoCu() {
        return soCu;
    }

    public void setSoCu(int soCu) {
        this.soCu = soCu;
    }

    public int getSoMoi() {
        return soMoi;
    }

    public void setSoMoi(int soMoi) {
        this.soMoi = soMoi;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
