/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEANS;

/**
 *
 * @author Admin
 */
public class Phong {
    int maPhong;
    String loaiPhong;
    int soGiuong;
    int soNguoi;
    double giaTien;
    String trangThai;

    public Phong() {
    }

    public Phong(int maPhong, String loaiPhong, int soGiuong, int soNguoi, double giaTien, String trangThai) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.soGiuong = soGiuong;
        this.soNguoi = soNguoi;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    
}
