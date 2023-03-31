package com.example;

import com.example.controller.CalcController;
import com.example.model.CalcModel;
import com.example.view.CalcView;

public class App {

    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView(model);
        new CalcController(model, view);
    }
}
