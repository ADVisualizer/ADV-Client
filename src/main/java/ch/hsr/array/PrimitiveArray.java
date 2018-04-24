package ch.hsr.array;

import ch.adv.lib.core.logic.ADV;
import ch.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class PrimitiveArray {

    public static void main(String[] args) throws ADVException {

        ADV adv = ADV.launch(args);

        MyArray<Object> primitiveArray = new MyArray<>(10, "Primitive Array");

        primitiveArray.set(0, 1);
        primitiveArray.set(3, 1);
        primitiveArray.set(0, 3);
        primitiveArray.set(5, 4);
        adv.snapshot(primitiveArray, "First Snapshot");

        primitiveArray.set(0, 0);
        primitiveArray.set(1, 1);
        primitiveArray.set(2, 2);
        primitiveArray.set(3, 3);
        adv.snapshot(primitiveArray, "Second Snapshot");

        adv.disconnect();
    }
}


