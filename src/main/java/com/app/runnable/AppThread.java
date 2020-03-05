package com.app.runnable;

import java.awt.image.BufferedImage;
import java.io.*;

public class AppThread extends Thread{

    @Override
    public void run(){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(
                "/Users/neelshah/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter2/02_03/begin/sample.txt")))){
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(Thread.currentThread().getName()+ " reading the line: " + line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
