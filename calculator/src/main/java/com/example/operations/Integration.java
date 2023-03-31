package com.example.operations;

import java.util.Map;

import javax.swing.JOptionPane;

public class Integration {

    Polynomial rez = new Polynomial("");
    String poly = "c ";

    public Integration(Polynomial pol) {
        if (pol.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            for (Map.Entry<Integer, Double> entry : pol.getMonom().entrySet()) {
                int exponent = entry.getKey();
                double value = entry.getValue();

                if (exponent > 0) {
                    rez.getMonom().put(exponent + 1, value / (exponent + 1));
                }
                if (exponent == 0)
                    rez.getMonom().put(1, value);
            }
            poly = rez.returnResult(rez.getMonom());
            if (poly.startsWith("+") || poly.startsWith("-"))
                poly = "c" + poly;
            else if (poly != "0")
                poly = "c+" + poly;
            System.out.println(poly);
        }
    }

    public Map<Integer, Double> getInteResult() {
        return rez.getMonom();
    }

    public String getPoly() {
        return poly;
    }
}
