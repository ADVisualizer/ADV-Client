package ch.hsr.array;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ObjectArray {

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        MyArray<String> objectArray = new MyArray<>(5, "ObjectArray");
        objectArray.setShowObjectRelations(true);
        objectArray.set(0, "This");
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, "Object");

        ADV.snapshot(objectArray, "Objects are not directly in the array. The array holds only a reference to the object.");

        objectArray.set(0, null);
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, null);
        objectArray.set(4, "Object");

        ADV.snapshot(objectArray);

        ADV.disconnect();
    }
}


