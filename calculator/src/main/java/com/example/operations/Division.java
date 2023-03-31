package com.example.operations;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Division {
    Map<Integer, Double> temporary = new HashMap<Integer, Double>();
    Map<Integer, Double> reuseable = new HashMap<Integer, Double>();
    Polynomial q = new Polynomial("0");
    Polynomial r = new Polynomial("");
    String poly1 = "";
    String poly2 = "";

    public Division(Polynomial pol1, Polynomial pol2) {
        if (pol1.getMonom().isEmpty() || pol2.getMonom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + "Polynomials not oke u moron!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid");
        } else {
            String poly = pol2.returnResult(pol2.getMonom());
            System.out.println(poly);
            if (poly == "0") {
                JOptionPane.showMessageDialog(null, "An error occurred: " + "pol2 has to be not null :3", "Error",
                        JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Polynomial gotta be greater than 0");

            } else {
                r.setMonom(pol1.getMonom());
                if (r.degree() < pol2.degree()) {
                    q.getMonom().putAll(r.getMonom());
                    r.getMonom().clear();
                    reuseable.put(0, 0.0);
                    r.getMonom().putAll(reuseable);
                } else {
                    while (r.degree() != 0 && r.degree() >= pol2.degree()) {
                        temporary.put(r.degree() - pol2.degree(),
                                r.getMonom().get(r.degree()) / pol2.getMonom().get(pol2.degree()));
                        Polynomial t = new Polynomial("");
                        t.setMonom(temporary);
                        Addition a = new Addition(t, q);
                        q.getMonom().putAll(a.getAddResult());
                        Multiplication mul = new Multiplication(t, pol2);
                        Subtraction sub = new Subtraction(r, mul.getMulResult());
                        r.setMonom(sub.getSubResult().getMonom());
                        temporary.clear();
                    }
                }
            }
            System.out.println("r= " + r.getMonom());
            System.out.println("q= " + q.getMonom());
            poly1 = r.returnResult(r.getMonom());
            poly2 = q.returnResult(q.getMonom());
        }
    }

    public Map<Integer, Double> getRResult() {
        return r.getMonom();
    }

    public Map<Integer, Double> getQResult() {
        return q.getMonom();
    }

    public String getR() {
        return poly1;
    }

    public String getQ() {
        return poly2;
    }
}