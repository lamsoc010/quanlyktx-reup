/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEANS;

/**
 *
 * @author Admin
 */
public class QuanLy {
    String maQL, anh, hoTen, sdt, diaChi, phuTrach, matKhau, trangThai;

    public QuanLy() {
    }

    public QuanLy(String maQL, String anh, String hoTen, String sdt, String diaChi, String phuTrach, String matKhau, String trangThai) {
        this.maQL = maQL;
        this.anh = anh;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.phuTrach = phuTrach;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }


    public String getMaQL() {
        return maQL;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhuTrach() {
        return phuTrach;
    }

    public void setPhuTrach(String phuTrach) {
        this.phuTrach = phuTrach;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
