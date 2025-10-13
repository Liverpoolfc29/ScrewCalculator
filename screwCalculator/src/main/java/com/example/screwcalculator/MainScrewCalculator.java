package com.example.screwcalculator;

import com.example.screwcalculator.calculate.StructuralCalculation;
import com.example.screwcalculator.frames.StructuralFrame;

import java.util.Scanner;

public class MainScrewCalculator {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StructuralFrame structuralFrame = new StructuralFrame();
        structuralFrame.inputFromUser(scanner);

        StructuralCalculation structuralCalculation = new StructuralCalculation(structuralFrame);

        int sum = structuralCalculation.StructuralFrameCalculate();
        System.out.println(" Все винты структурной рамы = " + sum);
    }
}
