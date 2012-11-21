/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DistanceMatrixPanel.java
 *
 * Created on Nov 19, 2012, 4:44:09 PM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Paola Masuzzo
 */
public class DistanceMatrixPanel extends javax.swing.JPanel {

    public JPanel getDistanceMatrixTableParentPanel() {
        return distanceMatrixTableParentPanel;
    }

    public JPanel getReplicatesAreaChartParentPanel() {
        return replicatesAreaChartParentPanel;
    }

    public JRadioButton getFullTimeFramesRadioButton() {
        return fullTimeFramesRadioButton;
    }

    public JRadioButton getSubsetTimeFramesRadioButton() {
        return subsetTimeFramesRadioButton;
    }

    public JComboBox getFirstTimeFrameComboBox() {
        return firstTimeFrameComboBox;
    }

    public JComboBox getLastTimeFrameComboBox() {
        return lastTimeFrameComboBox;
    }

    /** Creates new form DistanceMatrixPanel */
    public DistanceMatrixPanel() {
        initComponents();
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

        distanceMatrixTableParentPanel = new javax.swing.JPanel();
        backgroundNoiseFilterPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fullTimeFramesRadioButton = new javax.swing.JRadioButton();
        subsetTimeFramesRadioButton = new javax.swing.JRadioButton();
        firstTimeFrameComboBox = new javax.swing.JComboBox();
        lastTimeFrameComboBox = new javax.swing.JComboBox();
        replicatesAreaChartParentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        distanceMatrixTableParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        distanceMatrixTableParentPanel.setOpaque(false);
        distanceMatrixTableParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        distanceMatrixTableParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.45;
        add(distanceMatrixTableParentPanel, gridBagConstraints);

        backgroundNoiseFilterPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        backgroundNoiseFilterPanel.setOpaque(false);
        backgroundNoiseFilterPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Select Time Frames");

        fullTimeFramesRadioButton.setText("full ");
        fullTimeFramesRadioButton.setOpaque(false);

        subsetTimeFramesRadioButton.setText("subset");
        subsetTimeFramesRadioButton.setOpaque(false);

        firstTimeFrameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        firstTimeFrameComboBox.setOpaque(false);

        lastTimeFrameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lastTimeFrameComboBox.setOpaque(false);

        javax.swing.GroupLayout backgroundNoiseFilterPanelLayout = new javax.swing.GroupLayout(backgroundNoiseFilterPanel);
        backgroundNoiseFilterPanel.setLayout(backgroundNoiseFilterPanelLayout);
        backgroundNoiseFilterPanelLayout.setHorizontalGroup(
            backgroundNoiseFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundNoiseFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundNoiseFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundNoiseFilterPanelLayout.createSequentialGroup()
                        .addComponent(fullTimeFramesRadioButton)
                        .addGap(37, 37, 37)
                        .addComponent(subsetTimeFramesRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstTimeFrameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastTimeFrameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        backgroundNoiseFilterPanelLayout.setVerticalGroup(
            backgroundNoiseFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundNoiseFilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(backgroundNoiseFilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullTimeFramesRadioButton)
                    .addComponent(subsetTimeFramesRadioButton)
                    .addComponent(firstTimeFrameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastTimeFrameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.55;
        add(backgroundNoiseFilterPanel, gridBagConstraints);

        replicatesAreaChartParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        replicatesAreaChartParentPanel.setOpaque(false);
        replicatesAreaChartParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        replicatesAreaChartParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 1.0;
        add(replicatesAreaChartParentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundNoiseFilterPanel;
    private javax.swing.JPanel distanceMatrixTableParentPanel;
    private javax.swing.JComboBox firstTimeFrameComboBox;
    private javax.swing.JRadioButton fullTimeFramesRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox lastTimeFrameComboBox;
    private javax.swing.JPanel replicatesAreaChartParentPanel;
    private javax.swing.JRadioButton subsetTimeFramesRadioButton;
    // End of variables declaration//GEN-END:variables
}
