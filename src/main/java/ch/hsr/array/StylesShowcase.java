package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.domain.styles.*;
import ch.hsr.adv.commons.core.logic.domain.styles.presets.ADVDefaultStyle;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVEnumStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;

public class StylesShowcase {
    // instantiate data structure container
    private static final int LENGTH = 10;
    private static final Boolean[] array = new Boolean[LENGTH];
    private static final ArrayModule arrayModule = new ArrayModule("StylesShowcase", array);

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        for (int i = 0; i < LENGTH; i++) {
            array[i] = true;
        }

        // -------- snapshot 1 -------- //
        setStyle(0, new ADVDefaultStyle());
        setStyle(1, new ADVErrorStyle());
        setStyle(2, new ADVInfoStyle());
        setStyle(3, new ADVSuccessStyle());
        setStyle(4, new ADVWarningStyle());
        ADV.snapshot(arrayModule, "Using preset styles.");

        // -------- snapshot 2 -------- //
        setStyle(5, new ADVEnumStyle(
                ADVColor.ORANGE, ADVStrokeStyle.DASHED, ADVStrokeThickness.THIN));
        setStyle(6, new ADVEnumStyle(
                ADVColor.LIGHTGREY, ADVStrokeStyle.DOTTED, ADVStrokeThickness.MEDIUM, ADVColor.DARKGREY));
        setStyle(7, new ADVEnumStyle(
                ADVColor.YELLOW, ADVStrokeStyle.SOLID, ADVStrokeThickness.MEDIUM, ADVColor.RED));
        ADV.snapshot(arrayModule, "Using enum style.");

        // -------- snapshot 3 -------- //
        setStyle(8, new ADVValueStyle(0xff66ff, ADVStrokeStyle.DASHED, 4));
        setStyle(9, new ADVValueStyle(0xffffcc, 0xcc9900, ADVStrokeStyle.DOTTED, 2));
        ADV.snapshot(arrayModule, "Using value style.");
    }


    private static void setStyle(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }

}
