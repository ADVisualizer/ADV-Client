package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.*;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.*;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;

import java.util.Random;

public class StylesShowcase {
    // instantiate data structure container
    private static final int LENGTH = 10;
    private static final MyArray<Boolean> array = new MyArray<>(new Boolean[LENGTH]);
    private static final ArrayModule<Boolean> arrayModule =
            new ArrayModule<>("StylesShowcase", array.getArray());


    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        Random rnd = new Random();
        for (int i = 0; i < LENGTH; i++) {
            array.set(i, true);
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
        setStyle(9, new ADVValueStyle(0xcc9900, ADVStrokeStyle.DOTTED, 2, 0xffffcc));
        ADV.snapshot(arrayModule, "Using value style.");
    }


    private static void setStyle(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }

}
