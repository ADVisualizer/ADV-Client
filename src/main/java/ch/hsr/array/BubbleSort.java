package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVColor;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeStyle;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeThickness;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVEnumStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;


public class BubbleSort {
    // instantiate data structure container
    private static final Integer[] array = new Integer[6];
    private static final ArrayModule arrayModule = new ArrayModule("Bubble Sort", array);

    // styles
    private static final ADVStyle activeLeftStyle = new ADVEnumStyle(ADVColor.ORANGE_LIGHT,
            ADVColor.ORANGE_DARK,
            ADVStrokeStyle.SOLID,
            ADVStrokeThickness.STANDARD);
    private static final ADVStyle activeRightStyle = new ADVEnumStyle(ADVColor.ORANGE,
            ADVColor.ORANGE_DARK,
            ADVStrokeStyle.SOLID,
            ADVStrokeThickness.STANDARD);


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        array[0] = 1;
        array[1] = 4;
        array[2] = 5;
        array[3] = 59;
        array[4] = 12;
        array[5] = -4;

        bubblesort(array);
    }

    private static void bubblesort(Integer[] array) throws ADVException {

        int temp;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {

                clearStyles();
                setStyle(j, activeLeftStyle);
                setStyle(j + 1, activeRightStyle);

                ADV.snapshot(arrayModule);

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    setStyle(j, activeRightStyle);
                    setStyle(j + 1, activeLeftStyle);

                    ADV.snapshot(arrayModule);
                }
            }
        }
    }

    private static void clearStyles() {
        arrayModule.getStyleMap().clear();
    }

    private static void setStyle(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }

}


