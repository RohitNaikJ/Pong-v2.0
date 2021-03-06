
import java.awt.Color;
import javax.swing.border.LineBorder;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit
 */
public class ScoreBoard extends javax.swing.JPanel {

    /**
     * Creates new form ScoreBoard
     */
    public ScoreBoard() {
        initComponents();
    }

    public void render(int a, int b, int c, int d){
        if(a!=-1)
            jLabel23.setText(a+"");
        else{
            jLabel2.setForeground(new Color(100,100,100));
            jLabel23.setForeground(new Color(100,100,100));
            jLabel23.setBorder(new LineBorder(new Color(50, 50, 50), 7, true));
            jLabel23.setText("0");
        }
        if(b!=-1)
            jLabel16.setText(b+"");
        else{
            jLabel3.setForeground(new Color(100, 100, 100));
            jLabel16.setForeground(new Color(100, 100, 100));
            jLabel16.setBorder(new LineBorder(new Color(50, 50, 50), 7, true));
            jLabel16.setText("0");
        }
        if(c!=-1)
            jLabel21.setText(c+"");
        else{
            jLabel4.setForeground(new Color(100,100,100));
            jLabel21.setForeground(new Color(100,100,100));
            jLabel21.setBorder(new LineBorder(new Color(50, 50, 50), 7, true));
            jLabel21.setText("0");
        }
        if(d!=-1)
            jLabel22.setText(d+"");
        else{
            jLabel5.setForeground(new Color(100,100,100));
            jLabel22.setForeground(new Color(100,100,100));
            jLabel22.setBorder(new LineBorder(new Color(50, 50, 50), 7, true));
            jLabel22.setText("0");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(48, 206, 255));
        setForeground(new java.awt.Color(0, 51, 51));
        setMaximumSize(new java.awt.Dimension(300, 700));
        setMinimumSize(new java.awt.Dimension(300, 700));
        setPreferredSize(new java.awt.Dimension(300, 700));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SCORE BOARD");
        add(jLabel1);
        jLabel1.setBounds(59, 67, 179, 30);

        jLabel2.setFont(new java.awt.Font("Luminari", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player 1");
        add(jLabel2);
        jLabel2.setBounds(80, 200, 68, 22);

        jLabel3.setFont(new java.awt.Font("Luminari", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player 2");
        add(jLabel3);
        jLabel3.setBounds(80, 260, 68, 22);

        jLabel4.setFont(new java.awt.Font("Luminari", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Player 3");
        add(jLabel4);
        jLabel4.setBounds(80, 320, 68, 22);

        jLabel5.setFont(new java.awt.Font("Luminari", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Player 4");
        add(jLabel5);
        jLabel5.setBounds(80, 380, 68, 22);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hit Space to Pause/Resume");
        add(jLabel6);
        jLabel6.setBounds(32, 457, 238, 22);

        jButton1.setBackground(new java.awt.Color(48, 206, 255));
        jButton1.setFont(new java.awt.Font("Bradley Hand", 1, 18)); // NOI18N
        jButton1.setText("NEW GAME");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(71, 532, 149, 43);

        jButton2.setBackground(new java.awt.Color(48, 206, 255));
        jButton2.setFont(new java.awt.Font("Bradley Hand", 1, 18)); // NOI18N
        jButton2.setText("QUIT");
        add(jButton2);
        jButton2.setBounds(91, 587, 111, 43);

        jLabel12.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(" Lives");
        add(jLabel12);
        jLabel12.setBounds(170, 150, 60, 25);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("3");
        jLabel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 7, true));
        add(jLabel23);
        jLabel23.setBounds(180, 190, 40, 40);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("3");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 7, true));
        add(jLabel16);
        jLabel16.setBounds(180, 250, 40, 40);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("3");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 7, true));
        add(jLabel21);
        jLabel21.setBounds(180, 310, 40, 40);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Luminari", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("3");
        jLabel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 7, true));
        add(jLabel22);
        jLabel22.setBounds(180, 370, 40, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/optionsbackground.jpg"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(-180, 0, 490, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
