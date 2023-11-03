/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.QuanLyDao;
import java.util.List;
import BEANS.QuanLy;

/**
 *
 * @author Admin
 */
public class QuanLyService {
    QuanLyDao quanLyDao;

    public QuanLyService() {
        quanLyDao = new QuanLyDao();
    }
    
    public List<QuanLy> getAllQuanLys() {
        return quanLyDao.getAllQuanLys();
    }
    
    public void updateQuanLy(QuanLy qL) {
        quanLyDao.updateQuanLy(qL);
    }
    
    public QuanLy getQuanLyByMaQL(String maQL) {
        return quanLyDao.getQuanLyByMaQL(maQL);
    }
    
    public void insertQL(QuanLy qL) {
        quanLyDao.insertQuanLy(qL);
    }
}
