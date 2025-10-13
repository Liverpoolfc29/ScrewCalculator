package com.example.screwcalculator.frames;

import java.util.Scanner;

public class PlenumFrame {

    StructuralFrame structuralFrame;

    public PlenumFrame(StructuralFrame structuralFrame) {
        this.structuralFrame = structuralFrame;
    }

    private boolean hasTopPlenumFrame = false;
    private int topPlenumFrame;
    private int verticalSingleFull;        // вертикальный одиночный полный
    private int verticalAboveWindow;       // вертикальный одиночный выше окна
    private int verticalBelowWindow;       // вертикальный одиночный ниже окна

    public void inputFromUser(Scanner scanner) {
        System.out.println("=== Ввод данных для Plenum Frame ===");

        // Наличие окна
        if (structuralFrame.isHasWindow()) {
            System.out.print("Количество вертикальный одиночный выше окна: ");
            verticalAboveWindow = getIntInput(scanner);

            System.out.print("Количество вертикальный одиночный ниже окна: ");
            verticalBelowWindow = getIntInput(scanner);
        }

        // Профили
        System.out.print("Количество вертикальный одиночный полный: ");
        verticalSingleFull = getIntInput(scanner);

        // Верхняя пленум рама
        System.out.print("Количество Top Plenum Frame: ");
        topPlenumFrame = getIntInput(scanner);
        if (topPlenumFrame != 0) {
            hasTopPlenumFrame = true;
        }
    }

    public int getVerticalSingleFull() {
        return verticalSingleFull;
    }

    public int getVerticalAboveWindow() {
        return verticalAboveWindow;
    }

    public int getVerticalBelowWindow() {
        return verticalBelowWindow;
    }

    public boolean isHasTopPlenumFrame() {
        return hasTopPlenumFrame;
    }

    public void setHasTopPlenumFrame(boolean hasTopPlenumFrame) {
        this.hasTopPlenumFrame = hasTopPlenumFrame;
    }

    public int getTopPlenumFrame() {
        return topPlenumFrame;
    }

    private int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Введите число, пожалуйста: ");
            }
        }
    }
}