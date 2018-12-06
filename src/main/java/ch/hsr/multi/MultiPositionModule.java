package ch.hsr.multi;

import ch.hsr.adv.commons.core.logic.domain.ModulePosition;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.queue.logic.QueueModule;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.queue.model.FIFOQueue;
import ch.hsr.stack.model.Stack;

import java.util.function.BiConsumer;

public class MultiPositionModule {

    private static final Integer[] firstArray = new Integer[5];
    private static final Integer[] secondArray = new Integer[5];
    private static final FIFOQueue<Integer> firstQueue = new FIFOQueue<>();
    private static final FIFOQueue<Integer> secondQueue = new FIFOQueue<>();
    private static final Stack<Integer> mainStack = new Stack<>();

    private static final StackModule mainStackModule =
            new StackModule("Multi Position Module", mainStack);
    private static final QueueModule firstQueueModule =
            new QueueModule("First Queue", firstQueue);
    private static final QueueModule secondQueueModule =
            new QueueModule("Second Queue", secondQueue);
    private static final ArrayModule firstArrayModule =
            new ArrayModule("First Array", firstArray);
    private static final ArrayModule secondArrayModule =
            new ArrayModule("Second Array", secondArray);

    public static void main(String[] args) throws ADVException {
        ADV.launch(null);

        firstQueueModule.setPosition(ModulePosition.LEFT);
        secondQueueModule.setPosition(ModulePosition.LEFT);
        mainStackModule.addChildModule(firstQueueModule);
        mainStackModule.addChildModule(secondQueueModule);

        fillStack();

        processStack();

        firstQueueModule.setPosition(ModulePosition.LEFT);
        secondQueueModule.setPosition(ModulePosition.RIGHT);
        firstArrayModule.setPosition(ModulePosition.TOP);
        secondArrayModule.setPosition(ModulePosition.BOTTOM);
        mainStackModule.addChildModule(firstArrayModule);
        mainStackModule.addChildModule(secondArrayModule);

        ADV.snapshot(mainStackModule);

        processQueue(firstQueue, (index, value) -> firstArray[index] = value);
        processQueue(secondQueue, (index, value) -> secondArray[index] = value);
    }

    private static void fillStack() throws ADVException {
        Integer[] randomSequence = {5, -1, 3, -5, 4, 1, -3, 2, -2, -4};
        for (Integer integer : randomSequence) {
            mainStack.push(integer);
        }

        ADV.snapshot(mainStackModule);
    }

    private static void processStack() throws ADVException {
        while (!mainStack.isEmpty()) {
            Integer next = mainStack.pop();
            if (next < 0) {
                firstQueue.insert(next);
            } else {
                secondQueue.insert(next);
            }
            ADV.snapshot(mainStackModule);
        }
    }

    private static void processQueue(FIFOQueue<Integer> inQueue,
                                     BiConsumer<Integer, Integer> out) throws ADVException {
        while (!inQueue.isEmpty()) {
            Integer next = inQueue.removeMin();
            int index = Math.abs(next) - 1;
            out.accept(index, next);
            ADV.snapshot(mainStackModule);
        }
    }
}
