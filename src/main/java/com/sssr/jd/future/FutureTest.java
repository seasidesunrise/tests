package com.sssr.jd.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //Thread.sleep(5000);

                int sum = 0;
                for (int i = 0;i< 10000000;i++) {
                    sum += i;
                }

                //Thread.sleep(5000);
                return new Random().nextInt(10);
            }
        };

        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        new Thread(task).start();

        int num = 0;
        while (true && num++ < 15) {
            try {
                Thread.sleep(10);
                System.out.println("isDone:" + task.isDone());
//                System.out.println(task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            catch (ExecutionException ne) {
//                ne.printStackTrace();
//            }
        }

    }

}
