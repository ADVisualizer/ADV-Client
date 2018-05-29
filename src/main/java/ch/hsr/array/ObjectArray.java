package ch.hsr.array;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;


public class ObjectArray {
    // instantiate data structure container
    private static final String[] objectArray = new String[7];
    private static final ArrayModule arrayModule = new ArrayModule("ObjectArray", objectArray);

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);
        arrayModule.setShowObjectRelations(true);

        // instantiate data structure container
        objectArray[0] = "this";
        objectArray[1] = "is";
        objectArray[2] = "an";
        objectArray[3] = "array";
        objectArray[4] = "of";
        objectArray[5] = "string";
        objectArray[6] = "objects";

        ADV.snapshot(arrayModule, "Objects are not directly in the array. " +
                "The array holds only a reference to the object.");

        objectArray[5] = null;

        ADV.snapshot(arrayModule, "The reference is removed, if the field is null");
    }
}


