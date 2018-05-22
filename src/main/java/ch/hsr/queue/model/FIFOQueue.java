package ch.hsr.queue.model;

import ch.hsr.adv.lib.queue.logic.domain.ADVQueue;
import ch.hsr.adv.lib.queue.logic.exception.EmptyQueueException;

import java.util.ArrayList;
import java.util.List;

public class FIFOQueue<T> implements ADVQueue<T> {
    private List<T> queue = new ArrayList<>();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public T min() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue.get(0);
    }

    @Override
    public void insert(T t) {
        queue.add(t);
    }

    @Override
    public T removeMin() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue.remove(0);
    }
}
