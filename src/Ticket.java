/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/12:43
 * Description:
 */
public class Ticket  extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + "卖出票" + ticket--);
//                }
//            }
            show();
        }
    }

    private  void show() {
        synchronized (Ticket.class) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出票" + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}
