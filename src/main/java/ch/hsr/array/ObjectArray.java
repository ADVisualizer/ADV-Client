package ch.hsr.array;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ObjectArray {
    // instantiate data structure container
    private static final MyArray<String> objectArray = new MyArray<>(new String[5]);
    private static final ArrayModule<String> arrayModule =
            new ArrayModule<>("ObjectArray", objectArray.getArray());


    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        arrayModule.setShowObjectRelations(true);
        objectArray.set(0, "This");
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, "Object");

        ADV.snapshot(arrayModule, "Objects are not directly in the array. The array holds only a reference to the object.");

        objectArray.set(0, null);
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, null);
        objectArray.set(4, "Object");

        ADV.snapshot(arrayModule);

        ADV.disconnect();
    }
}


