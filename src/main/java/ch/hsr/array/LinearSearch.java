package ch.hsr.array;

import ch.adv.lib.core.logic.ADV;
import ch.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class LinearSearch {

    public static void main(String[] args) throws ADVException, InterruptedException {

        ADV.launch(args);

        MyArray<Object> array = new MyArray<>(7, "LinearSearch");
        array.set(0, 8);
        array.set(1, 12);
        array.set(2, 1);
        array.set(3, 140);
        array.set(4, -4);
        array.set(5, 2);
        array.set(6, 5);

        // we are looking for the item with the value 2
        int searchItem = 2;
        array.getStyleMap().put(5, new ADVSuccessStyle());

        for (int i = 0; i < array.getSize(); i++) {
            int currentItem = (int) array.get(i);
            array.getStyleMap().put(i, new ADVInfoStyle());

            if (currentItem == searchItem) {
                array.getStyleMap().put(i, new ADVErrorStyle());
                ADV.snapshot(array, "");
                break;
            }

            ADV.snapshot(array);
        }

        ADV.disconnect();
    }
}


