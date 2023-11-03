/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.JDBCConnection;
import Model.KyLuatDao;
import java.util.List;
import javax.swing.text.html.HTML;
import BEANS.KyLuat;
import BEANS.ThongKeKL;

/**
 *
 * @author Admin
 */
public class KyLuatService {
    KyLuatDao kyLuatDao;

    public KyLuatService() {
        kyLuatDao = new KyLuatDao();
    }
    
    public List<KyLuat> getAllKyLuats() {
        return kyLuatDao.getAllKyLuats();
    }
    
    public void updateKyLuat(KyLuat kL) {
        kyLuatDao.updateKyLuat(kL);
    }
    
    public void insertKyLuat(KyLuat kL) {
        kyLuatDao.insertKyLuat(kL);
    }
    
    public KyLuat getKyLuatByMaPhieu(int maPhieu) {
        return kyLuatDao.getKyLuatByMaPhieu(maPhieu);
    }
    
    public List<KyLuat> thongKeKL(String sql) {
        return kyLuatDao.thongKeKL(sql); 
    }
    
    public List<ThongKeKL> thongKeKLSV(String sql) {
        return kyLuatDao.thongKeKLSV(sql);
    }
    
}
