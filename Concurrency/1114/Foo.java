class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger();
    private AtomicInteger secondJobDone = new AtomicInteger();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // 循环等待
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // 循环等待
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
