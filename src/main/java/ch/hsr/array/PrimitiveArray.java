package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class PrimitiveArray {
    // instantiate data structure container
    private static final MyArray<Integer> primitiveArray = new MyArray<>(new Integer[10]);
    private static final ArrayModule<Integer> arrayModule =
            new ArrayModule<>("Primitive Array", primitiveArray.getArray());


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        primitiveArray.set(0, 1);
        primitiveArray.set(3, 1);
        primitiveArray.set(0, 3);
        primitiveArray.set(5, 4);
        ADV.snapshot(arrayModule, "First Snapshot");

        primitiveArray.set(0, 0);
        primitiveArray.set(1, 1);
        primitiveArray.set(2, 2);
        primitiveArray.set(3, 3);
        ADV.snapshot(arrayModule, "Second Snapshot");

        ADV.disconnect();
    }
}


