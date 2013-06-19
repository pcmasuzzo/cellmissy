/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CorrectedAreaPanel.java
 *
 * Created on Nov 19, 2012, 4:44:09 PM
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Paola Masuzzo
 */
public class CorrectedAreaPanel extends javax.swing.JPanel {

    public JPanel getReplicatesAreaChartParentPanel() {
        return replicatesAreaChartParentPanel;
    }

    public JTextField getLastTimeFrameTextField() {
        return lastTimeFrameTextField;
    }

    public JTextField getFirstTimeFrameTextField() {
        return firstTimeFrameTextField;
    }

    public JCheckBox getShowTimeIntervalCheckBox() {
        return showTimeIntervalCheckBox;
    }

    public JButton getChooseTimeFramesButton() {
        return chooseTimeFramesButton;
    }

    public JTextArea getExcludedReplicatesTextArea() {
        return excludedReplicatesTextArea;
    }

    public JButton getSelectReplicatesButton() {
        return selectReplicatesButton;
    }

    public JCheckBox getPlotLinesCheckBox() {
        return plotLinesCheckBox;
    }

    public JCheckBox getPlotPointsCheckBox() {
        return plotPointsCheckBox;
    }

    /**
     * Creates new form CorrectedAreaPanel
     */
    public CorrectedAreaPanel() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        leftPanel = new javax.swing.JPanel();
        lastTimeFrameTextField = new javax.swing.JTextField();
        showTimeIntervalCheckBox = new javax.swing.JCheckBox();
        chooseTimeFramesButton = new javax.swing.JButton();
        excludedReplicatesLabel = new javax.swing.JLabel();
        selectReplicatesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        excludedReplicatesTextArea = new javax.swing.JTextArea();
        plotPointsCheckBox = new javax.swing.JCheckBox();
        plotLinesCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        firstTimeFrameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        replicatesAreaChartParentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 400));
        setLayout(new java.awt.GridBagLayout());

        leftPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        leftPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        lastTimeFrameTextField.setBorder(null);
        lastTimeFrameTextField.setFocusable(false);
        lastTimeFrameTextField.setMinimumSize(new java.awt.Dimension(20, 20));
        lastTimeFrameTextField.setPreferredSize(new java.awt.Dimension(20, 20));

        showTimeIntervalCheckBox.setText("show time interval");
        showTimeIntervalCheckBox.setToolTipText("Show the current time interval on plot");
        showTimeIntervalCheckBox.setOpaque(false);

        chooseTimeFramesButton.setText("choose time frames...");
        chooseTimeFramesButton.setToolTipText("Choose first and last time frame to analyze");

        excludedReplicatesLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        excludedReplicatesLabel.setText("Excluded Replicates");
        excludedReplicatesLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        excludedReplicatesLabel.setPreferredSize(new java.awt.Dimension(20, 20));

        selectReplicatesButton.setText("exclude replicates...");
        selectReplicatesButton.setToolTipText("Compute Distance Matrix and exclude replicates from dataset");

        excludedReplicatesTextArea.setEditable(false);
        excludedReplicatesTextArea.setColumns(20);
        excludedReplicatesTextArea.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        excludedReplicatesTextArea.setRows(5);
        excludedReplicatesTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        excludedReplicatesTextArea.setFocusable(false);
        jScrollPane1.setViewportView(excludedReplicatesTextArea);

        plotPointsCheckBox.setText("plot points");
        plotPointsCheckBox.setOpaque(false);

        plotLinesCheckBox.setText("plot lines");
        plotLinesCheckBox.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("First time frame");

        firstTimeFrameTextField.setEditable(false);
        firstTimeFrameTextField.setBorder(null);
        firstTimeFrameTextField.setFocusable(false);
        firstTimeFrameTextField.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Last time frame");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectReplicatesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(excludedReplicatesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseTimeFramesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(showTimeIntervalCheckBox)
                            .addComponent(plotPointsCheckBox)
                            .addComponent(plotLinesCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(firstTimeFrameTextField)
                                    .addComponent(lastTimeFrameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chooseTimeFramesButton, selectReplicatesButton});

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {plotLinesCheckBox, plotPointsCheckBox, showTimeIntervalCheckBox});

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addComponent(excludedReplicatesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectReplicatesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstTimeFrameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastTimeFrameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showTimeIntervalCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseTimeFramesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotPointsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plotLinesCheckBox)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        add(leftPanel, gridBagConstraints);

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
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 1.0;
        add(replicatesAreaChartParentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseTimeFramesButton;
    private javax.swing.JLabel excludedReplicatesLabel;
    private javax.swing.JTextArea excludedReplicatesTextArea;
    private javax.swing.JTextField firstTimeFrameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastTimeFrameTextField;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JCheckBox plotLinesCheckBox;
    private javax.swing.JCheckBox plotPointsCheckBox;
    private javax.swing.JPanel replicatesAreaChartParentPanel;
    private javax.swing.JButton selectReplicatesButton;
    private javax.swing.JCheckBox showTimeIntervalCheckBox;
    // End of variables declaration//GEN-END:variables
}
