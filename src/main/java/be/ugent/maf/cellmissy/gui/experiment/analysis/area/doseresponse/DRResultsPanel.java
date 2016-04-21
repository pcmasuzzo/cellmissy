/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis.area.doseresponse;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gwendolien
 */
public class DRResultsPanel extends javax.swing.JPanel {

    /**
     * Creates new form DRResultsPanel
     */
    public DRResultsPanel() {
        initComponents();
    }

    public JPanel getDoseResponseChartParentPanel() {
        return doseResponseChartParentPanel;
    }

    public JButton getCreateReportButton() {
        return createReportButton;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        createReportButton = new javax.swing.JButton();
        doseResponseChartParentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        createReportButton.setText("Create & Save PDF Report");
        createReportButton.setToolTipText("Create a PDF report for this analysis and save it");
        createReportButton.setMinimumSize(new java.awt.Dimension(20, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        add(createReportButton, gridBagConstraints);

        doseResponseChartParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        doseResponseChartParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        doseResponseChartParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        doseResponseChartParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        add(doseResponseChartParentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createReportButton;
    private javax.swing.JPanel doseResponseChartParentPanel;
    // End of variables declaration//GEN-END:variables
}
