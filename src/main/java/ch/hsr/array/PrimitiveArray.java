package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;

import java.util.Arrays;


public class PrimitiveArray {
    // instantiate data structure container
    private static final Integer[] primitiveArray = new Integer[10];
    private static final ArrayModule arrayModule = new ArrayModule("Primitive Array", primitiveArray);


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        primitiveArray[0] = 0;
        primitiveArray[1] = 1;
        primitiveArray[3] = 3;
        primitiveArray[5] = 5;
        ADV.snapshot(arrayModule, "Empty value are default initialized with null");
    }
}


