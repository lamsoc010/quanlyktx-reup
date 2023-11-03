/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PhongDao;
import java.util.List;
import BEANS.Phong;

/**
 *
 * @author Admin
 */
public class PhongService {
    PhongDao phongDao;

    public PhongService() {
        phongDao = new PhongDao();
    }
    
    public List<Phong> getAllPhongs() {
        return phongDao.getAllPhongs();
    }
    
    public void insertPhong(Phong p) {
        phongDao.insertPhong(p);
    }
    
    public void deletePhong(int maPhong) {
        phongDao.deletePhong(maPhong);
    }
    
    public void updatePhong(Phong p) {
        phongDao.updatePhong(p);
    }
    
    public Phong getPhongByMaPhong(int maPhong) {
        return phongDao.getPhongByMaPhong(maPhong);
    }
    
}
