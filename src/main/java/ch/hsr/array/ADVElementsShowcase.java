package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;


public class ADVElementsShowcase {
    // instantiate data structure container
    private static final String[] array = new String[5];
    private static final ArrayModule arrayModule = new ArrayModule("ADV Elements Showcase", array);

    public static void main(String[] args) throws ADVException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        // instantiate data structure container
        array[0] = "Hello";
        ADV.snapshot(arrayModule, "Changing Coords");
        array[1] = "World";
        setCurrentItem(1, new ADVWarningStyle());
        array[2] = "How's";
        setCurrentItem(2, new ADVInfoStyle());
        array[3] = "it";
        setCurrentItem(3, new ADVErrorStyle());
        array[4] = "going";
        setCurrentItem(4, new ADVSuccessStyle());
        ADV.snapshot(arrayModule, "Sentence");

        array[0] = "1";
        ADV.snapshot(arrayModule, "0 -> 1");

        array[1] = "2";
        ADV.snapshot(arrayModule, "1 -> 2");

        array[2] = "3";
        ADV.snapshot(arrayModule, "2 -> 3");

        array[3] = "4";
        ADV.snapshot(arrayModule, "3 -> 4");

        array[4] = "5";
        ADV.snapshot(arrayModule, "4 -> 5");

        array[0] = "11";
        ADV.snapshot(arrayModule, "11");

        array[1] = "12";
        ADV.snapshot(arrayModule, "12");

        array[2] = "13";
        ADV.snapshot(arrayModule, "13");

        array[3] = "14";
        ADV.snapshot(arrayModule, "14");

        array[4] = "15";
        ADV.snapshot(arrayModule, "15");

        ADV.disconnect();
    }

    private static void setCurrentItem(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }
}


