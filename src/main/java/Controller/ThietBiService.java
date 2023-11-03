/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ThietBiDao;
import java.util.List;
import BEANS.ThietBi;

/**
 *
 * @author Admin
 */
public class ThietBiService {
    ThietBiDao thietBiDao;

    public ThietBiService() {
        thietBiDao = new ThietBiDao();
    }
    
    public List<ThietBi> getAllThietBis() {
        return thietBiDao.getAllThietBis();
    }
    
    public List<ThietBi> getAllTBByLoaiTB(String loaiTB) {
        return thietBiDao.getAllTBByLoaiTB(loaiTB);
    }
    
     public List<ThietBi> getAllTBByMaPhong(int maPhong) {
        return thietBiDao.getAllTBByMaPhong(maPhong);
    }
    
    public ThietBi getTBByMaTB(String maTB) {
        return thietBiDao.getTBByMaTB(maTB);
    }
    
    public void insertThietBi(ThietBi tB) {
        thietBiDao.insertThietBi(tB);
    }
    
    public void updateThietBi(ThietBi tB) {
        thietBiDao.updateThietBi(tB);
    }
    
    public void deleteTB(String maTB) {
        thietBiDao.deleteTB(maTB);
    }
}
