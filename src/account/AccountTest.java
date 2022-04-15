package account;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/20:42
 * Description:
 */
public class AccountTest {

    public static void main(String[] args) {
        Account a = new Account();
        Customer c1 = new Customer(a);
        Customer c2 = new Customer(a);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }


}

class Account {

    private static int balance;
    ReentrantLock lock = new ReentrantLock();

    public void deposite(int moneyNum) {
        try {

            if (moneyNum > 0) {
                lock.lock();
                balance += moneyNum;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为" + balance);
            }
        } finally {
            lock.unlock();
        }

    }
}

class Customer extends Thread {
    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            account.deposite(1000);
        }
    }
}