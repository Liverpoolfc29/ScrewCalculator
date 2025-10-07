package com.example.screwcalculator;

import com.example.screwcalculator.frames.StructuralFrame;

import java.util.Scanner;

public class MainScrewCalculator {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StructuralFrame frame = new StructuralFrame();
        frame.inputFromUser(scanner);

// Пример использования:
        System.out.println("Наличник окна: " + frame.hasWindowCasing());
        System.out.println("Вертикальный одиночный полный: " + frame.getVerticalSingleFull());

    }
}
