package com.example.screwcalculator.calculate;


import com.example.screwcalculator.frames.StructuralFrame;

public class StructuralCalculation {

    private final int screwGapInDoubleFull = 300;


    public int countScrewVerticalSingleStuds(StructuralFrame structuralFrame) {

        // количество шурупов на пересечениях вертикальных профилей и горизонтальных аерхнего и нижнего

        return structuralFrame.getVerticalSingleFull() * 2;
    }

    public int countScrewVerticalDoubleStuds(StructuralFrame structuralFrame) {

        int verticalDoubleFull = structuralFrame.getVerticalDoubleFull();       //
        int panelHeight = structuralFrame.getPanelHeight();
        int countScrewInDoubleFull = panelHeight / screwGapInDoubleFull;
        return countScrewInDoubleFull * verticalDoubleFull;
    }

    public int countBridgesScrew(StructuralFrame structuralFrame) {
        int countScrewIntersectBridgesAndSingleFull = structuralFrame.getVerticalSingleFull() * structuralFrame.getFullLengthBridges() * 2;
        int countScrewIntersectBridgePlateAndSingleFull = structuralFrame.getFullLengthBridgesPlate() * structuralFrame.getFullLengthBridgesPlate() * 2;
        return countScrewIntersectBridgesAndSingleFull + countScrewIntersectBridgePlateAndSingleFull;
    }

    public int getScrewGapInDoubleFull() {
        return screwGapInDoubleFull;
    }
}
