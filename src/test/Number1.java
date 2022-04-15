package test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/9:09
 * Description:
 */
public class Number1 extends Thread{
    private  static int num = 1;

    public static void main(String[] args) {
        Number1 n1 = new Number1();
        Number1 n2 = new Number1();
        n1.setName("线程一");
        n2.setName("线程二");
        n1.start();
        n2.start();
    }
    @Override
    public void run() {
        synchronized (Number1.class) {
            while (true){
                Number1.class.notify();
                if (num < 101){
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " :" + num++);
                    try {
                        Number1.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
