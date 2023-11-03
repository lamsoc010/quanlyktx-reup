/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SinhVienDao;
import java.util.List;
import BEANS.SinhVien;
import BEANS.ThongKeSV;

/**
 *
 * @author Admin
 */
public class SinhVienService {
    SinhVienDao sinhVienDao;

    public SinhVienService() {
        sinhVienDao = new SinhVienDao();
    }
    
    public List<SinhVien> getAllSinhViens() {
        return sinhVienDao.getAllSinhViens();
    }
    
    public void insertSinhVien(SinhVien sV) {
        sinhVienDao.insertSinhVien(sV);
    }
    
    public SinhVien getSinhVienByMaSV(String maSV) {
        return sinhVienDao.getAllSinhVienByMaSV(maSV);
    }
    
    public void updateSinhVien(SinhVien sV) {
        sinhVienDao.updateSinhVien(sV);
    }
    
    public List<SinhVien> searchSinhVien(String sql) {
        return sinhVienDao.searchSinhVien(sql);
    }
    
   
}
