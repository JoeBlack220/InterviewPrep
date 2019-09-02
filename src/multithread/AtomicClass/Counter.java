package multithread.AtomicClass;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger();

    public int next() {
        return this.value.incrementAndGet();
    }
}
