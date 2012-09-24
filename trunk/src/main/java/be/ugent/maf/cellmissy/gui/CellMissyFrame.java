/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CellMissyFrame.java
 *
 * Created on Mar 27, 2012, 4:45:13 PM
 */
package be.ugent.maf.cellmissy.gui;

import be.ugent.maf.cellmissy.gui.controller.CellMissyController;
import be.ugent.maf.cellmissy.spring.ApplicationContextProvider;
import javax.swing.JPanel;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Paola
 */
public class CellMissyFrame extends javax.swing.JFrame {

    /** Creates new form CellMissyFrame */
    public CellMissyFrame() {
        initComponents();
    }

    public JPanel getExperimentSetupParentPanel() {
        return experimentSetupParentPanel;
    }

    public JPanel getOverviewPanel() {
        return overviewParentPanel;
    }

    public JPanel getUserParentPanel() {
        return userParentPanel;
    }

    public JPanel getLoadExperimentParentPanel() {
        return loadExperimentParentPanel;
    }

    public JPanel getDataAnalysisParentPanel() {
        return dataAnalysisParentPanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        overviewParentPanel = new javax.swing.JPanel();
        userParentPanel = new javax.swing.JPanel();
        experimentSetupParentPanel = new javax.swing.JPanel();
        loadExperimentParentPanel = new javax.swing.JPanel();
        dataAnalysisParentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(30, 5, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(120, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        jTabbedPane1.setOpaque(true);

        overviewParentPanel.setOpaque(false);
        overviewParentPanel.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Overview", overviewParentPanel);

        userParentPanel.setOpaque(false);
        userParentPanel.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("User Management", userParentPanel);

        experimentSetupParentPanel.setOpaque(false);
        experimentSetupParentPanel.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Experiment Set-up", experimentSetupParentPanel);

        loadExperimentParentPanel.setOpaque(false);
        loadExperimentParentPanel.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Load CellMIA Data", loadExperimentParentPanel);

        dataAnalysisParentPanel.setOpaque(false);
        dataAnalysisParentPanel.setLayout(new java.awt.GridBagLayout());
        jTabbedPane1.addTab("Data Analysis", dataAnalysisParentPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CellMissyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CellMissyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CellMissyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CellMissyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ApplicationContext context = ApplicationContextProvider.getInstance().getApplicationContext();
                CellMissyController cellMissyController = (CellMissyController) context.getBean("cellMissyController");
                cellMissyController.init();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataAnalysisParentPanel;
    private javax.swing.JPanel experimentSetupParentPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel loadExperimentParentPanel;
    private javax.swing.JPanel overviewParentPanel;
    private javax.swing.JPanel userParentPanel;
    // End of variables declaration//GEN-END:variables
}
