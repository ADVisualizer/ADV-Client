package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class BubbleSort {
    // instantiate data structure container
    private static final MyArray<Integer> array = new MyArray<>(new Integer[6]);
    private static final ArrayModule<Integer> arrayModule =
            new ArrayModule<>("BubbleSort", array.getArray());

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        array.set(0, 45);
        array.set(1, 1);
        array.set(2, 4);
        array.set(3, 5);
        array.set(4, 59);
        array.set(5, -4);

        bubblesort(array);

        ADV.disconnect();
    }

    private static void bubblesort(MyArray<Integer> array) throws ADVException {
        Integer temp;
        for (int i = 1; i < array.getSize(); i++) {
            for (int j = 0; j < array.getSize() - i; j++) {

                clearStyles();
                setStyle(j, new ADVInfoStyle());
                setStyle(j + 1, new ADVInfoStyle());

                ADV.snapshot(arrayModule);

                if (array.get(j) > array.get(j + 1)) {
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);

                    ADV.snapshot(arrayModule);
                }
            }
        }
    }

    private static void clearStyles() {
        arrayModule.getStyleMap().clear();
    }

    private static void setStyle(int i, ADVStyle style) {
        arrayModule.getStyleMap().put(i, style);
    }

}


