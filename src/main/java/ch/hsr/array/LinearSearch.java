package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;


public class LinearSearch {

    // instantiate data structure container
    private static final Integer[] array = new Integer[7];
    private static final ArrayModule arrayModule = new ArrayModule("LinearSearch", array);

    public static void main(String[] args) throws ADVException, InterruptedException {

        ADV.launch(args);

        array[0] = 8;
        array[1] = 12;
        array[2] = 1;
        array[3] = 140;
        array[4] = -4;
        array[5] = 2;
        array[6] = 5;

        // we are looking for the item with the value 2
        int searchItem = 2;

        for (int i = 0; i < array.length; i++) {
            clearStyles();
            int currentItem = array[i];
            setStyle(i, new ADVInfoStyle());

            if (currentItem == searchItem) {
                setStyle(i, new ADVErrorStyle());
                ADV.snapshot(arrayModule, "");
                break;
            }

            ADV.snapshot(arrayModule);
        }

        ADV.disconnect();
    }

    /**
     * clear current styles and set search item style
     */
    private static void clearStyles() {
        arrayModule.getStyleMap().clear();
        setStyle(5, new ADVSuccessStyle());
    }

    private static void setStyle(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }

}


