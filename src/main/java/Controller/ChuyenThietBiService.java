/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChuyenThietBiDao;
import java.util.List;
import BEANS.ChuyenThietBi;

/**
 *
 * @author Admin
 */
public class ChuyenThietBiService {
    ChuyenThietBiDao chuyenThietBiDao;

    public ChuyenThietBiService() {
        chuyenThietBiDao = new ChuyenThietBiDao();
    }
    
    public List<ChuyenThietBi> getAllChuyenTBs() {
        return chuyenThietBiDao.getAllChuyenTBs();
    }
    
    public void insertCTB(ChuyenThietBi cTB) {
        chuyenThietBiDao.insertCTB(cTB);
    }
    
}
