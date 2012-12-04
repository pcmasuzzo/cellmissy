/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataAnalysisPanel.java
 *
 * Created on Jul 7, 2012, 10:19:18 PM
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Paola Masuzzo
 */
public class DataAnalysisPanel extends javax.swing.JPanel {

    /** Creates new form DataAnalysisPanel */
    public DataAnalysisPanel() {
        initComponents();
    }

    public JList getExperimentJList() {
        return experimentJList;
    }

    public JList getProjectJList() {
        return projectJList;
    }

    public JComboBox getAlgorithmComboBox() {
        return algorithmComboBox;
    }

    public JComboBox getImagingTypeComboBox() {
        return imagingTypeComboBox;
    }

    public JList getConditionsList() {
        return conditionsList;
    }

    public JPanel getAnalysisPlateParentPanel() {
        return analysisPlateParentPanel;
    }

    public JPanel getBulkCellAnalysisParentPanel() {
        return bulkCellAnalysisParentPanel;
    }

    public JProgressBar getFetchAllConditionsProgressBar() {
        return fetchAllConditionsProgressBar;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        bulkCellAnalysisParentPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        experimentDataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectJList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        experimentJList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        algorithmComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        imagingTypeComboBox = new javax.swing.JComboBox();
        analysisPlateParentPanel = new javax.swing.JPanel();
        conditionsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        conditionsList = new javax.swing.JList();
        bottomPanel = new javax.swing.JPanel();
        fetchAllConditionsProgressBar = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        bulkCellAnalysisParentPanel.setEnabled(false);
        bulkCellAnalysisParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        bulkCellAnalysisParentPanel.setOpaque(false);
        bulkCellAnalysisParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        bulkCellAnalysisParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.95;
        add(bulkCellAnalysisParentPanel, gridBagConstraints);

        leftPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        leftPanel.setLayout(new java.awt.GridBagLayout());

        experimentDataPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        experimentDataPanel.setOpaque(false);
        experimentDataPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Projects", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setOpaque(false);

        projectJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(projectJList);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Experiments Performed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane2.setOpaque(false);

        experimentJList.setToolTipText("");
        jScrollPane2.setViewportView(experimentJList);

        jLabel1.setText("Algorithm");

        jLabel2.setText("Imaging Type");

        javax.swing.GroupLayout experimentDataPanelLayout = new javax.swing.GroupLayout(experimentDataPanel);
        experimentDataPanel.setLayout(experimentDataPanelLayout);
        experimentDataPanelLayout.setHorizontalGroup(
            experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        experimentDataPanelLayout.setVerticalGroup(
            experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(experimentDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        leftPanel.add(experimentDataPanel, gridBagConstraints);

        analysisPlateParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        analysisPlateParentPanel.setOpaque(false);
        analysisPlateParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        analysisPlateParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.45;
        leftPanel.add(analysisPlateParentPanel, gridBagConstraints);

        conditionsPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        conditionsPanel.setOpaque(false);
        conditionsPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Condition"));
        jScrollPane3.setOpaque(false);

        conditionsList.setSelectedIndex(0);
        jScrollPane3.setViewportView(conditionsList);

        javax.swing.GroupLayout conditionsPanelLayout = new javax.swing.GroupLayout(conditionsPanel);
        conditionsPanel.setLayout(conditionsPanelLayout);
        conditionsPanelLayout.setHorizontalGroup(
            conditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        conditionsPanelLayout.setVerticalGroup(
            conditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        leftPanel.add(conditionsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.95;
        add(leftPanel, gridBagConstraints);

        bottomPanel.setOpaque(false);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(1031, Short.MAX_VALUE)
                .addComponent(fetchAllConditionsProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(fetchAllConditionsProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        add(bottomPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox algorithmComboBox;
    private javax.swing.JPanel analysisPlateParentPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel bulkCellAnalysisParentPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JList conditionsList;
    private javax.swing.JPanel conditionsPanel;
    private javax.swing.JPanel experimentDataPanel;
    private javax.swing.JList experimentJList;
    private javax.swing.JProgressBar fetchAllConditionsProgressBar;
    private javax.swing.JComboBox imagingTypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JList projectJList;
    // End of variables declaration//GEN-END:variables
}
