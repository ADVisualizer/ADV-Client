package ch.hsr.array;

import ch.adv.lib.core.logic.ADV;
import ch.adv.lib.core.logic.util.ADVException;
import ch.hsr.array.model.MyArray;

import java.util.Random;

public class CoordsShowcase {
    private static final int LENGTH = 5;

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);
        MyArray<Double> array = new MyArray<>(LENGTH, "CoordsShowcase");

        Random rnd = new Random();
        for (int i = 0; i < LENGTH; i++) {
            array.set(i, (double)Math.round(rnd.nextDouble() * 100d) / 100d);

        }

        // -------- snapshot 1 -------- //
        ADV.snapshot(array, "Using no coords.");

        // -------- snapshot 2 -------- //
        array.setCoordinates(0, 100, 500);
        array.setCoordinates(2, 500, 500);
        ADV.snapshot(array, "Using some coords");

        // -------- snapshot 3 -------- //
        array.setCoordinates(0, 100, 500);
        array.setCoordinates(1, 300, 500);
        array.setCoordinates(2, 500, 500);
        array.setCoordinates(3, 700, 500);
        array.setCoordinates(4, 900, 500);
        ADV.snapshot(array, "Using only coords");


    }

}
