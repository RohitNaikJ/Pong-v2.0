/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit
 */
public class OptionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form OptionsPanel
     */
    public OptionsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton1.setText("Hard");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(650, 100, 180, 50);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LEVEL");
        add(jLabel2);
        jLabel2.setBounds(500, 40, 120, 40);

        jButton4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton4.setText("Easy");
        jButton4.setActionCommand("Easy");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                easyClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(290, 100, 180, 50);

        jButton5.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton5.setText("Medium");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mediumClicked(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(470, 100, 180, 50);

        jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton2.setText("Water");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                waterClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(650, 260, 180, 50);

        jButton6.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton6.setText("Fire");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireClicked(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(290, 260, 180, 50);

        jButton7.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton7.setText("Classic");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classicClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7);
        jButton7.setBounds(470, 260, 180, 50);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("THEME");
        add(jLabel4);
        jLabel4.setBounds(500, 210, 130, 40);

        jButton3.setFont(new java.awt.Font("Rosewood Std", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("/Users/Rohit/Downloads/backicon.png")); // NOI18N
        jButton3.setText("Back");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backClicked(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(500, 480, 120, 50);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MAX POINTS ");
        add(jLabel5);
        jLabel5.setBounds(450, 360, 246, 43);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1");
        add(jLabel1);
        jLabel1.setBounds(550, 420, 24, 30);

        jButton8.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uparrow.png"))); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8);
        jButton8.setBounds(610, 410, 40, 40);

        jButton10.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/downarrow.png"))); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10);
        jButton10.setBounds(470, 410, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/optionsbackground.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1120, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void easyClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_easyClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_easyClicked

    private void mediumClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mediumClicked

    private void hardClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hardClicked

    private void fireClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fireClicked

    private void classicClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classicClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_classicClicked

    private void waterClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_waterClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_waterClicked

    private void backClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backClicked
        // TODO add your handling code here:
//        optionsChecked = false;
//        fScreen.getContentPane().removeAll();
//        fScreen.initComponents();
    }//GEN-LAST:event_backClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
