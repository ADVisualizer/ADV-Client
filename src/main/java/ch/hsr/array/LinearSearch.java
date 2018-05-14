package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class LinearSearch {

    // instantiate data structure container
    private static final MyArray<Integer> array = new MyArray<>(new Integer[7]);
    private static final ArrayModule<Integer> arrayModule =
            new ArrayModule<>("LinearSearch", array.getArray());

    public static void main(String[] args) throws ADVException, InterruptedException {

        ADV.launch(args);

        array.set(0, 8);
        array.set(1, 12);
        array.set(2, 1);
        array.set(3, 140);
        array.set(4, -4);
        array.set(5, 2);
        array.set(6, 5);

        // we are looking for the item with the value 2
        int searchItem = 2;

        for (int i = 0; i < array.getSize(); i++) {
            clearStyles();
            int currentItem = array.get(i);
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


