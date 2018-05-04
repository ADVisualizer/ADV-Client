package ch.hsr.array;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.*;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.*;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;

import java.util.Random;

public class StylesShowcase {
    private static final int LENGTH = 10;

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);
        MyArray<Boolean> array = new MyArray<>(LENGTH, "StylesShowcase");

        Random rnd = new Random();
        for (int i = 0; i < LENGTH; i++) {
            array.set(i, true);
        }

        // -------- snapshot 1 -------- //
        array.getStyleMap().put(0, new ADVDefaultStyle());
        array.getStyleMap().put(1, new ADVErrorStyle());
        array.getStyleMap().put(2, new ADVInfoStyle());
        array.getStyleMap().put(3, new ADVSuccessStyle());
        array.getStyleMap().put(4, new ADVWarningStyle());
        ADV.snapshot(array, "Using preset styles.");

        // -------- snapshot 2 -------- //
        array.getStyleMap().put(5, new ADVEnumStyle(ADVColor.ORANGE, ADVStrokeStyle.DASHED, ADVStrokeThickness.THIN));
        array.getStyleMap().put(6, new ADVEnumStyle(ADVColor.LIGHTGREY, ADVStrokeStyle.DOTTED, ADVStrokeThickness
                .MEDIUM, ADVColor.DARKGREY));
        array.getStyleMap().put(7, new ADVEnumStyle(ADVColor.YELLOW, ADVStrokeStyle.SOLID, ADVStrokeThickness
                .MEDIUM, ADVColor.RED));
        ADV.snapshot(array, "Using enum style.");

        // -------- snapshot 3 -------- //
        array.getStyleMap().put(8, new ADVValueStyle(0xff66ff, ADVStrokeStyle.DASHED, 4));
        array.getStyleMap().put(9, new ADVValueStyle(0xcc9900, ADVStrokeStyle.DOTTED, 2, 0xffffcc));
        ADV.snapshot(array, "Using value style.");
    }

}
