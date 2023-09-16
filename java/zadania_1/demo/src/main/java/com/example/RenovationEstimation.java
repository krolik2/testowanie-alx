package com.example;

import javax.swing.*;
import java.awt.*;

public class RenovationEstimation {
    public static void main(String[] args) {
        int plasteringPrice = 100;
        int paintingPrice = 30;
        int flooringPanelsPrice = 50;
        int baseboardsPrice = 40;

        double width = Double.parseDouble(JOptionPane.showInputDialog("Podaj szerokość pomieszczenia w metrach:"));
        double length = Double.parseDouble(JOptionPane.showInputDialog("Podaj długość pomieszczenia w metrach:"));
        double height = Double
                .parseDouble(JOptionPane.showInputDialog("Podaj wysokość pomieszczenia w metrach:", "2.50"));

        double floorArea = width * length;
        double ceilingArea = width * length;
        double wallArea = 2 * (width * height + length * height);

        double roomPerimeter = 2 * (width + length);

        JCheckBox plasteringCheckBox = new JCheckBox("Gipsowanie ścian");
        JCheckBox paintingCheckBox = new JCheckBox("Malowanie ścian i sufitów");
        JCheckBox flooringPanelsCheckBox = new JCheckBox("Położenie paneli podłogowych");
        JCheckBox baseboardsCheckBox = new JCheckBox("Położenie listew przypodłogowych");

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(4, 1));
        checkBoxPanel.add(plasteringCheckBox);
        checkBoxPanel.add(paintingCheckBox);
        checkBoxPanel.add(flooringPanelsCheckBox);
        checkBoxPanel.add(baseboardsCheckBox);

        int result = JOptionPane.showConfirmDialog(null, checkBoxPanel, "Wybór prac remontowych",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            double cost = 0;

            if (plasteringCheckBox.isSelected()) {
                cost += plasteringPrice * wallArea;
            }
            if (paintingCheckBox.isSelected()) {
                cost += paintingPrice * (wallArea + ceilingArea);
            }
            if (flooringPanelsCheckBox.isSelected()) {
                cost += flooringPanelsPrice * floorArea;
            }
            if (baseboardsCheckBox.isSelected()) {
                cost += baseboardsPrice * roomPerimeter;
            }

            JOptionPane.showMessageDialog(null, "Powierzchnia podłogi: " + floorArea + " m^2\n" +
                    "Powierzchnia sufitu: " + ceilingArea + " m^2\n" +
                    "Powierzchnia ścian: " + wallArea + " m^2\n" +
                    "Obwód pokoju: " + roomPerimeter + " m\n" +
                    "Całkowity koszt prac remontowych: " + cost + " zł");
        }
    }
}