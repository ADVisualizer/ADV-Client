package ch.hsr.queue;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.ADVModule;
import ch.hsr.adv.lib.queue.logic.QueueModule;
import ch.hsr.adv.lib.queue.logic.domain.ADVQueue;
import ch.hsr.queue.model.FIFOQueue;

public class QueueShowcase {
    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        ADVQueue<Integer> queue = new FIFOQueue<>();
        ADVModule module = new QueueModule("Queue", queue);

        ADV.snapshot(module, "Empty queue");
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        ADV.snapshot(module, "Inserted initial entries");

        queue.removeMin();
        ADV.snapshot(module, "Removed min entry");

        queue.removeMin();
        ADV.snapshot(module, "Removed min entry");

        queue.insert(2);
        ADV.snapshot(module, "Inserted second entry again");

        queue.min();
        ADV.snapshot(module, "Min does not change the queue values");
        ADV.disconnect();
    }
}
