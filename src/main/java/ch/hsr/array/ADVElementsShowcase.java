package ch.hsr.array;

import ch.adv.lib.array.domain.ArrayRelation;
import ch.adv.lib.core.app.ADV;
import ch.adv.lib.core.domain.styles.presets.ADVErrorStyle;
import ch.adv.lib.core.domain.styles.presets.ADVInfoStyle;
import ch.adv.lib.core.domain.styles.presets.ADVSuccessStyle;
import ch.adv.lib.core.domain.styles.presets.ADVWarningStyle;
import ch.adv.lib.core.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ADVElementsShowcase {

    public static void main(String[] args) throws ADVException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV adv = ADV.launch(args);

        // draws a arrow from one element to the other
        ArrayRelation relation1 = new ArrayRelation(0, 1);
        relation1.setLabel("Relation");
        ArrayRelation relation2 = new ArrayRelation(1, 2);
        ArrayRelation relation3 = new ArrayRelation(2, 3);
        ArrayRelation relation4 = new ArrayRelation(3, 4);

        // instantiate data structure container
        MyArray array = new MyArray(5, "ADV Elements Showcase");
        array.set(0, "Hello");
        array.addRelation(relation1, relation2, relation3, relation4);

        adv.snapshot(array, "Changing Coords");
        array.set(1, "World");
        array.setCurrentItem(1, new ADVWarningStyle());
        array.set(2, "How's");
        array.setCurrentItem(2, new ADVInfoStyle());
        array.set(3, "it");
        array.setCurrentItem(3, new ADVErrorStyle());
        array.set(4, "going?");
        array.setCurrentItem(4, new ADVSuccessStyle());
        adv.snapshot(array, "Sentence");

        array.set(0, "1");
        adv.snapshot(array, "0 -> 1");

        array.set(1, "2");
        adv.snapshot(array, "1 -> 2");

        array.set(2, "3");
        adv.snapshot(array, "2 -> 3");

        array.set(3, "4");
        adv.snapshot(array, "3 -> 4");

        array.set(4, "5");
        adv.snapshot(array, "4 -> 5");

        array.set(0, "11");
        adv.snapshot(array, "11");

        array.set(1, "12");
        adv.snapshot(array, "12");

        array.set(2, "13");
        adv.snapshot(array, "13");

        array.set(3, "14");
        adv.snapshot(array, "14");

        array.set(4, "15");
        adv.snapshot(array, "15");

        adv.disconnect();
    }
}


