package ch.hsr;

import ch.adv.lib.core.app.ADV;
import ch.adv.lib.core.util.ADVException;


public class MyArrayMain {

    public static void main(String[] args) throws ADVException, InterruptedException {

        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV adv = ADV.launch(args);

        // instantiate data structure container
        MyArray array = new MyArray(5, "ArraySession");
        for (int i = 0; i < array.getArray().length; i++) {
            array.set(i, "1");
        }
        array.setCurrentItem(1);
        adv.snapshot(array, "1");

        for (int i = 0; i < array.getArray().length; i++) {
            array.set(i, "2");
        }
        adv.snapshot(array, "2");

        for (int i = 0; i < array.getArray().length; i++) {
            array.set(i, "3");
        }
        adv.snapshot(array, "3");

        array.setCoords(1, 10, 50);
        for (int i = 0; i < array.getArray().length; i++) {
            array.set(i, "4");
        }
        adv.snapshot(array, "4");
        for (int i = 0; i < array.getArray().length; i++) {
            array.set(i, "5");
        }
        adv.snapshot(array, "5");
        array.set(0, "6");
        adv.snapshot(array, "6");
        Thread.sleep(500);
        array.set(1, "7");
     //   test(null);
        adv.snapshot(array, "7");
        array.set(2, "8");
        adv.snapshot(array, "8");
        array.set(3, "9");
        adv.snapshot(array, "9");
        Thread.sleep(500);
        array.set(4, "10");
        adv.snapshot(array, "10");
        array.set(0, "11");
        adv.snapshot(array, "11");
        Thread.sleep(500);
        array.set(1, "12");
        adv.snapshot(array, "12");
        array.set(2, "13");
        adv.snapshot(array, "13");
        array.set(3, "14");
        adv.snapshot(array, "14");
        Thread.sleep(500);
        array.set(4, "15");
        adv.snapshot(array, "15");

        adv.disconnect();
    }

    private static void test(Object o) {
        System.out.println(o.toString());
    }
}


