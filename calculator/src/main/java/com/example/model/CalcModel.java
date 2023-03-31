package com.example.model;

// import javax.swing.plaf.multi.MultiButtonUI;

import com.example.operations.Addition;
import com.example.operations.Derivation;
import com.example.operations.Division;
import com.example.operations.Integration;
import com.example.operations.Multiplication;
import com.example.operations.Polynomial;
import com.example.operations.Subtraction;

public class CalcModel {
    private Polynomial rez = new Polynomial("");
    private Polynomial q = new Polynomial("");
    String poly = "";
    String qu = "";

    public CalcModel() {
        reset();
    }

    public void reset() {
        rez.setMonom(null);
    }

    public void add(Polynomial A, Polynomial B) {
        Addition a = new Addition(A, B);
        rez.setMonom(a.getAddResult());
        System.out.println(rez.getMonom());
        poly = rez.returnResult(rez.getMonom());
        System.out.println(poly);
    }

    public void sub(Polynomial A, Polynomial B) {
        Subtraction a = new Subtraction(A, B);
        rez.setMonom(a.getSubResult().getMonom());
        System.out.println(rez.getMonom());
        poly = rez.returnResult(rez.getMonom());
        if (poly == "")
            poly = "0";
        System.out.println(poly);
    }

    public void multi(Polynomial A, Polynomial B) {
        Multiplication a = new Multiplication(A, B);
        rez.setMonom(a.getMulResult().getMonom());
        System.out.println(rez.getMonom());
        poly = rez.returnResult(rez.getMonom());
        if (poly == "")
            poly = "0";
        System.out.println(poly);
    }

    public void div(Polynomial A, Polynomial B) {
        Division a = new Division(A, B);
        rez.setMonom(a.getRResult());
        q.setMonom(a.getQResult());
        System.out.println(rez.getMonom());
        System.out.println(q.getMonom());
        poly = a.getR();
        qu = a.getQ();
        if (poly == "")
            poly = "0";
        System.out.println(poly);
        System.out.println(qu);
    }

    public void inte(Polynomial A) {
        Integration a = new Integration(A);
        rez.setMonom(a.getInteResult());
        System.out.println(rez.getMonom());
        poly = a.getPoly();
        if (poly == "")
            poly = "0";
        System.out.println(poly);
    }

    public void der(Polynomial A) {
        Derivation a = new Derivation(A);
        rez.setMonom(a.getDerResult());
        System.out.println(rez.getMonom());
        poly = rez.returnResult(rez.getMonom());
        if (poly == "")
            poly = "0";
        System.out.println(poly);
    }

    public void setValue() {
        poly = "";
    }

    public String getValue() {
        return poly.toString();
    }

    public String getQ() {
        return qu.toString();
    }
}
