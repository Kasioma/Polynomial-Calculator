package com.example.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.model.CalcModel;
import com.example.operations.Polynomial;
import com.example.view.CalcView;

public class CalcController {
    private CalcModel Cmodel;
    private CalcView Cview;

    public CalcController(CalcModel model, CalcView view) {
        Cmodel = model;
        Cview = view;

        view.addAdditionListener(new AdditionListener());
        view.addSubtractionListener(new SubtractionListener());
        view.addMultiplicationListener(new MultiplicationListener());
        view.addDivisionListener(new DivisionListener());
        view.addIntegrationListener(new IntegrationListener());
        view.addDerivationListener(new DerivationListener());

    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            String inputB = "";
            inputA = Cview.getInputOne();
            inputB = Cview.getInputTwo();
            if (inputA.isEmpty() || inputB.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Polynomial B = new Polynomial(inputB);
                Cmodel.add(A, B);
                Cview.setTotal(Cmodel.getValue());
            }
        }
    }

    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            String inputB = "";
            inputA = Cview.getInputOne();
            inputB = Cview.getInputTwo();
            if (inputA.isEmpty() || inputB.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Polynomial B = new Polynomial(inputB);
                Cmodel.sub(A, B);
                Cview.setTotal(Cmodel.getValue());
            }
        }
    }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            String inputB = "";
            inputA = Cview.getInputOne();
            inputB = Cview.getInputTwo();
            if (inputA.isEmpty() || inputB.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Polynomial B = new Polynomial(inputB);
                Cmodel.multi(A, B);
                Cview.setTotal(Cmodel.getValue());
            }
        }
    }

    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            String inputB = "";
            inputA = Cview.getInputOne();
            inputB = Cview.getInputTwo();
            if (inputA.isEmpty() || inputB.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Polynomial B = new Polynomial(inputB);
                Cmodel.div(A, B);
                Cview.setTotal(Cmodel.getValue());
                Cview.setQ(Cmodel.getQ());
            }
        }
    }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            inputA = Cview.getInputOne();
            if (inputA.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Cmodel.inte(A);
                Cview.setTotal(Cmodel.getValue());
            }
        }
    }

    class DerivationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputA = "";
            inputA = Cview.getInputOne();
            if (inputA.isEmpty()) {
                Cview.showErr("Invalid Inputs");
            } else {
                Polynomial A = new Polynomial(inputA);
                Cmodel.der(A);
                Cview.setTotal(Cmodel.getValue());
            }
        }
    }
}
