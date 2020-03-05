package com.app.tests;

import com.app.runnable.AppThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        /*AppThread t1 = new AppThread();
        AppThread t2 = new AppThread();
        AppThread t3 = new AppThread();

        t1.start();
        t2.start();
        t3.start();*/

        Runnable runnable = ()->{
            try(BufferedReader reader = new BufferedReader(new FileReader(new File(
                    "/Users/neelshah/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter2/02_03/begin/sample.txt")))){
                String line = null;
                while((line = reader.readLine()) != null){
                    System.out.println(Thread.currentThread().getName()+ " reading the line: " + line);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        };

        /*Thread thread = new Thread(runnable);
        thread.start();*/

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);

    }
}
