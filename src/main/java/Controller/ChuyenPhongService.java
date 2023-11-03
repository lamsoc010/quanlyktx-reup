/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChuyenPhongDao;
import java.util.List;
import BEANS.ChuyenPhong;

/**
 *
 * @author Admin
 */
public class ChuyenPhongService {
    ChuyenPhongDao chuyenPhongDao;

    public ChuyenPhongService() {
        chuyenPhongDao = new ChuyenPhongDao();
    }
    
    public List<ChuyenPhong> getAllChuyenPhongs() {
        return chuyenPhongDao.getAllChuyenPhongs();
    }
    
    public void insertChuyenPhong(ChuyenPhong cP) {
        chuyenPhongDao.insertChuyenPhong(cP);
    }
    
    public void updateChuyenPhong(ChuyenPhong cP) {
        chuyenPhongDao.updateChuyenPhong(cP);
    }
    
    public ChuyenPhong getChuyenPhongByMaPhieu(int maPhieu) {
        return chuyenPhongDao.getChuyenPhongByMaPhieu(maPhieu);
    }
    
}
