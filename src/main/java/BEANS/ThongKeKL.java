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
public class ThongKeKL {
    int soSV;
    Date ngayViPham;

    public ThongKeKL() {
    }

    public ThongKeKL(int soSV, Date ngayViPham) {
        this.soSV = soSV;
        this.ngayViPham = ngayViPham;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public Date getNgayViPham() {
        return ngayViPham;
    }

    public void setNgayViPham(Date ngayViPham) {
        this.ngayViPham = ngayViPham;
    }
    
}
