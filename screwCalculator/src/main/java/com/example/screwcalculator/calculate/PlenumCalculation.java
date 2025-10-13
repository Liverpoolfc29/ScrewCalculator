package com.example.screwcalculator.calculate;

import com.example.screwcalculator.frames.PlenumFrame;
import com.example.screwcalculator.frames.StructuralFrame;

public class PlenumCalculation {

    StructuralFrame structuralFrame;
    PlenumFrame plenumFrame;

    public PlenumCalculation(StructuralFrame structuralFrame, PlenumFrame plenumFrame) {
        this.structuralFrame = structuralFrame;
        this.plenumFrame = plenumFrame;
    }

    public int plenumFrameCalculate() {
        int windowStiffeners = 0;
        int topPlenumFrame = 0;
        int shortStuds = countScrewVerticalSingleShortStuds(plenumFrame);
        int fullStuds = countScrewVerticalSingleStuds(plenumFrame);
        int screwBetweenMT = betweenMT();
        if (structuralFrame.isHasWindow()) {
            windowStiffeners = countScrewWindowStiffeners();
        }
        if (plenumFrame.isHasTopPlenumFrame()) {
            topPlenumFrame = topPlenumFrameScrew(plenumFrame);
        }
        return shortStuds + fullStuds + windowStiffeners + topPlenumFrame + screwBetweenMT;
    }

    public int countScrewVerticalSingleShortStuds(PlenumFrame plenumFrame) {
        // количество шурупов на пересечениях вертикальных коротких профилей и горизонтальных вернхнего и нижнего + окно между ними
        int singleShort = ((plenumFrame.getVerticalAboveWindow() + plenumFrame.getVerticalBelowWindow()) * 4) * 4;
        System.out.println(" Количество шурупов вертикальных коротких профилей : = " + singleShort);
        return singleShort;
    }

    public int countScrewVerticalSingleStuds(PlenumFrame plenumFrame) {
        // количество шурупов на пересечениях вертикальных профилей и горизонтальных верхнего и нижнего профиля рамы
        int singleFull = ((plenumFrame.getVerticalSingleFull() * 2) * 4);
        System.out.println(" Количество шурупов вертикальных полных профилей : = " + singleFull);
        return singleFull;
    }

    public int countScrewWindowStiffeners() {
        int windowStiffenersScrew = 0;
        if (structuralFrame.isHasWindow()) {
            windowStiffenersScrew = 4 * 4;
        }
        System.out.println(" Количество шурупов WindowStiffeners : = " + windowStiffenersScrew);
        return windowStiffenersScrew;
    }

    public int topPlenumFrameScrew(PlenumFrame plenumFrame) {
        int plenumScrew = 0;
        if (plenumFrame.isHasTopPlenumFrame()) {
            plenumScrew = 4 * 4;
        }
        System.out.println(" Количество шурупов TopPlenumFrame : = " + plenumScrew);
        return plenumScrew;
    }

    public int betweenMT() {
        int MT = (int) Math.ceil((double) structuralFrame.getPanelWidth() / 600) + 4;
        System.out.println(" Количество шурупов на ширину панели : = " + MT);
        return MT;
    }

}