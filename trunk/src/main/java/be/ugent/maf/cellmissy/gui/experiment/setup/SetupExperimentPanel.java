/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SetupExperimentPanel.java
 *
 * Created on Mar 29, 2012, 9:01:25 AM
 */
package be.ugent.maf.cellmissy.gui.experiment.setup;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Paola
 */
public class SetupExperimentPanel extends javax.swing.JPanel {

    /**
     * Creates new form SetupExperimentPanel
     */
    public SetupExperimentPanel() {
        initComponents();
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JLabel getInfolabel() {
        return infolabel;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public JButton getCopySettingsButton() {
        return copySettingsButton;
    }

    public JButton getImportTemplateButton() {
        return importTemplateButton;
    }

    public JButton getExportTemplateButton() {
        return exportTemplateButton;
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

        topPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        infolabel = new javax.swing.JLabel();
        finishButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        copySettingsButton = new javax.swing.JButton();
        importTemplateButton = new javax.swing.JButton();
        exportTemplateButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.GridBagLayout());

        topPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        topPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.95;
        add(topPanel, gridBagConstraints);

        bottomPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        previousButton.setText("<< Previous");
        previousButton.setToolTipText("Go back");

        nextButton.setText("Next >>");
        nextButton.setToolTipText("Go next");

        infolabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        finishButton.setText("Finish");
        finishButton.setToolTipText("Finish the current set-up: save the experiment to the DB");

        reportButton.setText("PDF Report");
        reportButton.setToolTipText("Create a PDF file with set-up for current experiment");

        copySettingsButton.setText("Copy settings...");
        copySettingsButton.setToolTipText("Copy the set-up settings from another experiment from this project");

        importTemplateButton.setText("Import template...");
        importTemplateButton.setToolTipText("Import an XMLfile and use it as template for the current experiment set-up");

        exportTemplateButton.setText("Export template...");
        exportTemplateButton.setToolTipText("Export the current experiment set-up to an XML file template");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infolabel, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importTemplateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copySettingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportTemplateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addContainerGap())
        );

        bottomPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {copySettingsButton, finishButton, nextButton, previousButton, reportButton});

        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(previousButton)
                        .addComponent(nextButton)
                        .addComponent(finishButton)
                        .addComponent(reportButton)
                        .addComponent(copySettingsButton)
                        .addComponent(importTemplateButton)
                        .addComponent(exportTemplateButton))
                    .addComponent(infolabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(bottomPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton copySettingsButton;
    private javax.swing.JButton exportTemplateButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton importTemplateButton;
    private javax.swing.JLabel infolabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton reportButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
