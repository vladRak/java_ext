package hw_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TunnelPool<T> {
    private final int POOL_SIZE;
    private final Semaphore semaphore;
    private final Queue<T> resources = new LinkedList<>();

    public TunnelPool(Queue<T> source) {
        resources.addAll(source);
        POOL_SIZE = source.size();
        semaphore = new Semaphore(POOL_SIZE, true);
    }

    public T getResource(long maxWaitMillis) throws ResourceException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
        throw new ResourceException(":превышено время ожидания");
    }

    public void returnResource(T res) {
        resources.add(res);
        semaphore.release();
    }
}