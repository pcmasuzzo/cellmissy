/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.view.renderer;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

/**
 * This renderer for the check box extends the component CheckBox.
 *
 * @author Paola Masuzzo
 */
public class CheckBoxCellRenderer extends JCheckBox {

    public CheckBoxCellRenderer(boolean isSelected) {
        setSelected(isSelected);
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
