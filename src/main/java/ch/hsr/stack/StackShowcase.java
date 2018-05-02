package ch.hsr.stack;

import ch.adv.lib.bootstrapper.ADV;
import ch.adv.lib.core.logic.ADVModule;
import ch.adv.lib.core.logic.util.ADVException;
import ch.adv.lib.stack.logic.StackModule;
import ch.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

public class StackShowcase {

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        ADVStack<Integer> stack = new Stack<>();
        ADVModule module = new StackModule<>("Stack", stack);

        ADV.snapshot(module, "Empty stack");
        stack.push(1);
        stack.push(2);
        ADV.snapshot(module, "Pushed initial entries");

        stack.pop();
        ADV.snapshot(module, "Poped entry");

        stack.push(2);
        ADV.snapshot(module, "Pushed second entry again");

        stack.top();
        ADV.snapshot(module, "Top does not change the stack values");
    }
}
