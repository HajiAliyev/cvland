/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.main;

import com.company.resume.config.FillableInter;
import com.company.resume.config.Config;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;
import com.company.main.Context;
import java.sql.Date;
import java.text.ParseException;

public class MainUser extends javax.swing.JFrame implements FillableInter { //JFrame class-lari desktop app penceresine cevirir. 
    //Class-in pencere formasinda gorunusunu Netbeans edir, eslinde ozu bacarmir.   

    private UserDaoInter userDao = Context.instanceUserDao();

    private CountryDaoInter countryDao = Context.instanceCountryDao();

    public MainUser() {
        Config.loggedInUser = userDao.getUserById(1);//init-den qabaq islemelidiki paneller null goturmesin. init panelleri yukleyir, bos olanda sehv verir. 
        initComponents();
        this.fillUserComponents();
        detailsPanel.fillUserComponents();//Constructorda cagiriram ki, komanda verib Run edende her bir paneli doldursun. 
        profilePanel.fillUserComponents();
        skillsPanel.fillUserComponents();
        employmentHistoryPanel.fillUserComponents();

    }

    @Override
    public void fillUserComponents() {//User dolu gelsin deye bele yaziram. 1-ci bu icra olunur. 
        User loggedInUser = Config.loggedInUser;

        txtName.setText(loggedInUser.getName());
        txtSurname.setText(loggedInUser.getSurname());
    }

    @Override
    public void fillUser(User user) {
        String name = txtName.getText();
        String surname = txtSurname.getText();
        user.setName(name);
        user.setSurname(surname);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        canvas1 = new java.awt.Canvas();
        jSeparator1 = new javax.swing.JSeparator();
        tabbedPaneUserInfo = new javax.swing.JTabbedPane();
        profilePanel = new com.company.panel.ProfilePanel();
        detailsPanel = new com.company.panel.DetailsPanel();
        employmentHistoryPanel = new com.company.panel.EmploymentHistoryPanel();
        skillsPanel = new com.company.panel.SkillsPanel();
        panelUserInfo = new javax.swing.JPanel();
        txtSurname = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPaneUserInfo.addTab("Profile", profilePanel);
        tabbedPaneUserInfo.addTab("Details", detailsPanel);
        tabbedPaneUserInfo.addTab("Employment History", employmentHistoryPanel);
        tabbedPaneUserInfo.addTab("Skills", skillsPanel);

        txtSurname.setToolTipText("Enter your surname");
        txtSurname.setMinimumSize(new java.awt.Dimension(60, 20));
        txtSurname.setName(""); // NOI18N
        txtSurname.setPreferredSize(new java.awt.Dimension(100, 30));
        txtSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSurnameActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblName.setLabelFor(txtName);
        lblName.setText("Name:");
        lblName.setToolTipText("Enter your name");
        lblName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblName.setPreferredSize(new java.awt.Dimension(100, 30));

        txtName.setToolTipText("Enter your name");
        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtName.setMinimumSize(new java.awt.Dimension(60, 20));
        txtName.setName(""); // NOI18N
        txtName.setPreferredSize(new java.awt.Dimension(100, 30));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblSurname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSurname.setLabelFor(txtSurname);
        lblSurname.setText("Surname:");
        lblSurname.setToolTipText("Enter your name");
        lblSurname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSurname.setPreferredSize(new java.awt.Dimension(100, 30));

        buttonSave.setBackground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Save");
        buttonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSave.setPreferredSize(new java.awt.Dimension(80, 30));
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUserInfoLayout = new javax.swing.GroupLayout(panelUserInfo);
        panelUserInfo.setLayout(panelUserInfoLayout);
        panelUserInfoLayout.setHorizontalGroup(
            panelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserInfoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserInfoLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelUserInfoLayout.createSequentialGroup()
                        .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        panelUserInfoLayout.setVerticalGroup(
            panelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPaneUserInfo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSurnameActionPerformed


    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        User user = Config.loggedInUser;
        this.fillUser(user);//User-i 1-ci ozu doldurur, sonra digerlerine gonderir. 
        profilePanel.fillUser(user); //2-ci. Panele hemin user-i gonderirem ki, ozune aid olanlari onlar da doldursun. 
        detailsPanel.fillUser(user);

        userDao.updateUser(user);
    }//GEN-LAST:event_buttonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {//Runnable=dir cunki iceride bir thread yaranacaq amma sirf desktop app-a spesifik olur. adi qaydada olmur.
            public void run() {
                new MainUser().setVisible(true);
                /*setVisible mutleq olmalidir. show() metodunu cagirir.  
                Proqram RUN olmasi bir Thread-de bas verir. 
                Diger thread ise ekranda menim komponentlerimi gosterendir. */
            }
        });

    }
    /*Desing-da palet-den nese elave edende arxa fonda source-a ccevrilir. */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private java.awt.Canvas canvas1;
    private com.company.panel.DetailsPanel detailsPanel;
    private com.company.panel.EmploymentHistoryPanel employmentHistoryPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JPanel panelUserInfo;
    private com.company.panel.ProfilePanel profilePanel;
    private com.company.panel.SkillsPanel skillsPanel;
    private javax.swing.JTabbedPane tabbedPaneUserInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables

}
