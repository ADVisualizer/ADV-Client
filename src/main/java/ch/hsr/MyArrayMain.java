package ch.hsr;

import ch.adv.lib.ADV;
import ch.adv.lib.util.ADVException;


public class MyArrayMain {

    public static void main(String[] args) throws ADVException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV adv = ADV.launch(args);

        // instantiate data structure container
        MyArray array = new MyArray(5, "ArraySession");
        array.setCurrentItem(1);
        adv.snapshot(array, "changing current item");

        array.set(0, "Hello");
        adv.snapshot(array, "change index 0");

        array.set(2, "World");
        adv.snapshot(array, "change index 2");

        array.setCoords(1, 10, 50);
        adv.snapshot(array, "fixing position");


        adv.disconnect();
    }
}


