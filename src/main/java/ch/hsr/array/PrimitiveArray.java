package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;


public class PrimitiveArray {
    // instantiate data structure container
    private static final Integer[] primitiveArray = new Integer[10];
    private static final ArrayModule arrayModule = new ArrayModule("Primitive Array", primitiveArray);


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        primitiveArray[0] = 1;
        primitiveArray[3] = 1;
        primitiveArray[1] = 3;
        primitiveArray[5] = 4;
        ADV.snapshot(arrayModule, "First Snapshot");

        primitiveArray[0] = 0;
        primitiveArray[1] = 1;
        primitiveArray[2] = 2;
        primitiveArray[3] = 3;
        ADV.snapshot(arrayModule, "Second Snapshot");

        ADV.disconnect();
    }
}


