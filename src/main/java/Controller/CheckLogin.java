/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import BEANS.QuanLy;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CheckLogin {

    QuanLyService quanLyService;
    List<QuanLy> listQL;
    QuanLy qL;

    public CheckLogin() {
        quanLyService = new QuanLyService();
        listQL = quanLyService.getAllQuanLys();
    }
    
    public boolean checkNull(String username, String password) {
        if(username.length() == 0 || password.length() == 0) {
            return true;
        }
        return false;
    }

    public boolean checkUserNameEmpty(String userName) {
        for (QuanLy ql : listQL) {
            if (ql.getMaQL().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    public String checkUserNameOut(String userName) {
        for (QuanLy ql : listQL) {
            if (ql.getMaQL().equals(userName) && ql.getTrangThai().equalsIgnoreCase("Đang làm")) {
                return ql.getMaQL();
            }
        }
        return null;
    }
    
    public boolean checkPasswordCharator(String passWord) {
        if(passWord.length() < 8) {
            return true;
        }
        return false;
    }

    public boolean checkPassWord(String userName, String passWord) {
        for (QuanLy ql : listQL) {
            if (checkUserNameOut(userName).equals(ql.getMaQL()) && ql.getMatKhau().equals(passWord)) {
                return true;
            }
        }
        return false;
    }
}
