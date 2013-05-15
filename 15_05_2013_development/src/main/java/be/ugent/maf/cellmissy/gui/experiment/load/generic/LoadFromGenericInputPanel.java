/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoadFromGenericInputPanel.java
 *
 * Created on Jan 11, 2013, 1:38:00 PM
 */
package be.ugent.maf.cellmissy.gui.experiment.load.generic;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Paola Masuzzo
 */
public class LoadFromGenericInputPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoadFromGenericInputPanel
     */
    public LoadFromGenericInputPanel() {
        initComponents();
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JLabel getInfolabel() {
        return infolabel;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JProgressBar getSaveDataProgressBar() {
        return saveDataProgressBar;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        topPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        infolabel = new javax.swing.JLabel();
        finishButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        saveDataProgressBar = new javax.swing.JProgressBar();
        startButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        topPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        topPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        add(topPanel, gridBagConstraints);

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));
        bottomPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        finishButton.setText("Finish");

        resetButton.setText("Reset plate view");

        startButton.setText("Start");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infolabel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(saveDataProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startButton)
                .addGap(18, 18, 18)
                .addComponent(resetButton)
                .addGap(18, 18, 18)
                .addComponent(finishButton)
                .addContainerGap())
        );

        bottomPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {finishButton, resetButton, startButton});

        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resetButton)
                        .addComponent(finishButton)
                        .addComponent(startButton))
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(saveDataProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(infolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        add(bottomPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel infolabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JProgressBar saveDataProgressBar;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
