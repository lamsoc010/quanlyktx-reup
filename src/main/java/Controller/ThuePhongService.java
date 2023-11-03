/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ThuePhongDao;
import java.util.Date;
import java.util.List;
import BEANS.ThongKeSV;
import BEANS.ThuePhong;

/**
 *
 * @author Admin
 */
public class ThuePhongService {
    ThuePhongDao thuePhongDao;

    public ThuePhongService() {
        thuePhongDao = new ThuePhongDao();
    }
    
    public List<ThuePhong> getAllThuePhongs() {
        return thuePhongDao.getAllThuePhongs();
    }
    
    public void insertThuePhong(ThuePhong tP) {
        thuePhongDao.insertThuePhong(tP);
    }
    
    public void updateNgayVaoThuePhong(Date ngayVao, int maPhieu) {
        thuePhongDao.updateNgayVaoThuePhong(ngayVao, maPhieu);
    }
    
     public List<ThongKeSV> thongKeSVTP(String sql) {
        return thuePhongDao.thongKeSVTP(sql);
    }
    
}
