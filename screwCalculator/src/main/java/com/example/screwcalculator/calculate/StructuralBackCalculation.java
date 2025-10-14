package com.example.screwcalculator.calculate;

import com.example.screwcalculator.frames.StructuralFrame;

public class StructuralBackCalculation {

    StructuralFrame structuralFrame;

    public StructuralBackCalculation(StructuralFrame structuralFrame) {
        this.structuralFrame = structuralFrame;
    }

    public int calculateSBScrew() {
        int windowAndVerticalShortSIngleScrew = 0;
        int windowBridgePlateScrew = 0;
        if (structuralFrame.isHasWindow()) {
            windowAndVerticalShortSIngleScrew = windowAndAboveWindow();
            windowBridgePlateScrew = windowBridgePlate();
        }
        int singleFullCScrew = verticalSingleFull();
        int singleFullAndBPlateScrew = verticalSingleFullAndBPlate();
        return windowAndVerticalShortSIngleScrew + windowBridgePlateScrew + singleFullCScrew + singleFullAndBPlateScrew;
    }

    public int verticalSingleFull() {
        int singleFull = structuralFrame.getVerticalSingleFull() * 2;
        System.out.println(" Количество SB вертикальных одиночных " + singleFull);
        return singleFull;
    }

    public int verticalSingleFullAndBPlate() {
        int singleFullAndPlate = structuralFrame.getVerticalSingleFull() * structuralFrame.getFullLengthBridgesPlate() * 2;
        System.out.println("Количество SB вертикальных одиночных и пластины бридж полной длинны " + singleFullAndPlate);
        return singleFullAndPlate;
    }


    public int windowAndAboveWindow() {
        int shortSingleAboveWindow = (structuralFrame.getVerticalAboveWindow() + 2) * 2 * 2;
        System.out.println("Количество SB вертикальных одиночных и пластины бридж полной длинны " + shortSingleAboveWindow);
        return shortSingleAboveWindow;
    }

    public int windowBridgePlate() {
        int shortWindowBPlate = (structuralFrame.getShortLengthBridgesPlate() * 4) + ((((structuralFrame.getVerticalSingleFull() - structuralFrame.getVerticalDoubleFull() - structuralFrame.getVerticalTripleFull()) * 2) - 2)
                * structuralFrame.getFullLengthBridgesPlate());
        System.out.println("Количество SB вертикальных одиночных и пластины бридж полной длинны " + shortWindowBPlate);
        return shortWindowBPlate;
    }


}