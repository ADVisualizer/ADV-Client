package ch.hsr.stack;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.ADVModule;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

public class StackShowcase {

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        ADVStack<Integer> stack = new Stack<>();
        ADVModule module = new StackModule("Stack", stack);

        ADV.snapshot(module, "Empty stack");
        stack.push(1);
        stack.push(2);
        System.out.println(stack.toString());
        ADV.snapshot(module, "Pushed initial entries");

        stack.pop();
        System.out.println(stack.toString());
        ADV.snapshot(module, "Poped entry");

        stack.push(2);
        System.out.println(stack.toString());
        ADV.snapshot(module, "Pushed second entry again");

        stack.top();
        System.out.println(stack.toString());
        ADV.snapshot(module, "Top does not change the stack values");
        ADV.disconnect();
    }
}

