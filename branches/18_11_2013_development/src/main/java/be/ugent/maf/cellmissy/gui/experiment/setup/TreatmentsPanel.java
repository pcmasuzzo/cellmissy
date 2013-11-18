/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TreatmentsPanel.java
 *
 * Created on May 30, 2012, 10:46:50 AM
 */
package be.ugent.maf.cellmissy.gui.experiment.setup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Paola Masuzzo
 */
public class TreatmentsPanel extends javax.swing.JPanel {

    public JButton getAddButton() {
        return addButton;
    }

    public JComboBox getAssayMediumComboBox() {
        return assayMediumComboBox;
    }

    public JTextField getConcentrationTextField() {
        return concentrationTextField;
    }

    public JList getDestinationList() {
        return destinationList;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JList getSourceList1() {
        return sourceList1;
    }

    public JList getSourceList2() {
        return sourceList2;
    }

    public JTextField getTimingTextField() {
        return timingTextField;
    }

    public JComboBox getConcentrationUnitComboBox() {
        return concentrationUnitComboBox;
    }

    public JComboBox getDrugSolventComboBox() {
        return drugSolventComboBox;
    }

    public JTextField getSerumConcentrationTextField() {
        return serumConcentrationTextField;
    }

    public JButton getAddNewButton() {
        return addNewButton;
    }

    public JComboBox getSerumComboBox() {
        return serumComboBox;
    }

    public JTextField getSolventConcentrationTextField() {
        return solventConcentrationTextField;
    }

    public JTextField getMediumVolumeTextField() {
        return mediumVolumeTextField;
    }

    public JLabel getVolumeUnitLabel() {
        return volumeUnitLabel;
    }

    /** Creates new form TreatmentsPanel */
    public TreatmentsPanel() {
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

        treatmentDualListPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sourceList1 = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        destinationList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        sourceList2 = new javax.swing.JList();
        treatmentSetupPanel = new javax.swing.JPanel();
        timingLabel = new javax.swing.JLabel();
        timingTextField = new javax.swing.JTextField();
        concentrationLabel = new javax.swing.JLabel();
        concentrationTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        assayMediumComboBox = new javax.swing.JComboBox();
        concentrationUnitComboBox = new javax.swing.JComboBox();
        drugSolventLabel = new javax.swing.JLabel();
        drugSolventComboBox = new javax.swing.JComboBox();
        serumConcentrationLabel = new javax.swing.JLabel();
        serumConcentrationTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addNewButton = new javax.swing.JButton();
        serumLabel = new javax.swing.JLabel();
        serumComboBox = new javax.swing.JComboBox();
        fCSolventLabel = new javax.swing.JLabel();
        solventConcentrationTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mediumVolumeTextField = new javax.swing.JTextField();
        volumeUnitLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(20, 20));
        setPreferredSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.GridBagLayout());

        treatmentDualListPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        treatmentDualListPanel.setOpaque(false);
        treatmentDualListPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drugs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jScrollPane2.setMinimumSize(new java.awt.Dimension(20, 20));
        jScrollPane2.setOpaque(false);

        sourceList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sourceList1.setToolTipText("");
        jScrollPane2.setViewportView(sourceList1);

        addButton.setText("Add >>");

        removeButton.setText("Remove <<");

        jScrollPane3.setBorder(null);

        destinationList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        destinationList.setPreferredSize(new java.awt.Dimension(10, 10));
        jScrollPane3.setViewportView(destinationList);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Treatments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jScrollPane4.setOpaque(false);

        sourceList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sourceList2.setToolTipText("");
        jScrollPane4.setViewportView(sourceList2);

        javax.swing.GroupLayout treatmentDualListPanelLayout = new javax.swing.GroupLayout(treatmentDualListPanel);
        treatmentDualListPanel.setLayout(treatmentDualListPanelLayout);
        treatmentDualListPanelLayout.setHorizontalGroup(
            treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        treatmentDualListPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, removeButton});

        treatmentDualListPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane4});

        treatmentDualListPanelLayout.setVerticalGroup(
            treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, treatmentDualListPanelLayout.createSequentialGroup()
                        .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addButton)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton))))
                .addContainerGap())
        );

        treatmentDualListPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane2, jScrollPane4});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        add(treatmentDualListPanel, gridBagConstraints);

        treatmentSetupPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        treatmentSetupPanel.setOpaque(false);
        treatmentSetupPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        timingLabel.setText("Time of Addition");

        concentrationLabel.setText("Concentration");

        jLabel5.setText("Assay Medium");

        drugSolventLabel.setText("Drug Solvent");

        serumConcentrationLabel.setText("SC*");

        jLabel1.setText("%");

        addNewButton.setText("Add new Drugs-Treatments...");

        serumLabel.setText("Serum");

        fCSolventLabel.setText("SFC*");

        jLabel2.setText("%");

        jLabel3.setText("SFC* = Solvent Final Concentration");

        jLabel4.setText("SC* = Serum Concentration");

        jLabel6.setText("Medium Volume");

        volumeUnitLabel.setMinimumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout treatmentSetupPanelLayout = new javax.swing.GroupLayout(treatmentSetupPanel);
        treatmentSetupPanel.setLayout(treatmentSetupPanelLayout);
        treatmentSetupPanelLayout.setHorizontalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serumLabel)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(drugSolventLabel)
                            .addComponent(concentrationLabel)
                            .addComponent(timingLabel))
                        .addGap(18, 18, 18)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                        .addComponent(serumConcentrationLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(serumConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(drugSolventComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timingTextField)
                                            .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(fCSolventLabel))
                                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                                .addComponent(concentrationUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(solventConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(53, 53, 53))
                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(assayMediumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(serumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mediumVolumeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(volumeUnitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(224, 224, 224))))
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(addNewButton)
                        .addGap(13, 13, 13))))
        );

        treatmentSetupPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assayMediumComboBox, concentrationTextField, drugSolventComboBox, mediumVolumeTextField, serumComboBox, serumConcentrationTextField, solventConcentrationTextField, timingTextField});

        treatmentSetupPanelLayout.setVerticalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fCSolventLabel)
                            .addComponent(solventConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timingLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(concentrationUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(concentrationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drugSolventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drugSolventLabel))))
                .addGap(54, 54, 54)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serumLabel)
                            .addComponent(jLabel1)
                            .addComponent(serumConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serumConcentrationLabel))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6))
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addComponent(assayMediumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volumeUnitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mediumVolumeTextField))))
                .addGap(22, 22, 22)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(addNewButton))
                .addContainerGap())
        );

        treatmentSetupPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {concentrationTextField, timingTextField});

        treatmentSetupPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {serumConcentrationTextField, solventConcentrationTextField});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        add(treatmentSetupPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addNewButton;
    private javax.swing.JComboBox assayMediumComboBox;
    private javax.swing.JLabel concentrationLabel;
    private javax.swing.JTextField concentrationTextField;
    private javax.swing.JComboBox concentrationUnitComboBox;
    private javax.swing.JList destinationList;
    private javax.swing.JComboBox drugSolventComboBox;
    private javax.swing.JLabel drugSolventLabel;
    private javax.swing.JLabel fCSolventLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField mediumVolumeTextField;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox serumComboBox;
    private javax.swing.JLabel serumConcentrationLabel;
    private javax.swing.JTextField serumConcentrationTextField;
    private javax.swing.JLabel serumLabel;
    private javax.swing.JTextField solventConcentrationTextField;
    private javax.swing.JList sourceList1;
    private javax.swing.JList sourceList2;
    private javax.swing.JLabel timingLabel;
    private javax.swing.JTextField timingTextField;
    private javax.swing.JPanel treatmentDualListPanel;
    private javax.swing.JPanel treatmentSetupPanel;
    private javax.swing.JLabel volumeUnitLabel;
    // End of variables declaration//GEN-END:variables
}
