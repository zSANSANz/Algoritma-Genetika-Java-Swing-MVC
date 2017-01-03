/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.view;

import gapabrikroti.controller.KoordinatController;
import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.dao.ParameterDAO;
import gapabrikroti.error.CrossOverException;
import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.error.MutasiException;
import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.error.ParameterException;
import gapabrikroti.error.PopulasiException;
import gapabrikroti.error.RataRataException;
import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.error.UserException;
import gapabrikroti.model.EvaluasiGeneration;
import gapabrikroti.model.Koordinat;
import gapabrikroti.service.KoordinatService;
import gapabrikroti.service.KoordinatServiceImpl;
import gapabrikroti.service.KoordinatServiceTable;
import gapabrikroti.utility.databaseUtility;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

/**
 *
 * @author cvgs
 */
public class MenuView extends javax.swing.JFrame implements KoordinatService {

    private KoordinatServiceTable koordinatServiceTable;
    private KoordinatServiceImpl koordinatServiceImpl;
    private KoordinatController koordinatController;

    DecimalFormat df = new DecimalFormat("#.##");
    HasilPerhitunganView hasilPerhitunganView;
    Boolean hasil = false;

    public MenuView() throws SQLException, ParameterException, IOException, KoordinatException {
        koordinatServiceImpl = new KoordinatServiceImpl();
        koordinatServiceImpl.setKoordinatService(this);

        koordinatController = new KoordinatController();
        koordinatController.setKoordinat(koordinatServiceImpl);

        koordinatServiceTable = new KoordinatServiceTable();

        initComponents();

        ParameterDAO parameterDAO = databaseUtility.getParameterDAO();

        double PopSize, Pc, Pm, Pk, G;

        G = parameterDAO.getParameterByNamaParameter("generasi").getNilai();

        textG.enable(false);
        textG.setText(df.format(G));

        JPanel drawingPanel = new DrawingPanel();

        jTabbedPane1.addTab("Awal", drawingPanel);
        JFrame frame = new JFrame("Drawing Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public JTextField getTextG() {
        return textG;
    }

    public void setTextG(JTextField textG) {
        this.textG = textG;
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
        jLabel1 = new javax.swing.JLabel();
        textG = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDMin2 = new javax.swing.JTextField();
        txtDMin1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDMan1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDMan2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("PROSES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Masukkan Jumlah Generasi :");

        textG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGActionPerformed(evt);
            }
        });

        jLabel2.setText("Jarak terdekat dari Makasar :");

        jLabel3.setText("Jarak terdekat dari Pontianak :");

        jLabel4.setText("Jarak terjauh dari Makasar :");

        jLabel5.setText("Jarak terjauh dari Pontianak :");

        jMenu2.setText("Hasil Perhitungan dan Iterasi");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Hasil Perhitungan");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Iterasi atau Generasi");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Grafik");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Data dan Parameter");

        jMenuItem2.setText("Koordinat");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Parameter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Pengguna");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textG, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtDMan1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDMan2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDMin2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtDMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDMin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtDMan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDMan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JPanel drawingPanel = new DrawingPanelHasil();
            
            jTabbedPane1.addTab("Hasil", drawingPanel);
            JFrame frame = new JFrame("Drawing Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textGActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            KoordinatView koordinatView = new KoordinatView();
            koordinatView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KoordinatException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            ParameterView parameterView = new ParameterView();
            parameterView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParameterException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            UserView userView = new UserView();
            userView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        hasilPerhitunganView = null;
        SwingWorker sw = new SwingWorker() {

            protected Object doInBackground() throws Exception {

                jProgressBar1.setIndeterminate(true);
                try {
                    hasilPerhitunganView = new HasilPerhitunganView();
                    hasil = true;
                } catch (SQLException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KoordinatException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParameterException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PopulasiException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EvaluasiException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RataRataException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RouleteWheelException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CrossOverException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MutasiException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EvaluasiGenerationException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RouleteWheelGenerationException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CrossOverGenerationException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MutasiGenerationException ex) {
                    hasil = false;
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;

            }

            public void done() {
                jProgressBar1.setIndeterminate(false);
                jProgressBar1.setValue(100); // 100%

                if (hasil) {
                    hasilPerhitunganView.getTextGHasil().setText(textG.getText());
                    hasilPerhitunganView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Terdapat kesalahan");
                }
            }

        };

        sw.execute();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            HasilIterasiView hasilItereasiView = new HasilIterasiView();
            hasilItereasiView.setVisible(true);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RouleteWheelGenerationException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CrossOverGenerationException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MutasiGenerationException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int generasi, noChromosome;
        double fitness;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        try {
            EvaluasiGenerationDAO evaluasiGenerationDAO;
            evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
            List<EvaluasiGeneration> evaluasiGeneration = evaluasiGenerationDAO.getAllEvaluasiGeneration();
            //membangkitkan evaluasi
            for (EvaluasiGeneration itemEvaluasi : evaluasiGeneration) {
                noChromosome = itemEvaluasi.getNoEvaluasi();
                fitness = itemEvaluasi.getFitness();
                generasi = itemEvaluasi.getGenerationNo();

                String Generasi = String.valueOf(generasi);
                String Fitness = String.valueOf(fitness);
                String NoChromosome = String.valueOf(noChromosome);

                dataSet.addValue(fitness, Generasi, NoChromosome);

            }

            JFreeChart chartbar = ChartFactory.createBarChart3D("Grafik Fitness", "Chromosome", "Fitness", dataSet, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame frame = new ChartFrame("Grafik Fitness per Chromosome", chartbar);
            frame.setVisible(true);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Grafik Fitness");
        } catch (SQLException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    new MenuView().add(new DrawingPanel());
                    new MenuView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParameterException ex) {
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KoordinatException ex) {
                    Logger.getLogger(MenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField textG;
    private javax.swing.JTextField txtDMan1;
    private javax.swing.JTextField txtDMan2;
    private javax.swing.JTextField txtDMin1;
    private javax.swing.JTextField txtDMin2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(KoordinatServiceImpl koordinatServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(Koordinat koordinat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(Koordinat koordinat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}