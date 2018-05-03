package ch.hsr.stack;

import ch.adv.lib.bootstrapper.ADV;
import ch.adv.lib.core.logic.ADVModule;
import ch.adv.lib.core.logic.util.ADVException;
import ch.adv.lib.stack.logic.StackModule;
import ch.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.stack.model.Stack;

public class CustomContentStackShowcase {

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        CustomContentStackShowcase customStack = new CustomContentStackShowcase();
        customStack.showStackFeatures();
    }

    private void showStackFeatures() throws ADVException {
        ADVStack<StackContent> stack = new Stack<>();
        ADVModule module = new StackModule<>("Stack", stack);

        stack.push(new StackContent(1,"1", "2"));
        stack.push(new StackContent(2, "abc", "efg"));
        System.out.println(stack.toString());
        ADV.snapshot(module, "Pushed initial entries");

        stack.pop();
        System.out.println(stack.toString());
        ADV.snapshot(module, "Poped entry");

        stack.push(new StackContent(3, "33", "what?"));
        System.out.println(stack.toString());
        ADV.snapshot(module, "Pushed third entry");

        stack.top();
        System.out.println(stack.toString());
        ADV.snapshot(module, "Top does not change the stack values");
    }

    private class StackContent{
        int id;
        String value1;
        String value2;

        public StackContent(int id, String value1, String value2) {
            this.id = id;
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return id +": "+  value1 + ", " + value2;
        }
    }
}

