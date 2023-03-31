package com.example.operations;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Subtraction {
    Polynomial rez = new Polynomial("");
    String poly = "";

    public Subtraction(Polynomial pol1, Polynomial pol2) {
        if (pol1.getMonom().isEmpty() || pol2.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            Map<Integer, Double> updatedMonomials = new HashMap<>(pol1.getMonom());
            for (Map.Entry<Integer, Double> entry : pol2.getMonom().entrySet()) {
                int exponent = entry.getKey();
                double value = entry.getValue();
                if (updatedMonomials.containsKey(exponent)) {
                    updatedMonomials.put(exponent, updatedMonomials.get(exponent) - value);
                } else {
                    updatedMonomials.put(exponent, 0.0 - value);
                }
            }
            for (Map.Entry<Integer, Double> entry : updatedMonomials.entrySet()) {
                if (entry.getValue() == 0.0 && entry.getKey() != 0)
                    updatedMonomials.remove(entry.getKey());
            }
            rez.setMonom(updatedMonomials);
            poly = rez.returnResult(rez.getMonom());
            System.out.println(poly);
        }
    }

    public Polynomial getSubResult() {
        return rez;
    }

    public String getPoly() {
        return poly;
    }
}
