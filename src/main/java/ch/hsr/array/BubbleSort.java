package ch.hsr.array;

import ch.adv.lib.array.domain.ArrayRelation;
import ch.adv.lib.core.app.ADV;
import ch.adv.lib.core.domain.ADVRelation;
import ch.adv.lib.core.domain.styles.presets.ADVInfoStyle;
import ch.adv.lib.core.util.ADVException;
import ch.hsr.array.model.MyArray;


public class BubbleSort {

    private static ADV adv;

    public static void main(String[] args) throws ADVException, InterruptedException {

        adv = ADV.launch(args);

        // instantiate data structure container
        MyArray<Integer> array = new MyArray<>(6, "BubbleSort");
        array.set(0, 45);
        array.set(1, 1);
        array.set(2, 4);
        array.set(3, 5);
        array.set(4, 59);
        array.set(5, -4);

        bubblesort(array);

        adv.disconnect();
    }

    public static void bubblesort(MyArray<Integer> array) {
        Integer temp;
        for (int i = 1; i < array.getSize(); i++) {
            for (int j = 0; j < array.getSize() - i; j++) {

                array.clearRelations();
                array.clearStyles();

                ADVRelation relation = new ArrayRelation(j, j + 1);
                array.addRelation(relation);
                array.getStyleMap().put(j, new ADVInfoStyle());
                array.getStyleMap().put(j + 1, new ADVInfoStyle());

                adv.snapshot(array);

                if (array.get(j) > array.get(j + 1)) {
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    adv.snapshot(array);
                }
            }
        }
    }

}


