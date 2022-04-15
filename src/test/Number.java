package test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/8:54
 * Description:
 */
public class Number {
    public static void main(String[] args) {


        Number num = new Number();
        Number100 n = new Number100();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }


}

class Number100 implements Runnable {
    private static int num = 1;

    @Override
    public void run() {
        synchronized (this) {

            while (true) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num < 101) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
}