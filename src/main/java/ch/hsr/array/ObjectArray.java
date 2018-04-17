package ch.hsr.array;

import ch.adv.lib.core.app.ADV;
import ch.adv.lib.core.util.ADVException;
import ch.hsr.array.model.MyArray;


public class ObjectArray {

    public static void main(String[] args) throws ADVException {

        ADV adv = ADV.launch(args);

        // instantiate data structure container
        MyArray<String> objectArray = new MyArray<>(5, "ObjectArray");
        objectArray.setShowObjectRelations(true);
        objectArray.set(0, "This");
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, "Object");

        adv.snapshot(objectArray, "");

        objectArray.set(0, null);
        objectArray.set(1, "is");
        objectArray.set(2, "an");
        objectArray.set(3, null);
        objectArray.set(4, "Object");

        adv.snapshot(objectArray, "");


        adv.disconnect();
    }
}


