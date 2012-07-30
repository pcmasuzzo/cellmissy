/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TreatmentPanel.java
 *
 * Created on May 30, 2012, 10:46:50 AM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Paola Masuzzo
 */
public class TreatmentPanel extends javax.swing.JPanel {

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getAddDrugButton() {
        return addDrugButton;
    }

    public JButton getAddTreatmentButton() {
        return addTreatmentButton;
    }

    public JTextField getDrugTextField() {
        return drugTextField;
    }

    public JTextField getTreatmentTextField() {
        return treatmentTextField;
    }

    public JTextArea getAdditionalInfoTextArea() {
        return additionalInfoTextArea;
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

    /** Creates new form TreatmentPanel */
    public TreatmentPanel() {
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
        additionalInfoLabel = new javax.swing.JLabel();
        timingLabel = new javax.swing.JLabel();
        timingTextField = new javax.swing.JTextField();
        concentrationLabel = new javax.swing.JLabel();
        concentrationTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        additionalInfoTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        assayMediumComboBox = new javax.swing.JComboBox();
        concentrationUnitComboBox = new javax.swing.JComboBox();
        drugSolventLabel = new javax.swing.JLabel();
        drugSolventComboBox = new javax.swing.JComboBox();
        serumConcentrationLabel = new javax.swing.JLabel();
        serumConcentrationTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addNewButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        drugTextField = new javax.swing.JTextField();
        addDrugButton = new javax.swing.JButton();
        treatmentTextField = new javax.swing.JTextField();
        addTreatmentButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        treatmentDualListPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        treatmentDualListPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drugs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sourceList1.setToolTipText("");
        jScrollPane2.setViewportView(sourceList1);

        addButton.setText("Add >>");

        removeButton.setText("Remove <<");

        jScrollPane3.setBorder(null);

        destinationList.setPreferredSize(new java.awt.Dimension(10, 10));
        jScrollPane3.setViewportView(destinationList);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Treatments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        sourceList2.setToolTipText("");
        jScrollPane4.setViewportView(sourceList2);

        javax.swing.GroupLayout treatmentDualListPanelLayout = new javax.swing.GroupLayout(treatmentDualListPanel);
        treatmentDualListPanel.setLayout(treatmentDualListPanelLayout);
        treatmentDualListPanelLayout.setHorizontalGroup(
            treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        treatmentDualListPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, removeButton});

        treatmentDualListPanelLayout.setVerticalGroup(
            treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentDualListPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(treatmentDualListPanelLayout.createSequentialGroup()
                            .addGroup(treatmentDualListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, treatmentDualListPanelLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(addButton)))
                            .addGap(18, 18, 18)
                            .addComponent(removeButton)
                            .addGap(36, 36, 36)))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        add(treatmentDualListPanel, gridBagConstraints);

        treatmentSetupPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        treatmentSetupPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        additionalInfoLabel.setText("Treatment Info");

        timingLabel.setText("Time of Addition");

        concentrationLabel.setText("Concentration");

        additionalInfoTextArea.setColumns(20);
        additionalInfoTextArea.setRows(5);
        jScrollPane1.setViewportView(additionalInfoTextArea);

        jLabel5.setText("Assay Medium");

        drugSolventLabel.setText("Drug Solvent");

        serumConcentrationLabel.setText("Serum Concentration");

        jLabel1.setText("%");

        addNewButton.setText("ADD");

        javax.swing.GroupLayout treatmentSetupPanelLayout = new javax.swing.GroupLayout(treatmentSetupPanel);
        treatmentSetupPanel.setLayout(treatmentSetupPanelLayout);
        treatmentSetupPanelLayout.setHorizontalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(additionalInfoLabel)
                                    .addComponent(timingLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentSetupPanelLayout.createSequentialGroup()
                                        .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                                .addComponent(serumConcentrationLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(serumConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1))
                                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                                .addComponent(concentrationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(concentrationUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                .addComponent(drugSolventLabel)
                                .addGap(18, 18, 18)
                                .addComponent(drugSolventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(assayMediumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentSetupPanelLayout.createSequentialGroup()
                        .addComponent(addNewButton)
                        .addContainerGap())))
        );

        treatmentSetupPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {concentrationTextField, timingTextField});

        treatmentSetupPanelLayout.setVerticalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(additionalInfoLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timingLabel)
                    .addComponent(concentrationLabel)
                    .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(concentrationUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drugSolventLabel)
                    .addComponent(drugSolventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assayMediumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(serumConcentrationLabel)
                    .addComponent(serumConcentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addNewButton)
                .addGap(36, 36, 36))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.35;
        add(treatmentSetupPanel, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(20, 20));

        addDrugButton.setText("Add Drug");

        addTreatmentButton.setText("Add Treatment");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(treatmentTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addTreatmentButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(drugTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addDrugButton)))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addDrugButton, addTreatmentButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addDrugButton)
                    .addComponent(drugTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treatmentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTreatmentButton))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.15;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addDrugButton;
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton addTreatmentButton;
    private javax.swing.JLabel additionalInfoLabel;
    private javax.swing.JTextArea additionalInfoTextArea;
    private javax.swing.JComboBox assayMediumComboBox;
    private javax.swing.JLabel concentrationLabel;
    private javax.swing.JTextField concentrationTextField;
    private javax.swing.JComboBox concentrationUnitComboBox;
    private javax.swing.JList destinationList;
    private javax.swing.JComboBox drugSolventComboBox;
    private javax.swing.JLabel drugSolventLabel;
    private javax.swing.JTextField drugTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel serumConcentrationLabel;
    private javax.swing.JTextField serumConcentrationTextField;
    private javax.swing.JList sourceList1;
    private javax.swing.JList sourceList2;
    private javax.swing.JLabel timingLabel;
    private javax.swing.JTextField timingTextField;
    private javax.swing.JPanel treatmentDualListPanel;
    private javax.swing.JPanel treatmentSetupPanel;
    private javax.swing.JTextField treatmentTextField;
    // End of variables declaration//GEN-END:variables
}
