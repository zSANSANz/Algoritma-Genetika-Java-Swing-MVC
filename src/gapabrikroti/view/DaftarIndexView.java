/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.view;

import gapabrikroti.controller.DaftarIndexController;
import gapabrikroti.dao.DaftarIndexDAO;
import gapabrikroti.error.DaftarIndexException;
import gapabrikroti.model.DaftarIndex;
import gapabrikroti.service.DaftarIndexService;
import gapabrikroti.service.DaftarIndexServiceImpl;
import gapabrikroti.service.DaftarIndexServiceTable;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cvgs
 */
public class DaftarIndexView extends javax.swing.JFrame implements DaftarIndexService, ListSelectionListener{

    /**
     * Creates new form daftar_index
     */
    
    private DaftarIndexServiceTable daftarIndexServiceTable;
    private DaftarIndexServiceImpl daftarIndexServiceImpl;
    private DaftarIndexController daftarIndexController;
    
    public DaftarIndexView() throws SQLException, DaftarIndexException {
        daftarIndexServiceImpl = new DaftarIndexServiceImpl();
        daftarIndexServiceImpl.setDaftarIndexService(this);

        daftarIndexController = new DaftarIndexController();
        daftarIndexController.setDaftarIndex(daftarIndexServiceImpl);

        daftarIndexServiceTable = new DaftarIndexServiceTable();
        
        initComponents();
        
        tblDaftarIndex.getSelectionModel().addListSelectionListener(this);
        tblDaftarIndex.setModel(daftarIndexServiceTable);

        loadTblDaftarIndex();
        
        labelId.setVisible(false);
        textId.setVisible(false);
        
        labelId.setEnabled(false);
        textId.setEnabled(false);
    }

    public JTable getTblDaftarIndex() {
        return tblDaftarIndex;
    }

    public JTextField getTextDeskripsi() {
        return textDeskripsi;
    }

    public JTextField getTextId() {
        return textId;
    }

    public JTextField getTextIstilah() {
        return textIstilah;
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
        textIstilah = new javax.swing.JTextField();
        textDeskripsi = new javax.swing.JTextField();
        cmdDelete = new javax.swing.JButton();
        cmdReset = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarIndex = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("istilah");

        jLabel2.setText("deskripsi");

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdReset.setText("Reset");
        cmdReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResetActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        tblDaftarIndex.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblDaftarIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDaftarIndex.setRowHeight(22);
        jScrollPane1.setViewportView(tblDaftarIndex);

        jLabel4.setText("Daftar Index view");

        labelId.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(cmdSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textIstilah)
                                    .addComponent(textDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(labelId)
                                .addGap(18, 18, 18)
                                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textIstilah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdDelete)
                    .addComponent(cmdReset)
                    .addComponent(cmdUpdate))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        try {
            daftarIndexController.deleteDaftarIndex(this);
            loadTblDaftarIndex();
            tblDaftarIndex.setVisible(false);
            tblDaftarIndex.setVisible(true);
            labelId.setVisible(false);
            textId.setVisible(false);
            labelId.setVisible(false);
            textId.setVisible(false);
        } catch (SQLException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        } catch (DaftarIndexException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResetActionPerformed
        try {
            daftarIndexController.resetDaftarIndex(this);
            loadTblDaftarIndex();
            tblDaftarIndex.setVisible(false);
            tblDaftarIndex.setVisible(true);
            labelId.setVisible(false);
            textId.setVisible(false);
        } catch (SQLException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        } catch (DaftarIndexException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        }
    }//GEN-LAST:event_cmdResetActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        try {
            daftarIndexController.updateDaftarIndex(this);
            loadTblDaftarIndex();
            tblDaftarIndex.setVisible(false);
            tblDaftarIndex.setVisible(true);
            labelId.setVisible(false);
            textId.setVisible(false);
        } catch (SQLException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        } catch (DaftarIndexException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed
        try {
            daftarIndexController.insertDaftarIndex(this);
            loadTblDaftarIndex();
            tblDaftarIndex.setVisible(false);
            tblDaftarIndex.setVisible(true);
            labelId.setVisible(false);
            textId.setVisible(false);
        } catch (SQLException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        } catch (DaftarIndexException exception) {
            Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, exception);
        }
    }//GEN-LAST:event_cmdSimpanActionPerformed

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
            java.util.logging.Logger.getLogger(DaftarIndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarIndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarIndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarIndexView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DaftarIndexView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DaftarIndexException ex) {
                    Logger.getLogger(DaftarIndexView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdReset;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelId;
    private javax.swing.JTable tblDaftarIndex;
    private javax.swing.JTextField textDeskripsi;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textIstilah;
    // End of variables declaration//GEN-END:variables

    private void loadTblDaftarIndex() throws SQLException, DaftarIndexException {
        DaftarIndexDAO daftarIndexDAO = databaseUtility.getDaftarIndexDAO();
        daftarIndexServiceTable.setList(daftarIndexDAO.getAllDaftarIndex());

    }

    @Override
    public void onChange(DaftarIndexServiceImpl daftarIndexServiceImpl) {
        textId.setText(String.valueOf(daftarIndexServiceImpl.getId()));
        textIstilah.setText(daftarIndexServiceImpl.getIstilah());
        textDeskripsi.setText(daftarIndexServiceImpl.getDeskripsi());
    }

    @Override
    public void onInsert(DaftarIndex daftarIndex) {
        daftarIndexServiceTable.add(daftarIndex);
    }

    @Override
    public void onUpdate(DaftarIndex daftarIndex) {
        int index = tblDaftarIndex.getSelectedRowCount();
        daftarIndexServiceTable.set(index, daftarIndex);
    }

    @Override
    public void onDelete() {
        int index = tblDaftarIndex.getSelectedRowCount();
        daftarIndexServiceTable.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        DaftarIndex daftarIndex = daftarIndexServiceTable.get(e.getFirstIndex());
        textId.setText(String.valueOf(daftarIndex.getId()));
        textIstilah.setText(daftarIndex.getIstilah());
        textDeskripsi.setText(daftarIndex.getDeskripsi());
        labelId.setVisible(true);
        textId.setVisible(true);
    }

}
