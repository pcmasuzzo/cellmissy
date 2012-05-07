/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;

/**
 *
 * @author Paola
 */
public class GuiUtils {

    private static final Color[] availableColors = {Color.BLACK, Color.RED, Color.GRAY, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.YELLOW, Color.BLUE, Color.DARK_GRAY};

    public static GridBagConstraints getDefaultGridBagConstraints() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        return gridBagConstraints;
    }

    public static Color[] getAvailableColors() {
        return availableColors;
    }

    public static boolean containsComponent(Container parentContainer, Component childComponent) {
        boolean containsComponent = false;
        for (Component component : parentContainer.getComponents()) {
            if (childComponent.equals(component)) {
                containsComponent = true;
            }
        }
        return containsComponent;
    }
}
