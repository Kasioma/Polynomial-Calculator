package com.example.operations;

import java.util.Map;

import javax.swing.JOptionPane;

public class Derivation {
    Polynomial rez = new Polynomial("");
    String poly = "";

    public Derivation(Polynomial pol1) {
        if (pol1.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            for (Map.Entry<Integer, Double> entry : pol1.getMonom().entrySet()) {
                int exponent = entry.getKey();
                double value = entry.getValue();

                if (exponent > 0) {
                    rez.getMonom().put(exponent - 1, value * exponent);
                }
            }
            poly = rez.returnResult(rez.getMonom());
            System.out.println(poly);
        }
    }

    public Map<Integer, Double> getDerResult() {
        return rez.getMonom();
    }

    public String getPoly() {
        return poly;
    }
}
