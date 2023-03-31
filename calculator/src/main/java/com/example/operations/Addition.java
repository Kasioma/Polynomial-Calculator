package com.example.operations;

import java.util.Map;

import javax.swing.JOptionPane;

public class Addition {
    Polynomial rez = new Polynomial("");
    String poly = "";

    public Addition(Polynomial pol1, Polynomial pol2) {
        if (pol1.getMonom().isEmpty() || pol2.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            rez.getMonom().putAll(pol1.getMonom());
            for (Map.Entry<Integer, Double> entry : pol2.getMonom().entrySet()) {
                boolean ok = false;
                for (Map.Entry<Integer, Double> res : rez.getMonom().entrySet()) {
                    if (entry.getKey().equals(res.getKey())) {
                        rez.getMonom().put(res.getKey(), rez.getMonom().get(res.getKey()) + entry.getValue());
                        ok = true;
                    }
                }
                if (ok == false) {
                    rez.getMonom().put(entry.getKey(), entry.getValue());
                }
            }

            poly = rez.returnResult(rez.getMonom());
            System.out.println(poly);
        }

    }

    public Map<Integer, Double> getAddResult() {
        return rez.getMonom();
    }

    public String getPoly() {
        return poly;
    }
}
