package com.example.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    Map<Integer, Double> monom = new HashMap<Integer, Double>();

    public Polynomial(final String polynomial) {
        Pattern pattern = Pattern.compile("([+-]? ?\\d*\\.?\\d*)([xX])?([a-zA-Z]*)\\^?(\\d*)");
        Matcher matcher = pattern.matcher(polynomial);
        while (matcher.find()) {
            String coefficient = matcher.group(1);
            String second = matcher.group(3);
            if (second != null && !second.isEmpty()) {
                Map<Integer, Double> neew = new HashMap<Integer, Double>();
                monom = neew;
                break;
            }
            boolean positive = true;
            if (coefficient.startsWith("-"))
                positive = false;
            coefficient = coefficient.replaceAll("[+-]", "");
            double placeholder = 1.0;
            if (!coefficient.trim().isEmpty())
                placeholder = Double.parseDouble(coefficient);
            if (!positive)
                placeholder = -placeholder;
            int exponent = 1;
            if (!matcher.group(4).isEmpty())
                exponent = Integer.parseInt(matcher.group(4));
            if (matcher.group(2) == null) {
                exponent = 0;
            }
            if (!matcher.group(1).trim().isEmpty() || matcher.group(2) != null) {
                boolean ok = false;
                for (Map.Entry<Integer, Double> entry : monom.entrySet()) {
                    if (entry.getKey().equals(exponent)) {
                        monom.put(entry.getKey(), monom.get(entry.getKey()) + placeholder);
                        ok = true;
                    }
                }
                if (ok == false) {
                    monom.put(exponent, placeholder);
                }
            }
        }
    }

    public Map<Integer, Double> getMonom() {
        return monom;
    }

    public void setMonom(Map<Integer, Double> monom) {
        this.monom = monom;
    }

    public int degree() {
        int degree = -1;
        for (Map.Entry<Integer, Double> entry : monom.entrySet()) {
            if (entry.getKey() > degree)
                degree = entry.getKey();
        }
        return degree;
    }

    public String returnResult(Map<Integer, Double> result) {
        String poly = "";
        for (Map.Entry<Integer, Double> entry : result.entrySet()) {
            int exponent = entry.getKey();
            double value = entry.getValue();
            if (value == 0)
                poly = poly + "";
            else if (value < 0) {
                if (value == -1) {
                    if (exponent == 1)
                        poly = poly + "-" + "x";
                    else if (exponent == 0)
                        poly = poly + value;
                    else
                        poly = poly + "-" + "x^" + exponent;
                } else {
                    if (exponent == 1)
                        poly = poly + value + "x";
                    else if (exponent == 0)
                        poly = poly + value;
                    else
                        poly = poly + value + "x^" + exponent;
                }
            } else {
                if (value == 1) {
                    if (exponent == 1)
                        poly = poly + "+" + "x";
                    else if (exponent == 0)
                        poly = poly + "+" + value;
                    else
                        poly = poly + "+" + "x^" + exponent;
                } else {
                    if (exponent == 1)
                        poly = poly + "+" + value + "x";
                    else if (exponent == 0)
                        poly = poly + value;
                    else
                        poly = poly + "+" + value + "x^" + exponent;
                }
            }
        }
        poly = poly.startsWith("+") ? poly.substring(1) : poly;
        poly = poly == "" ? "0" : poly;
        return poly;
    }
}
