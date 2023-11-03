/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TraPhongDao;
import java.util.List;
import BEANS.TraPhong;

/**
 *
 * @author Admin
 */
public class TraPhongService {
    TraPhongDao traPhongDao;

    public TraPhongService() {
        traPhongDao = new TraPhongDao();
    }
    
    public List<TraPhong> getAlLTraPhongs() {
        return traPhongDao.getAllTraPhongs();
    }
    
    public void insertTraPhong(TraPhong tP) {
        traPhongDao.insertTraPhong(tP);
    }
    
    public void updateTraPhong(TraPhong traP) {
        traPhongDao.updateTraPhong(traP);
    }
    
    public TraPhong getTraPByMaPhieu(int maPhieu) {
        return traPhongDao.getTraPByMaPhieu(maPhieu);
    }
}
