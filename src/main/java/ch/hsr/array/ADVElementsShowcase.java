package ch.hsr.array;

import ch.adv.lib.bootstrapper.ADV;
import ch.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
import ch.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ADVElementsShowcase {

    public static void main(String[] args) throws ADVException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        // instantiate data structure container
        MyArray<String> array = new MyArray<>(5, "ADV Elements Showcase");
        array.set(0, "Hello");
        ADV.snapshot(array, "Changing Coords");
        array.set(1, "World");
        array.setCurrentItem(1, new ADVWarningStyle());
        array.set(2, "How's");
        array.setCurrentItem(2, new ADVInfoStyle());
        array.set(3, "it");
        array.setCurrentItem(3, new ADVErrorStyle());
        array.set(4, "going?");
        array.setCurrentItem(4, new ADVSuccessStyle());
        ADV.snapshot(array, "Sentence");

        array.set(0, "1");
        ADV.snapshot(array, "0 -> 1");

        array.set(1, "2");
        ADV.snapshot(array, "1 -> 2");

        array.set(2, "3");
        ADV.snapshot(array, "2 -> 3");

        array.set(3, "4");
        ADV.snapshot(array, "3 -> 4");

        array.set(4, "5");
        ADV.snapshot(array, "4 -> 5");

        array.set(0, "11");
        ADV.snapshot(array, "11");

        array.set(1, "12");
        ADV.snapshot(array, "12");

        array.set(2, "13");
        ADV.snapshot(array, "13");

        array.set(3, "14");
        ADV.snapshot(array, "14");

        array.set(4, "15");
        ADV.snapshot(array, "15");

        ADV.disconnect();
    }
}


