/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HoaDonDienDao;
import java.util.List;
import BEANS.HoaDonDien;

/**
 *
 * @author Admin
 */
public class HoaDonDienService {
    HoaDonDienDao hoaDonDienDao;

    public HoaDonDienService() {
        hoaDonDienDao = new HoaDonDienDao();
    }
    
    public List<HoaDonDien> getAllHoaDonDiens() {
        return hoaDonDienDao.getAllHoaDonDiens();
    }
    
    public HoaDonDien getTienDienByMaHD(String maHD){
        return hoaDonDienDao.getTienDienByMaHD(maHD);
    }
    
    public void insertHoaDonDien(HoaDonDien hDD) {
        hoaDonDienDao.insertHoaDonDien(hDD);
    }
    
    public void updateHoaDonDien(HoaDonDien hDD) {
        hoaDonDienDao.updateHoaDonDien(hDD);
    }
    
}
