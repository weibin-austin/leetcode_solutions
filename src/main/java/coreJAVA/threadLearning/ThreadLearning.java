package coreJAVA.threadLearning;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadLearning {
    /*

        Three ways to creat thread:
        1. extend Thread class
	    2. implement Runnable interface
	    3. implement Callable<> interface

     */

    @Test
    public void Thread_test() {
        new Thread(() -> {
            System.out.println("This is Thead class");
        }).start();
    }

    @Test
    public void Runnable_test() throws ExecutionException, InterruptedException {
        Runnable runnable = new MyRunnable();
        runnable.run();
    }

    @Test
    public void Callable_test() throws Exception {
        Callable<String> callable = new MyCallable();
        String call = callable.call();
        System.out.println(call);

    }

    @Test
    public void ThreadPoll_test() throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);

        Future<String> future = fixedThreadPool.submit(new MyCallable());
        String result = future.get();
        System.out.println(result);

        fixedThreadPool.submit(new MyRunnable());

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(new MyRunnable());

        fixedThreadPool.shutdown();  // shutdown thread pool
        cachedThreadPool.shutdown();

    }


}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("This is Runnable interface Thread");
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() {
        return "This is Callable interface Thread";
    }
}

