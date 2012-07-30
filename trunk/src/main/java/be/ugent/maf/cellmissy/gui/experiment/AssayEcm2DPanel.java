/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AssayEcm2DPanel.java
 *
 * Created on Apr 3, 2012, 9:30:52 AM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Paola
 */
public class AssayEcm2DPanel extends javax.swing.JPanel {

    /** Creates new form AssayEcm2DPanel */
    public AssayEcm2DPanel() {
        initComponents();
    }

    public JComboBox getAssayComboBox() {
        return assayComboBox;
    }

    public JComboBox getCompositionComboBox() {
        return compositionComboBox;
    }

    public JComboBox getCoatingComboBox() {
        return coatingComboBox;
    }

    public JTextField getCoatingTemperatureTextField() {
        return coatingTemperatureTextField;
    }

    public JTextField getCoatingTimeTextField() {
        return coatingTimeTextField;
    }

    public JTextField getVolumeTextField() {
        return volumeTextField;
    }

    public JTextField getConcentrationTextField() {
        return concentrationTextField;
    }

    public JButton getAddCompositionButton() {
        return addCompositionButton;
    }

    public JTextField getCompositionTextField() {
        return compositionTextField;
    }

    public JComboBox getConcentrationUnitOfMeasure() {
        return concentrationUnitOfMeasure;
    }

    public JLabel getVolumeUnitLabel() {
        return volumeUnitLabel;
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

        assayPanel = new javax.swing.JPanel();
        assayComboBox = new javax.swing.JComboBox();
        selectAssayLabel = new javax.swing.JLabel();
        ecmPanel = new javax.swing.JPanel();
        coatingTypeLabel = new javax.swing.JLabel();
        concentrationLabel = new javax.swing.JLabel();
        compositionLabel = new javax.swing.JLabel();
        concentrationTextField = new javax.swing.JTextField();
        volumeLabel = new javax.swing.JLabel();
        coatingTimeLabel = new javax.swing.JLabel();
        coatingTemperatureLabel = new javax.swing.JLabel();
        volumeTextField = new javax.swing.JTextField();
        coatingTimeTextField = new javax.swing.JTextField();
        coatingTemperatureTextField = new javax.swing.JTextField();
        compositionComboBox = new javax.swing.JComboBox();
        coatingComboBox = new javax.swing.JComboBox();
        compositionTextField = new javax.swing.JTextField();
        addCompositionButton = new javax.swing.JButton();
        concentrationUnitOfMeasure = new javax.swing.JComboBox();
        volumeUnitLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        assayPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        assayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2" }));

        selectAssayLabel.setText("Select a migration assay");

        javax.swing.GroupLayout assayPanelLayout = new javax.swing.GroupLayout(assayPanel);
        assayPanel.setLayout(assayPanelLayout);
        assayPanelLayout.setHorizontalGroup(
            assayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assayPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(selectAssayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        assayPanelLayout.setVerticalGroup(
            assayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectAssayLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        add(assayPanel, gridBagConstraints);

        ecmPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Extra Cellular Matrix", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), java.awt.Color.black)); // NOI18N
        ecmPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        ecmPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        coatingTypeLabel.setText("Coating type");

        concentrationLabel.setText("Concentration");

        compositionLabel.setText("Composition");

        concentrationTextField.setText("0");

        volumeLabel.setText("Volume");

        coatingTimeLabel.setText("Coating time (min)");

        coatingTemperatureLabel.setText("Coating temperature");

        volumeTextField.setText("0");

        compositionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        coatingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addCompositionButton.setText("Add new composition");

        volumeUnitLabel.setMinimumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout ecmPanelLayout = new javax.swing.GroupLayout(ecmPanel);
        ecmPanel.setLayout(ecmPanelLayout);
        ecmPanelLayout.setHorizontalGroup(
            ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecmPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(concentrationLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(volumeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coatingTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coatingTemperatureLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(coatingTypeLabel)
                        .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(compositionTextField)
                            .addComponent(compositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecmPanelLayout.createSequentialGroup()
                        .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(concentrationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(volumeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(coatingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coatingTemperatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volumeUnitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(concentrationUnitOfMeasure, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(coatingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCompositionButton)
                    .addComponent(compositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(549, 549, 549))
        );

        ecmPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {coatingComboBox, compositionComboBox});

        ecmPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {coatingTemperatureTextField, coatingTimeTextField, concentrationTextField, volumeTextField});

        ecmPanelLayout.setVerticalGroup(
            ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecmPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compositionLabel)
                    .addComponent(compositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCompositionButton))
                .addGap(26, 26, 26)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coatingTypeLabel)
                    .addComponent(coatingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(concentrationLabel)
                    .addComponent(concentrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(concentrationUnitOfMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volumeTextField)
                    .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(volumeLabel)
                        .addComponent(volumeUnitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coatingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coatingTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coatingTemperatureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coatingTemperatureLabel))
                .addGap(29, 29, 29))
        );

        ecmPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {volumeTextField, volumeUnitLabel});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        add(ecmPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCompositionButton;
    private javax.swing.JComboBox assayComboBox;
    private javax.swing.JPanel assayPanel;
    private javax.swing.JComboBox coatingComboBox;
    private javax.swing.JLabel coatingTemperatureLabel;
    private javax.swing.JTextField coatingTemperatureTextField;
    private javax.swing.JLabel coatingTimeLabel;
    private javax.swing.JTextField coatingTimeTextField;
    private javax.swing.JLabel coatingTypeLabel;
    private javax.swing.JComboBox compositionComboBox;
    private javax.swing.JLabel compositionLabel;
    private javax.swing.JTextField compositionTextField;
    private javax.swing.JLabel concentrationLabel;
    private javax.swing.JTextField concentrationTextField;
    private javax.swing.JComboBox concentrationUnitOfMeasure;
    private javax.swing.JPanel ecmPanel;
    private javax.swing.JLabel selectAssayLabel;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JTextField volumeTextField;
    private javax.swing.JLabel volumeUnitLabel;
    // End of variables declaration//GEN-END:variables
}
