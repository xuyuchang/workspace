package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/13:03
 * Description:创建线程的第四种方式：使用线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new NumThread());
//        executorService.shutdown();
        executorService.submit(new ThreadNum1());

        executorService.shutdown();

    }
}

class NumThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}


class ThreadNum1 implements Callable{

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 101; i++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
        return null;
    }

}