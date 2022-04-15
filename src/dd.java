/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/10:16
 * Description:内含懒汉式单例模式和饿汉式单例模式
 */

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);

        }
    }
}

public class dd {
    public static void main(String[] args) {
        MThread m1 = new MThread();

        Thread t1 = new Thread(m1);
        t1.start();

    }


}

/*
恶汉式
 */
class Bank {
    private Bank() {

    }

    private static Bank bank = new Bank();

    public static Bank getBank() {
        return bank;
    }
}

/*
懒汉式
 */

/**
 *
 */

/**
 *
 */
class singleTonLH {
    private static singleTonLH instance = null;

    private singleTonLH() {
    }

    public static singleTonLH getInstance() {
        if (instance == null) {
            synchronized (singleTonLH.class) {

            }
            if (instance == null) {
                instance = new singleTonLH();
            }

        }
        return instance;

    }

}