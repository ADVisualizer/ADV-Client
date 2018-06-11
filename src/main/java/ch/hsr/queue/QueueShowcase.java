package ch.hsr.queue;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
import ch.hsr.adv.lib.queue.logic.QueueModule;
import ch.hsr.adv.lib.queue.logic.domain.ADVQueue;
import ch.hsr.queue.model.FIFOQueue;

public class QueueShowcase {
    private static final ADVQueue<Integer> queue = new FIFOQueue<>();
    private static final QueueModule module = new QueueModule("Queue", queue);


    public static void main(String[] args) throws ADVException {
        ADV.launch(args);


        ADV.snapshot(module, "Empty queue");
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        ADV.snapshot(module, "Inserted initial entries");

        queue.removeMin();
        setStyle(0,new ADVWarningStyle());
        setStyle(1,new ADVSuccessStyle());
        ADV.snapshot(module, "Removed min entry");

        queue.removeMin();
        ADV.snapshot(module, "Removed min entry");

        queue.insert(2);
        ADV.snapshot(module, "Inserted second entry again");

        queue.min();
        ADV.snapshot(module, "Min does not change the queue values");
    }

    private static void setStyle(int i, ADVStyle style) {
        module.getStyleMap().put(i, style);
    }
}
