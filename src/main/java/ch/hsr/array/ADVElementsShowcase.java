package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ADVElementsShowcase {
    // instantiate data structure container
    private static final MyArray<String> array = new MyArray<>(new String[5]);
    private static final ArrayModule<String> arrayModule =
            new ArrayModule<>("ADV Elements Showcase", array.getArray());


    public static void main(String[] args) throws ADVException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        // instantiate data structure container
        array.set(0, "Hello");
        ADV.snapshot(arrayModule, "Changing Coords");
        array.set(1, "World");
        setCurrentItem(1, new ADVWarningStyle());
        array.set(2, "How's");
        setCurrentItem(2, new ADVInfoStyle());
        array.set(3, "it");
        setCurrentItem(3, new ADVErrorStyle());
        array.set(4, "going?");
        setCurrentItem(4, new ADVSuccessStyle());
        ADV.snapshot(arrayModule, "Sentence");

        array.set(0, "1");
        ADV.snapshot(arrayModule, "0 -> 1");

        array.set(1, "2");
        ADV.snapshot(arrayModule, "1 -> 2");

        array.set(2, "3");
        ADV.snapshot(arrayModule, "2 -> 3");

        array.set(3, "4");
        ADV.snapshot(arrayModule, "3 -> 4");

        array.set(4, "5");
        ADV.snapshot(arrayModule, "4 -> 5");

        array.set(0, "11");
        ADV.snapshot(arrayModule, "11");

        array.set(1, "12");
        ADV.snapshot(arrayModule, "12");

        array.set(2, "13");
        ADV.snapshot(arrayModule, "13");

        array.set(3, "14");
        ADV.snapshot(arrayModule, "14");

        array.set(4, "15");
        ADV.snapshot(arrayModule, "15");

        ADV.disconnect();
    }

    private static void setCurrentItem(int i, ADVStyle style){
        arrayModule.getStyleMap().put(i, style);
    }
}


