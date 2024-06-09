/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package homePage;
import swing.Background;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import model.modelItem;
import javax.swing.ImageIcon;
import service.service_item;
import java.util.List;
import Dao.dao_ShowItem;
import java.awt.Dimension;
import java.awt.Point;
import service.service_ItemDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import config.token;
import login_and_register.FromLogin;
import Dao.dao_login;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import service.service_login;
import model.model_pengguna;
/**
 *
 * @author oyest
 */
public class home extends javax.swing.JFrame {
      int xx,xy;
      private main mainU;
      private service_ItemDAO itemDao;
      private Animator animator;
      private Point animatePoint;
      private modelItem itemSelected;
      private String token1;
      private String username;
      private service_login service;
    /**
     * Creates new form home
     * @param token1
     */
    public home(String token1) throws IOException {
        this.token1 = token1;
        this.username = token.getUsernameFromToken(token1);
        initComponents();
        setBackground(new Color(0,0,0,0));
        itemDao = new dao_ShowItem();
  
        init();
        //  Animator start form animatePoint to TagetPoint
        animator = PropertySetter.createAnimator(500, mainPanel, "ImageLocation", animatePoint, mainPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel, "imageSize", new Dimension(180, 120), mainPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        
           if (!isTokenValid()) {
            JOptionPane.showMessageDialog(this, "Token tidak valid atau telah kadaluarsa, silakan login kembali.", "Error", JOptionPane.ERROR_MESSAGE);
            new FromLogin().setVisible(true);
            this.dispose();
        }
    }
     private boolean isTokenValid() {
        return token.validateToken(this.token1);
    }
         private void loadUserData() {
        try {
            model_pengguna user = service.getUserByUsername(username);
            if (user != null && user.getFoto() != null) {
                displayImage(user.getFoto());
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
       }
     private void displayImage(InputStream foto) throws IOException {
        if (foto != null) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int nRead;
            while ((nRead = foto.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            ImageIcon imageIcon = new ImageIcon(buffer.toByteArray());
            imageAvatar2.setImage(imageIcon);
        }
    }
    
    
    private void init() throws IOException{
          mainU = new main();
          mainPanel.setLayout(new BorderLayout());
          mainPanel.add(mainU);
          testData();
          setLocationRelativeTo(null);
          jLabel1.setText("Selamat Datang  " + username);
          service = new dao_login();
          loadUserData();
       
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new swing.Background();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imageAvatar2 = new swing.ImageAvatar();
        mainPanel = new swing.MainPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        header.setBackground(new java.awt.Color(159, 21, 33));
        header.setForeground(new java.awt.Color(159, 21, 33));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setText("Selamat Datang ");

        imageAvatar2.setBorderColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(159, 21, 33));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx,y - xy);  
    }//GEN-LAST:event_formMouseDragged
                    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
             xx = evt.getX();
             xy = evt.getY();
    }//GEN-LAST:event_formMousePressed
  
    private void testData(){
        mainU.setEvent(new service_item(){
            @Override
            public void itemClick(Component com, modelItem item) {
                System.out.println(item.getItemID());
               
                if(itemSelected != item){
                    if(!animator.isRunning()){
                        itemSelected=item;
                        animatePoint = getLocationOf(com);
                        mainPanel.setImage(item.getImage());
                        mainPanel.setImageLocation(animatePoint);
                        mainPanel.setImageSize(new Dimension(180, 120));
                        mainPanel.repaint();
                        mainU.setSelected(com);
                        mainU.showItem(item);
                        animator.start();
                        
                    }
                }

            }
            
        });
        try{
        List<modelItem> items = itemDao.getAllItems();
        for(modelItem itemD : items){
            mainU.addItem(itemD);
        } 
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
//        int  ID = 1;
//            for(int i=0; i<5; i++){
//                mainU.addItem(new modelItem(ID++,"Sepatu Jawir","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin lacinia sit amet nulla eu fringilla. Nunc quis dolor vel elit finibus sagittis. Suspendisse risus risus, rutrum a commodo nec, facilisis in est. Donec mi turpis, hendrerit eget risus nec, mattis scelerisque ante. Integer ut ex in quam consectetur ultrices sit amet et mauris. Sed mollis condimentum augue, iaculis sodales leo ullamcorper in. Donec id diam at magna efficitur dignissim. Cras volutpat rhoncus lorem, sit amet viverra ex ultricies at.",160,"Ajawa", 10,new ImageIcon(getClass().getResource("/"))));
//                mainU.addItem(new modelItem(ID++,"Makanan Kucing","Description",70,"Royal Canin",10, new ImageIcon(getClass().getResource("/"))));
//            }
        
        
    }
     private Point getLocationOf(Component com) {
        Point p = mainU.getPanelLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new home("dummyToken").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Background background1;
    private javax.swing.JPanel header;
    private swing.ImageAvatar imageAvatar2;
    private javax.swing.JLabel jLabel1;
    private swing.MainPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
