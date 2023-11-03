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
public class SinhVien {
    String maSV, anh, hoTen, sdt, gioiTinh, diaChi, nganh, khoa, trangThai;
    Date ngaySinh, ngayVao;
    int maPhong, soLanViPham;

    public SinhVien() {
    }

    public SinhVien(String maSV, String anh, String hoTen, String sdt, String gioiTinh, String diaChi, String nganh, String khoa, String trangThai, Date ngaySinh, Date ngayVao, int maPhong, int soLanViPham) {
        this.maSV = maSV;
        this.anh = anh;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.nganh = nganh;
        this.khoa = khoa;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
        this.ngayVao = ngayVao;
        this.maPhong = maPhong;
        this.soLanViPham = soLanViPham;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getSoLanViPham() {
        return soLanViPham;
    }

    public void setSoLanViPham(int soLanViPham) {
        this.soLanViPham = soLanViPham;
    }
    
    
}
