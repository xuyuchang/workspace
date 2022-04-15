import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/13:11
 * Description:
 */


class Ticket2 implements Runnable {
    private static int  ticketnum = 100;

    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            //ReentrantLock 方法解决线程安全问题try{lock.lock()}finally{lock.unlock()}
            try {
                //上锁
                lock.lock();
                if (ticketnum > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票，票号为" + ticketnum--);

                }
            }
            finally {
                //解锁
                lock.unlock();
            }
        }

           //show();
        }
    }
    //同步方法解决线程安全问题

//    private static synchronized void show() {
//
//
//
//            if (ticketnum > 0) {
//                try {
//                    Thread.currentThread().sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "买票，票号为" + ticketnum--);
//
//            }
//
//    }


public class TicketPlus {
    public static void main(String[] args) {
        Ticket2 t = new Ticket2();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

