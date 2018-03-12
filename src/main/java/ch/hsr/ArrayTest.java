package ch.hsr;

import ch.adv.lib.ADV;

public class ArrayTest {

    public static final void main(String[] args) {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch();

        // instantiate data structure container
        MyArray array = new MyArray(5);
        for (int i = 0; i < array.getSize(); i++) {
            array.setCurrentItem(i);
            ADV.snapshot(array);
        }

        ADV.snapshot(array);
        array.set(0, "Hello");

        ADV.snapshot(array);
        array.set(2, "World");
    }
}


