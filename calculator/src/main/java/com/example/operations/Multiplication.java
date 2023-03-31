package com.example.operations;

import java.util.Map;

import javax.swing.JOptionPane;

public class Multiplication {
    Polynomial rez = new Polynomial("");
    String poly = "";

    public Multiplication(Polynomial pol1, Polynomial pol2) {
        if (pol1.getMonom().isEmpty() || pol2.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            for (Map.Entry<Integer, Double> entryOne : pol1.getMonom().entrySet()) {
                int exponentOne = entryOne.getKey();
                double coefficientOne = entryOne.getValue();
                for (Map.Entry<Integer, Double> entryTwo : pol2.getMonom().entrySet()) {
                    int exponentTwo = entryTwo.getKey();
                    double coefficientTwo = entryTwo.getValue();

                    int exponentMulti = exponentOne + exponentTwo;
                    double coefficientMulti = coefficientOne * coefficientTwo;

                    boolean ok = false;
                    for (Map.Entry<Integer, Double> res : rez.getMonom().entrySet()) {
                        if (res.getKey().equals(exponentMulti)) {
                            rez.getMonom().put(res.getKey(), rez.getMonom().get(res.getKey()) + coefficientMulti);
                            ok = true;
                        }
                    }
                    if (ok == false)
                        rez.getMonom().put(exponentMulti, coefficientMulti);
                }
            }
            poly = rez.returnResult(rez.getMonom());
            System.out.println(poly);
        }
    }

    public Polynomial getMulResult() {
        return rez;
    }

    public String getPoly() {
        return poly;
    }
}
