package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;


public class ObjectArray {
    // instantiate data structure container
    private static final String[] objectArray = new String[5];
    private static final ArrayModule<String> arrayModule =
            new ArrayModule<>("ObjectArray", objectArray);


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        arrayModule.setShowObjectRelations(true);
        objectArray[0] = "This";
        objectArray[1] = "is";
        objectArray[2] = "an";
        objectArray[3] = "Object";

        ADV.snapshot(arrayModule, "Objects are not directly in the array. The array holds only a reference to the " +
                "object.");

        objectArray[0] = null;
        objectArray[1] = "is";
        objectArray[2] = "an";
        objectArray[3] = null;

        ADV.snapshot(arrayModule);

        ADV.disconnect();
    }
}


