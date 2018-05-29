package ch.hsr.stack;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

public class StackShowcase {

    private static final ADVStack<Integer> stack = new Stack<>();
    private static final StackModule stackModule = new StackModule("Stack", stack);


    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        ADV.snapshot(stackModule, "Empty stack");

        stack.push(1);
        stack.push(2);
        stack.push(3);
        setStyle(0, new ADVSuccessStyle());

        ADV.snapshot(stackModule, "Pushed initial entries");

        stack.push(4);
        stack.push(5);
        ADV.snapshot(stackModule, "Pushed more entries");

        stack.pop();
        ADV.snapshot(stackModule, "Popped entry");

        stack.push(2);
        ADV.snapshot(stackModule, "Pushed second entry again");

        Integer top = stack.top();
        System.out.println(top);
        ADV.snapshot(stackModule, "Top does not change the stack values");
    }

    private static void setStyle(int i, ADVStyle style) {
        stackModule.getStyleMap().put(i, style);
    }

}

