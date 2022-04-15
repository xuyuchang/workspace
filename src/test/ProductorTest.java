package test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/9:35
 * Description:
 */
public class ProductorTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        productor.setName("生产者");
        consumer.setName("消费者");
        productor.start();
        consumer.start();
    }
}

class Productor extends Thread {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public   void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产" );
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.product();


        }
    }


}

class Consumer extends Thread {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public  void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费" );
        while (true) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consum();




        }
    }

}

class Clerk {
    private int ProductorNum = 0;
    public  synchronized void product() {

        if (ProductorNum < 20){
            System.out.println(Thread.currentThread().getName() + "生产第" + ++ProductorNum + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public  synchronized void consum() {

        if (ProductorNum > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + ProductorNum-- + "个产品");
            //notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}