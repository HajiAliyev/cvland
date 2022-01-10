/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.panel;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.company.resume.config.Config;
import com.company.resume.config.FillableInter;

/**
 *
 * @author ASUS
 */
public class DetailsPanel extends javax.swing.JPanel implements FillableInter {

    private CountryDaoInter countryDao = Context.instanceCountryDao();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void fillUserComponents() {//User dolu gelsin deye bele yaziram. 
        User loggedInUser = Config.loggedInUser;

        txtPhone.setText(loggedInUser.getPhone());

        txtAddress.setText(loggedInUser.getAddress());

        Date dt = loggedInUser.getBirthdate();
        String dtStr = sdf.format(dt);
        txtBirthDate.setText(dtStr);

        txtEmail.setText(loggedInUser.getEmail());

        System.out.println(loggedInUser.getBirthPlace());

        comboBoxBirthPlace.setSelectedItem(loggedInUser.getBirthPlace());
    }

    @Override
    public void fillUser(User user) {//GUI-den gelenleri User-e yigiram. 
        try {
            String phone = txtPhone.getText();
            String address = txtAddress.getText();
            String birthDate = txtBirthDate.getText();
            
            String email = txtEmail.getText();
            
            java.util.Date dateUtil = sdf.parse(birthDate);
            long l = dateUtil.getTime();//getTime - zamani millisaniye ile ifade edir.  
            java.sql.Date bDate = new java.sql.Date(l);
            
            Country selectedBirthPlace = (Country) comboBoxBirthPlace.getSelectedItem();
            
            user.setPhone(phone);
            user.setAddress(address);
            user.setBirthdate(bDate);
            user.setEmail(email);
            user.setBirthPlace(selectedBirthPlace);
            System.out.println("selectedBirthPlace"+selectedBirthPlace);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public DetailsPanel() {
        initComponents();
        fillWindow();
    }

    private void fillWindow() {
//        comboBoxBirthPlace.addItem(new Country(1,"Azerbaijan","Azerbaijani"));//Country.toString() cagirir ve ekrana verir. 
        List<Country> countryList = countryDao.getCountryList();
        for (Country c : countryList) {
            comboBoxBirthPlace.addItem(c);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDetails = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblBirthDate = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        lblBirthPlace = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        comboBoxNationality = new javax.swing.JComboBox<>();
        comboBoxBirthPlace = new javax.swing.JComboBox<>();

        txtAddress.setToolTipText("Enter your address");
        txtAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAddress.setMinimumSize(new java.awt.Dimension(60, 20));
        txtAddress.setName(""); // NOI18N
        txtAddress.setPreferredSize(new java.awt.Dimension(200, 30));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblAddress.setText("Address:");
        lblAddress.setToolTipText("Enter your name");
        lblAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddress.setPreferredSize(new java.awt.Dimension(100, 30));

        txtPhone.setToolTipText("Enter your phone");
        txtPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPhone.setMinimumSize(new java.awt.Dimension(60, 20));
        txtPhone.setName(""); // NOI18N
        txtPhone.setPreferredSize(new java.awt.Dimension(200, 30));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        lblPhone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPhone.setText("Phone:");
        lblPhone.setToolTipText("Enter your name");
        lblPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPhone.setPreferredSize(new java.awt.Dimension(100, 30));

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblEmail.setText("E-mail:");
        lblEmail.setToolTipText("Enter your name");
        lblEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmail.setPreferredSize(new java.awt.Dimension(100, 30));

        txtEmail.setToolTipText("Enter your e-mail");
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.setMinimumSize(new java.awt.Dimension(60, 20));
        txtEmail.setName(""); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 30));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblBirthDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBirthDate.setText("Birth Date:");
        lblBirthDate.setToolTipText("Enter your name");
        lblBirthDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBirthDate.setPreferredSize(new java.awt.Dimension(100, 30));

        txtBirthDate.setToolTipText("enter your birth date: yyyy-mm-dd");
        txtBirthDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBirthDate.setMinimumSize(new java.awt.Dimension(60, 20));
        txtBirthDate.setName(""); // NOI18N
        txtBirthDate.setPreferredSize(new java.awt.Dimension(200, 30));
        txtBirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthDateActionPerformed(evt);
            }
        });

        lblBirthPlace.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblBirthPlace.setText("Birth Place:");
        lblBirthPlace.setToolTipText("Enter your name");
        lblBirthPlace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBirthPlace.setPreferredSize(new java.awt.Dimension(100, 30));

        lblNationality.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNationality.setText("Nationality:");
        lblNationality.setToolTipText("Enter your name");
        lblNationality.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNationality.setPreferredSize(new java.awt.Dimension(100, 30));

        comboBoxNationality.setToolTipText("Choose your nationality");
        comboBoxNationality.setPreferredSize(new java.awt.Dimension(200, 30));

        comboBoxBirthPlace.setToolTipText("Choose your country");
        comboBoxBirthPlace.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxNationality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxBirthPlace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addComponent(comboBoxBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtBirthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> comboBoxBirthPlace;
    private javax.swing.JComboBox<String> comboBoxNationality;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBirthPlace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
