package com.example.screwcalculator.frames;

import java.util.Scanner;

public class StructuralFrame {

    // Наличие окна
    private int hasWindowCasing;
    private boolean hasWindow = false;

    // Высота панели
    private int panelHeight;

    // Ширина панели
    private int panelWidth;

    // Профили
    private int verticalSingleFull;        // вертикальный одиночный полный
    private int verticalDoubleFull;        // вертикальный одиночный парный
    private int verticalTripleFull;        // вертикальный одиночный тройной
    private int verticalAboveWindow;       // вертикальный одиночный выше окна
    private int verticalBelowWindow;       // вертикальный одиночный ниже окна
    private int fullLengthBridges;         // бриджи полной длины
    private int shortLengthBridges;        // бриджи короткой длины
    private int fullLengthBridgesPlate;    // пластина бридж полной длины
    private int shortLengthBridgesPlate;   // пластина бриджи короткой длины
    private int stiffeners;                // кол Стифнерсов
    private int mountPlate;                // кол боковых пластина для крепления к каркасу здания

    public void inputFromUser(Scanner scanner) {
        System.out.println("=== Ввод Габаритов панели ===");

        // высота панели
        System.out.print("введите высоту панели в мм: ");
        panelHeight = getIntInputPanelHeight(scanner) - 245;

        // ширина панели
        System.out.print("введите ширину панели в мм: ");
        panelWidth = getIntInputPanelHeight(scanner);

        System.out.println("=== Ввод данных для структурной рамы ===");

        // Наличие окна
        System.out.print("Введите количество окон: ");
        hasWindowCasing = getIntInput(scanner);
        if (hasWindowCasing != 0) {
            hasWindow = true;
            System.out.print("Количество вертикальный одиночный выше окна: ");
            verticalAboveWindow = getIntInput(scanner);

            System.out.print("Количество вертикальный одиночный ниже окна: ");
            verticalBelowWindow = getIntInput(scanner);

            System.out.print("Количество бриджей короткой  длины: ");
            shortLengthBridges = getIntInput(scanner);

            System.out.print("Количество пластин бриджей короткой длины: ");
            shortLengthBridgesPlate = getIntInput(scanner);
        }

        // Профили & бриджи & пластины
        System.out.print("Количество вертикальный одиночный полный: ");
        verticalSingleFull = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный парный: ");
        verticalDoubleFull = getIntInput(scanner);

        System.out.print("Количество вертикальный одиночный тройной: ");
        verticalTripleFull = getIntInput(scanner);

        System.out.print("Количество бриджей полной длины: ");
        fullLengthBridges = getIntInput(scanner);

        System.out.print("Количество пластин бриджей полной длины: ");
        fullLengthBridgesPlate = getIntInput(scanner);

        System.out.print("Количество Stiffeners (усилители возле пинов): ");
        stiffeners = getIntInput(scanner);

        System.out.print("Количество боковых пластин для крепления к каркасу здания: ");
        mountPlate = getIntInput(scanner);
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

    public int getVerticalTripleFull() {
        return verticalTripleFull;
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

    public int getStiffeners() {
        return stiffeners;
    }

    public int getMountPlate() {
        return mountPlate;
    }

    public int getPanelWidth() {
        return panelWidth;
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
                if (panelHeight < 1000) {
                    System.out.println("Ошибка: панель не может быть меньше 1000 мм. Попробуйте снова.");
                    continue;
                }
                return panelHeight;
            } catch (NumberFormatException e) {
                System.out.print("Введите число, пожалуйста: ");
            }
        }
    }


    public boolean isHasWindow() {
        return hasWindow;
    }

    public void setHasWindow(boolean hasWindow) {
        this.hasWindow = hasWindow;
    }

}