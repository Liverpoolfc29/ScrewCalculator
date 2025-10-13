package com.example.screwcalculator.calculate;


import com.example.screwcalculator.frames.StructuralFrame;

public class StructuralCalculation {

    StructuralFrame structuralFrame;

    private final int screwGapInDoubleFull = 300;

    public StructuralCalculation(StructuralFrame structuralFrame) {
        this.structuralFrame = structuralFrame;
    }

    public int StructuralFrameCalculate() {
        int singleShortStuds= 0;
        int shortLengthBridgeScrew = 0;
        if (structuralFrame.isHasWindow()) {
            singleShortStuds = countScrewVerticalSingleShortStuds(structuralFrame);
            shortLengthBridgeScrew = countShortLengthBridgeScrew(structuralFrame);
        }
        int singleStuds = countScrewVerticalSingleStuds(structuralFrame);
        int doubleTripleStuds = countScrewVerticalDoubleTripleStuds(structuralFrame);
        int fullLengthBridgesScrew = countFullLengthBridgesScrew(structuralFrame);
        int stiffenersScrew = countStiffenersScrew(structuralFrame);
        int mountPlateScrew = countMountPlateScrew(structuralFrame);
        return singleStuds + singleShortStuds + doubleTripleStuds + fullLengthBridgesScrew + shortLengthBridgeScrew + stiffenersScrew + mountPlateScrew;
    }

    public int countScrewVerticalSingleShortStuds(StructuralFrame structuralFrame) {
        // количество шурупов на пересечениях вертикальных коротких профилей и горизонтальных вернхнего и нижнего + окно между ними
        int singleShort = (structuralFrame.getVerticalAboveWindow() + structuralFrame.getVerticalBelowWindow()) * 4;
        System.out.println(" Количество шурупов вертикальных коротких профилей : = " + singleShort);
        return singleShort;
    }

    public int countScrewVerticalSingleStuds(StructuralFrame structuralFrame) {
        // количество шурупов на пересечениях вертикальных профилей и горизонтальных верхнего и нижнего профиля рамы
        int singleFull = structuralFrame.getVerticalSingleFull() * 4;
        System.out.println(" Количество шурупов вертикальных полных профилей : = " + singleFull);
        return singleFull;
    }

    public int countScrewVerticalDoubleTripleStuds(StructuralFrame structuralFrame) {
        int panelHeight = structuralFrame.getPanelHeight();

        int verticalDoubleFull = structuralFrame.getVerticalDoubleFull();       //
        if (verticalDoubleFull != 0) {
            int countScrewInDoubleFull = (int) Math.ceil((double) panelHeight / screwGapInDoubleFull * 2);
            int doubleScrew = countScrewInDoubleFull * verticalDoubleFull;
            System.out.println(" Количество шурупов вертикальных парных профилей : = " + doubleScrew);
            return doubleScrew;
        }
        int verticalTripleFull = structuralFrame.getVerticalTripleFull();
        if (verticalTripleFull != 0) {
            int tripleScrew = (int) Math.ceil((double) (panelHeight / screwGapInDoubleFull * 2) * 4);
            System.out.println(" Количество шурупов вертикальных тройных профилей : = " + tripleScrew);
            return tripleScrew;
        }
        return 0;
    }

    public int countFullLengthBridgesScrew(StructuralFrame structuralFrame) {
        int countScrewIntersectBridgesAndSingleFull = ((structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalAboveWindow()) * structuralFrame.getFullLengthBridges()) * 2;
        int countScrewIntersectBridgePlateAndSingleFull = ((structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalAboveWindow()) * structuralFrame.getFullLengthBridgesPlate()) * 2;
        int fullBridgeScrew = countScrewIntersectBridgesAndSingleFull + countScrewIntersectBridgePlateAndSingleFull;
        System.out.println(" Количество шурупов бриджей и пластины полной длинны : = " + fullBridgeScrew);
        return fullBridgeScrew;
    }

    public int countShortLengthBridgeScrew(StructuralFrame structuralFrame) {
        int countScrewShortBridges = ((structuralFrame.getVerticalSingleFull() - 2) * structuralFrame.getShortLengthBridges()) * 2;
        int countScrewShortBridgePlate = ((structuralFrame.getVerticalSingleFull() - 2) * structuralFrame.getShortLengthBridgesPlate()) * 2;
        int shortBridgeScrew = countScrewShortBridges + countScrewShortBridgePlate;
        System.out.println(" Количество шурупов бриджей и пластины короткой длинны : = " + shortBridgeScrew);
        return shortBridgeScrew;
    }

    public int countStiffenersScrew(StructuralFrame structuralFrame) {
        int windowStiffeners = 0;
        int stiffeners = structuralFrame.getStiffeners();
        if (structuralFrame.hasWindowCasing() != 0) {
            windowStiffeners = stiffeners + 4;
        }
        int stiffenersScrew = windowStiffeners + stiffeners * 6;
        System.out.println(" Количество шурупов стифнерса : = " + stiffenersScrew);
        return stiffenersScrew;
    }

    public int countMountPlateScrew(StructuralFrame structuralFrame) {
        int mountPlate = structuralFrame.getMountPlate();
        int mountPlateScrew = mountPlate * 4;
        System.out.println(" Количество шурупов пластины крепления : = " + mountPlateScrew);
        return mountPlateScrew;
    }

    public int getScrewGapInDoubleFull() {
        return screwGapInDoubleFull;
    }
}