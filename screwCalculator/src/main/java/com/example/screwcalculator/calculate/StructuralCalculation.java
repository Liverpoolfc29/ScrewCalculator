package com.example.screwcalculator.calculate;


import com.example.screwcalculator.frames.StructuralFrame;

public class StructuralCalculation {

    StructuralFrame structuralFrame;

    private final int screwGapInDoubleFull = 300;

    public int StructuralFrameCalculate() {
        int singleStuds = countScrewVerticalSingleStuds(structuralFrame);
        int doubleTripleStuds = countScrewVerticalDoubleTripleStuds(structuralFrame);
        int fullLengthBridgesScrew = countFullLengthBridgesScrew(structuralFrame);
        int shortLengthBridgeScrew = countShortLengthBridgeScrew(structuralFrame);
        int stiffenersScrew = countStiffenersScrew(structuralFrame);
        int mountPlateScrew = countMountPlateScrew(structuralFrame);
        return singleStuds + doubleTripleStuds + fullLengthBridgesScrew + shortLengthBridgeScrew + stiffenersScrew + mountPlateScrew;
    }

    public int countScrewVerticalSingleStuds(StructuralFrame structuralFrame) {
        // количество шурупов на пересечениях вертикальных профилей и горизонтальных аерхнего и нижнего
        return structuralFrame.getVerticalSingleFull() * 4;
    }

    public int countScrewVerticalDoubleTripleStuds(StructuralFrame structuralFrame) {

        int panelHeight = structuralFrame.getPanelHeight();

        int verticalDoubleFull = structuralFrame.getVerticalDoubleFull();       //
        if (verticalDoubleFull != 0) {
            int countScrewInDoubleFull = (int) Math.ceil((double) panelHeight / screwGapInDoubleFull * 2);
            return countScrewInDoubleFull * verticalDoubleFull;
        }
        int verticalTripleFull = structuralFrame.getVerticalTripleFull();
        if (verticalTripleFull != 0) {
            return (int) Math.ceil((double) (panelHeight / screwGapInDoubleFull * 2) * 4);
        }
        return 0;
    }

    public int countFullLengthBridgesScrew(StructuralFrame structuralFrame) {
        int countScrewIntersectBridgesAndSingleFull = structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalDoubleFull() + structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalAboveWindow()
                * structuralFrame.getFullLengthBridges() * 2;
        int countScrewIntersectBridgePlateAndSingleFull = structuralFrame.getFullLengthBridgesPlate() + structuralFrame.getVerticalDoubleFull() + structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalAboveWindow()
                * structuralFrame.getFullLengthBridgesPlate() * 2;
        return countScrewIntersectBridgesAndSingleFull + countScrewIntersectBridgePlateAndSingleFull;
    }

    public int countShortLengthBridgeScrew(StructuralFrame structuralFrame) {
        int countScrewIntersectBridgesAndSingleFull = structuralFrame.getVerticalSingleFull() + structuralFrame.getVerticalDoubleFull() + structuralFrame.getVerticalSingleFull()
                * structuralFrame.getShortLengthBridges() * 2;
        int countScrewIntersectBridgePlateAndSingleFull = structuralFrame.getFullLengthBridgesPlate() + structuralFrame.getVerticalDoubleFull() + structuralFrame.getVerticalSingleFull()
                * structuralFrame.getShortLengthBridges() * 2;
        return countScrewIntersectBridgesAndSingleFull + countScrewIntersectBridgePlateAndSingleFull;
    }

    public int countStiffenersScrew(StructuralFrame structuralFrame) {
        int windowStiffeners = 0;
        int stiffeners = structuralFrame.getStiffeners();
        if (structuralFrame.hasWindowCasing() != 0) {
            windowStiffeners = stiffeners + 4;
        }
        return windowStiffeners + stiffeners * 6;
    }

    public int countMountPlateScrew(StructuralFrame structuralFrame) {
        int mountPlate = structuralFrame.getMountPlate();
        return mountPlate * 4;
    }

    public int getScrewGapInDoubleFull() {
        return screwGapInDoubleFull;
    }
}