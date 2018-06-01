package ch.hsr.stack;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

import java.util.HashMap;

public class TowerOfHanoi {
    private static final ADVStack<Integer> startPole = new Stack<>();
    private static final StackModule startPoleModule = new StackModule("Tower Of Hanoi", startPole);
    private static final ADVStack<Integer> middlePole = new ch.hsr.stack.model.Stack<>();
    private static final StackModule middlePoleModule = new StackModule("Tower Of Hanoi", middlePole);
    private static final ADVStack<Integer> endPole = new ch.hsr.stack.model.Stack<>();
    private static final StackModule endPoleModule = new StackModule("Tower Of Hanoi", endPole);
    private static final int DISC_NUMBER = 4;

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

       startPoleModule.getChildModules().add(middlePoleModule);
       startPoleModule.getChildModules().add(endPoleModule);

        // add discs
        for (int i = DISC_NUMBER; i > 0; i--){
            startPole.push(i);
        }

        ADV.snapshot(startPoleModule);

        solve(DISC_NUMBER, startPole, middlePole,endPole);
    }

    private static void solve(int n, ADVStack<Integer> start, ADVStack<Integer> middle, ADVStack<Integer> end) throws ADVException {
        if (n == 1) {
            moveDisc(start, end);
        } else {
            solve(n - 1, start, end, middle);
            moveDisc(start, end);
            solve(n - 1, middle, start, end);
        }
    }

    private static void moveDisc(ADVStack<Integer> start, ADVStack<Integer> end) throws ADVException {
        int top = start.pop();
        end.push(top);
        ADV.snapshot(startPoleModule);

    }
}
