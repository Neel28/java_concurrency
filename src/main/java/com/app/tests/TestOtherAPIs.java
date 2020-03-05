package com.app.tests;

import com.app.runnable.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestOtherAPIs {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();
        try {
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());

            List<Future<Boolean>> futures = service.invokeAll(callables);
            for (Future<Boolean> future : futures) {
                System.out.println("operation result: " + future.get());
            }
        } catch (InterruptedException e){
            Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e){
            Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
        }

        service.shutdown();

        try{
            System.out.println("services shutdown? " + service.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException e){
            service.shutdownNow();
            Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
