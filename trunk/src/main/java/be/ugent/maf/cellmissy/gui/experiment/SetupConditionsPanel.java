/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SetupConditionsPanel.java
 *
 * Created on Apr 2, 2012, 10:41:55 AM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paola
 */
public class SetupConditionsPanel extends javax.swing.JPanel {

    /** Creates new form SetupConditionsPanel */
    public SetupConditionsPanel() {
        initComponents();
    }

    public JComboBox getCellLineComboBox() {
        return cellLineComboBox;
    }

    public JTextField getCellLineNameTextField() {
        return cellLineNameTextField;
    }

    public JButton getInsertCellLineButton() {
        return insertCellLineButton;
    }

    public JComboBox getEcmDimensionComboBox() {
        return ecmDimensionComboBox;
    }

    public JPanel getAssayEcmParentPanel() {
        return assayEcmParentPanel;
    }

    public JPanel getAssayEcmPanel() {
        return assayEcmPanel;
    }

    public JComboBox getTreatmentTypeComboBox() {
        return treatmentTypeComboBox;
    }

    public JComboBox getDrugComboBox() {
        return drugComboBox;
    }

    public JComboBox getGeneralTreatmentComboBox() {
        return generalTreatmentComboBox;
    }

    public JTextField getTimingTextField() {
        return timingTextField;
    }

    public JTextField getAdditionalInfoTextField() {
        return additionalInfoTextField;
    }

    public JTextField getConcentrationTextField() {
        return concentrationTextField;
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
        cellLinePanel = new javax.swing.JPanel();
        cellLineComboBox = new javax.swing.JComboBox();
        selectCellLineLabel = new javax.swing.JLabel();
        cellLineNameLabel = new javax.swing.JLabel();
        cellLineNameTextField = new javax.swing.JTextField();
        insertCellLineButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        assayEcmPanel = new javax.swing.JPanel();
        ecmDimensionPanel = new javax.swing.JPanel();
        ecmDimensionLabel = new javax.swing.JLabel();
        ecmDimensionComboBox = new javax.swing.JComboBox();
        assayEcmParentPanel = new javax.swing.JPanel();
        treatmentPanel = new javax.swing.JPanel();
        treatmentTypePanel = new javax.swing.JPanel();
        treatmentTypeComboBox = new javax.swing.JComboBox();
        chooseTreatmentTypeLabel = new javax.swing.JLabel();
        treatmentSetupPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        additionalInfoLabel = new javax.swing.JLabel();
        timingLabel = new javax.swing.JLabel();
        drugComboBox = new javax.swing.JComboBox();
        additionalInfoTextField = new javax.swing.JTextField();
        timingTextField = new javax.swing.JTextField();
        concentrationLabel = new javax.swing.JLabel();
        concentrationTextField = new javax.swing.JTextField();
        generalTreatmentComboBox = new javax.swing.JComboBox();

        setLayout(new java.awt.GridBagLayout());

        selectCellLineLabel.setText("Select a cell line");

        cellLineNameLabel.setText("Cell line name");

        insertCellLineButton.setText("Insert cell line");

        jLabel1.setText("If the cell line is not present, insert it into DB");

        javax.swing.GroupLayout cellLinePanelLayout = new javax.swing.GroupLayout(cellLinePanel);
        cellLinePanel.setLayout(cellLinePanelLayout);
        cellLinePanelLayout.setHorizontalGroup(
            cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cellLinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cellLinePanelLayout.createSequentialGroup()
                        .addComponent(cellLineNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cellLineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertCellLineButton))
                    .addComponent(jLabel1)
                    .addGroup(cellLinePanelLayout.createSequentialGroup()
                        .addComponent(selectCellLineLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cellLineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        cellLinePanelLayout.setVerticalGroup(
            cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cellLinePanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCellLineLabel)
                    .addComponent(cellLineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cellLineNameLabel)
                    .addComponent(cellLineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertCellLineButton))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("cell line", cellLinePanel);

        assayEcmPanel.setLayout(new java.awt.GridBagLayout());

        ecmDimensionPanel.setPreferredSize(new java.awt.Dimension(250, 50));

        ecmDimensionLabel.setText("Choose ECM dimension");

        ecmDimensionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout ecmDimensionPanelLayout = new javax.swing.GroupLayout(ecmDimensionPanel);
        ecmDimensionPanel.setLayout(ecmDimensionPanelLayout);
        ecmDimensionPanelLayout.setHorizontalGroup(
            ecmDimensionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ecmDimensionPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(ecmDimensionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ecmDimensionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        ecmDimensionPanelLayout.setVerticalGroup(
            ecmDimensionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ecmDimensionPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(ecmDimensionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecmDimensionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ecmDimensionLabel))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        assayEcmPanel.add(ecmDimensionPanel, gridBagConstraints);

        assayEcmParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        assayEcmParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.6;
        assayEcmPanel.add(assayEcmParentPanel, gridBagConstraints);

        jTabbedPane1.addTab("assay-ecm", assayEcmPanel);

        treatmentPanel.setLayout(new java.awt.GridBagLayout());

        treatmentTypePanel.setMinimumSize(new java.awt.Dimension(250, 80));
        treatmentTypePanel.setPreferredSize(new java.awt.Dimension(250, 80));

        treatmentTypeComboBox.setToolTipText("");

        chooseTreatmentTypeLabel.setText("Choose a treatment type");

        javax.swing.GroupLayout treatmentTypePanelLayout = new javax.swing.GroupLayout(treatmentTypePanel);
        treatmentTypePanel.setLayout(treatmentTypePanelLayout);
        treatmentTypePanelLayout.setHorizontalGroup(
            treatmentTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentTypePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(chooseTreatmentTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(treatmentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        treatmentTypePanelLayout.setVerticalGroup(
            treatmentTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentTypePanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(treatmentTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseTreatmentTypeLabel)
                    .addComponent(treatmentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        treatmentPanel.add(treatmentTypePanel, gridBagConstraints);

        nameLabel.setText("Name");

        additionalInfoLabel.setText("Additional info");

        timingLabel.setText("Timing");

        drugComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));

        concentrationLabel.setText("Concentration");

        generalTreatmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout treatmentSetupPanelLayout = new javax.swing.GroupLayout(treatmentSetupPanel);
        treatmentSetupPanel.setLayout(treatmentSetupPanelLayout);
        treatmentSetupPanelLayout.setHorizontalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentSetupPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(concentrationLabel)
                            .addComponent(timingLabel)
                            .addComponent(additionalInfoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(concentrationTextField)
                            .addComponent(timingTextField)
                            .addComponent(additionalInfoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treatmentSetupPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(drugComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalTreatmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(387, 387, 387))
        );
        treatmentSetupPanelLayout.setVerticalGroup(
            treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(treatmentSetupPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drugComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generalTreatmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(additionalInfoLabel)
                    .addComponent(additionalInfoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timingLabel)
                    .addComponent(timingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(treatmentSetupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(concentrationLabel))
                .addGap(258, 258, 258))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        treatmentPanel.add(treatmentSetupPanel, gridBagConstraints);

        jTabbedPane1.addTab("treatment", treatmentPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel additionalInfoLabel;
    private javax.swing.JTextField additionalInfoTextField;
    private javax.swing.JPanel assayEcmPanel;
    private javax.swing.JPanel assayEcmParentPanel;
    private javax.swing.JComboBox cellLineComboBox;
    private javax.swing.JLabel cellLineNameLabel;
    private javax.swing.JTextField cellLineNameTextField;
    private javax.swing.JPanel cellLinePanel;
    private javax.swing.JLabel chooseTreatmentTypeLabel;
    private javax.swing.JLabel concentrationLabel;
    private javax.swing.JTextField concentrationTextField;
    private javax.swing.JComboBox drugComboBox;
    private javax.swing.JComboBox ecmDimensionComboBox;
    private javax.swing.JLabel ecmDimensionLabel;
    private javax.swing.JPanel ecmDimensionPanel;
    private javax.swing.JComboBox generalTreatmentComboBox;
    private javax.swing.JButton insertCellLineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel selectCellLineLabel;
    private javax.swing.JLabel timingLabel;
    private javax.swing.JTextField timingTextField;
    private javax.swing.JPanel treatmentPanel;
    private javax.swing.JPanel treatmentSetupPanel;
    private javax.swing.JComboBox treatmentTypeComboBox;
    private javax.swing.JPanel treatmentTypePanel;
    // End of variables declaration//GEN-END:variables
}
