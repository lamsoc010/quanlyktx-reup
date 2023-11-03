///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Controller;
//
//import BEANS.DanhMucBean;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.List;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
///**
// *
// * @author Admin
// */
//public class ChuyenDanhMucController {
//    private JPanel root;
//    private String kinSelected = "";
//    
//    private List<DanhMucBean> listItem = null;
//    
//    public ChuyenDanhMucController(JPanel jPanelRoot) {
//        this.root = jPanelRoot;
//    }
//    
//    public void setView(JPanel jPanelItem, JLabel jLabelItem) {
//        kinSelected = "ThongKe";
//        
//        jPanelItem.setBackground(new Color(96,100, 191));
//        jLabelItem.setBackground(new Color(96,100, 191));
//        
//        root.removeAll();
//        root.setLayout(new BorderLayout());
//        root.add(root);
//        root.validate();
//        root.repaint();
//    }
//    
//    public void setEvent(List<DanhMucBean> listItem) {
//        this.listItem = listItem;
//        for (DanhMucBean item : listItem) {
//            item.getjLabel().addMouseListener(l);
//        }
//    }
//    
//       
//    class LabelEvent implements MouseListener {
//        private JPanel node;
//        private String kind;
//        
//        private JPanel jPanelItem;
//        private JPanel jPanelChuyenTab;
//        private JLabel jLabelItem;
//
//        public LabelEvent(String kind, JPanel jPanelItem, JPanel jPanelChuyenTab, JLabel jLabelItem) {
//            this.kind = kind;
//            this.jPanelItem = jPanelItem;
//            this.jPanelChuyenTab = jPanelChuyenTab;
//            this.jLabelItem = jLabelItem;
//        }
//
//       
//        
//        
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            switch(kind) {
//                case "ThongKe": 
//                    jPanelChuyenTab.setVisible(true);
//                    break;
//                case "ThuChi": 
//                    jPanelChuyenTab.setVisible(true);
//                    break;
//            }
//            root.removeAll();
//            root.setLayout(new BorderLayout());
//            root.add(root);
//            root.validate();
//            root.repaint();
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//        }
//        
//    }
//}
