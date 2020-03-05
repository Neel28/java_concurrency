package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnable.UserProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExecutors {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<String> users = getUsersFromFile("/Users/neelshah/Downloads/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_07/begin/javaseconcurrency/new_users.txt");
        UserDao dao = new UserDao();
        for(String user: users){
            Future<Integer> future = service.submit(new UserProcessor(user, dao));
            /*try{
                System.out.println("Result of the operation is: " + future.get());
            } catch (InterruptedException e){
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
            } catch (ExecutionException e){
                Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
            }*/
        }
        service.shutdown();
        System.out.println("Main execution over!!");
    }

    public static List<String> getUsersFromFile(String filename){
        List<String> user = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line = null;
            while((line = reader.readLine()) != null){
                user.add(line);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e){
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
}
