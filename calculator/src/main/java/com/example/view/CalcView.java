package com.example.view;

import com.example.model.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame {

    private JTextField polynomialOne = new JTextField();
    private JTextField polynomialTwo = new JTextField();
    private JTextField polynomialThree = new JTextField();
    private JTextField polynomialFour = new JTextField();
    private JButton addition = new JButton("+");
    private JButton subtraction = new JButton("-");
    private JButton multiplication = new JButton("*");
    private JButton division = new JButton("/");
    private JButton integration = new JButton("∫");
    private JButton derivation = new JButton("∂");

    private CalcModel cModel;

    public CalcView(CalcModel model) {
        cModel = model;
        cModel.setValue();

        JLabel first = new JLabel("Polynomial One: ");
        first.setBounds(10, 53, 250, 40);
        polynomialOne.setBounds(110, 60, 250, 30);
        JLabel second = new JLabel("Polynomial Two: ");
        second.setBounds(10, 120, 250, 40);
        polynomialTwo.setBounds(110, 127, 250, 30);
        addition.setBounds(75, 200, 45, 45);
        subtraction.setBounds(145, 200, 45, 45);
        multiplication.setBounds(215, 200, 45, 45);
        division.setBounds(285, 200, 45, 45);
        integration.setBounds(145, 260, 45, 45);
        derivation.setBounds(215, 260, 45, 45);
        polynomialThree.setBounds(110, 320, 250, 30);
        polynomialFour.setBounds(110, 350, 250, 30);
        JLabel third = new JLabel("total :");
        JLabel fourth = new JLabel("q :");
        third.setBounds(63, 313, 250, 40);
        fourth.setBounds(80, 343, 250, 40);

        JFrame content = new JFrame();
        content.setTitle("Pt project");
        content.add(first);
        content.add(second);
        content.add(polynomialOne);
        content.add(polynomialTwo);
        content.add(addition);
        content.add(subtraction);
        content.add(multiplication);
        content.add(division);
        content.add(integration);
        content.add(derivation);
        content.add(polynomialThree);
        content.add(polynomialFour);
        content.add(fourth);
        content.add(third);
        content.setLayout(null);
        content.setVisible(true);
        content.setSize(420, 420);
        content.setDefaultCloseOperation(EXIT_ON_CLOSE);
        content.setResizable(false);
    }

    public String getInputOne() {
        return polynomialOne.getText();
    }

    public String getInputTwo() {
        return polynomialTwo.getText();
    }

    public void showErr(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public void addAdditionListener(ActionListener add) {
        addition.addActionListener(add);
    }

    public void addSubtractionListener(ActionListener sub) {
        subtraction.addActionListener(sub);
    }

    public void addMultiplicationListener(ActionListener mul) {
        multiplication.addActionListener(mul);
    }

    public void addDivisionListener(ActionListener div) {
        division.addActionListener(div);
    }

    public void addIntegrationListener(ActionListener inte) {
        integration.addActionListener(inte);
    }

    public void addDerivationListener(ActionListener der) {
        derivation.addActionListener(der);
    }

    public void setTotal(String total) {
        polynomialThree.setText(total);
    }

    public void setQ(String q) {
        polynomialFour.setText(q);
    }
}
