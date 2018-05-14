package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;


public class BubbleSort {
    // instantiate data structure container
    private static final Integer[] array = new Integer[6];
    private static final ArrayModule<Integer> arrayModule =
            new ArrayModule<>("BubbleSort", array);

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        array[0] = 1;
        array[1] = 4;
        array[2] = 5;
        array[3] = 59;
        array[4] = 12;
        array[5] = -4;

        bubblesort(array);

        ADV.disconnect();
    }

    private static void bubblesort(Integer[] array) throws ADVException {
        Integer temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {

                clearStyles();
                setStyle(j, new ADVInfoStyle());
                setStyle(j + 1, new ADVInfoStyle());

                ADV.snapshot(arrayModule);

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

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


