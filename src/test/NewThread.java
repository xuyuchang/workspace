package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/12:37
 * Description:第三种方法创建线程Callable接口
 */
public class NewThread {
    public static void main(String[] args) {
        ThreadNum threadNum = new ThreadNum();
        FutureTask futureTssk  = new FutureTask(threadNum);
        Thread thread = new Thread(futureTssk);
        thread.start();
        try {
            Object obj = futureTssk.get();
            System.out.println("总和为：" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class ThreadNum implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum +=i;
                Thread.currentThread().sleep(100);
            }

        }
        return sum;
    }
}