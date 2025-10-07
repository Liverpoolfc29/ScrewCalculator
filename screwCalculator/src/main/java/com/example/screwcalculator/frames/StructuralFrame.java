package com.example.screwcalculator.frames;

import java.util.Scanner;

public class StructuralFrame {

    // Наличие окна
    private int hasWindowCasing;

    // Высота панели
    private int panelHeight;

    // Профили
    private int verticalSingleFull;       // вертикальный одиночный полный
    private int verticalDoubleFull;     // вертикальный одиночный парный
    private int verticalSingleTriple;     // вертикальный одиночный тройной
    private int verticalAboveWindow;      // вертикальный одиночный выше окна
    private int verticalBelowWindow;      // вертикальный одиночный ниже окна
    private int fullLengthBridges;        // бриджи полной длины
    private int shortLengthBridges;        // бриджи короткой длины
    private int fullLengthBridgesPlate;    // пластина бридж полной длины
    private int shortLengthBridgesPlate;    // пластина бриджи короткой длины

    public void inputFromUser(Scanner scanner) {
        System.out.println("=== Ввод данных для структурной рамы ===");

        // высота панели
        System.out.print("введите высоту панели в мм: ");
        panelHeight = getIntInputPanelHeight(scanner);

        // Наличие окна
        System.out.print("Введите количество окон: ");
        hasWindowCasing = getIntInput(scanner);

        // Профили & бриджи & пластины
        System.out.print("Количество вертикальный одиночный полный: ");
        verticalSingleFull = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный парный: ");
        verticalDoubleFull = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный тройной: ");
        verticalSingleTriple = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный выше окна: ");
        verticalAboveWindow = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный ниже окна: ");
        verticalBelowWindow = getIntInput(scanner);

        System.out.print("Количество бриджей полной длины: ");
        fullLengthBridges = getIntInput(scanner);

        System.out.print("Количество бриджей короткой  длины: ");
        shortLengthBridges = getIntInput(scanner);

        System.out.print("Количество пластин бриджей полной длины: ");
        fullLengthBridgesPlate = getIntInput(scanner);

        System.out.print("Количество пластин бриджей короткой длины: ");
        shortLengthBridgesPlate = getIntInput(scanner);
    }

    // Геттеры
    public int hasWindowCasing() {
        return hasWindowCasing;
    }

    public int getVerticalSingleFull() {
        return verticalSingleFull;
    }

    public int getVerticalDoubleFull() {
        return verticalDoubleFull;
    }

    public int getVerticalSingleTriple() {
        return verticalSingleTriple;
    }

    public int getVerticalAboveWindow() {
        return verticalAboveWindow;
    }

    public int getVerticalBelowWindow() {
        return verticalBelowWindow;
    }

    public int getFullLengthBridges() {
        return fullLengthBridges;
    }


    public int getShortLengthBridges() {
        return shortLengthBridges;
    }

    public int getFullLengthBridgesPlate() {
        return fullLengthBridgesPlate;
    }

    public int getShortLengthBridgesPlate() {
        return shortLengthBridgesPlate;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    // Вспомогательные методы для ввода
    private int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Введите число, пожалуйста: ");
            }
        }
    }

    private int getIntInputPanelHeight(Scanner scanner) {
        while (true) {
            try {
                int panelHeight = Integer.parseInt(scanner.nextLine().trim());
                if (panelHeight < 1000 ) {
                    System.out.println("Ошибка: панель не может быть меньше 1000 мм. Попробуйте снова.");
                    continue;
                }
                return panelHeight;
            } catch (NumberFormatException e) {
                System.out.print("Введите число, пожалуйста: ");
            }
        }
    }


}