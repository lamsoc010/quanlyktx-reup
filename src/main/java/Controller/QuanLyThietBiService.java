/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BEANS.QuanLyThietBi;
import Model.QuanLyThietBiDao;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuanLyThietBiService {
    QuanLyThietBiDao quanLyThietBiDao;

    public QuanLyThietBiService() {
        quanLyThietBiDao = new QuanLyThietBiDao();
    }
    
    public List<QuanLyThietBi> getAllQLTBs() {
        return quanLyThietBiDao.getAllQLTBs();
    }
    
    public QuanLyThietBi getQLTBByMaTB(String maTB, int maPhong) {
        return quanLyThietBiDao.getQLTBByMaTB(maTB, maPhong);
    }
    
    public void insertQLTB(QuanLyThietBi qLTB) {
        quanLyThietBiDao.insertQLTB(qLTB);
    }
    
    public void updateQLTB(QuanLyThietBi qLTB) {
        quanLyThietBiDao.updateQLTB(qLTB);
    }
    
    public void removeQLTB(QuanLyThietBi qLTB) {
        quanLyThietBiDao.removeQLTB(qLTB);
    }
    
}
