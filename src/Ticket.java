import java.util.concurrent.locks.ReentrantLock;
//多线程实现卖票程序，可分别用synchronized和ReentrantLock实现，test
public class Ticket implements Runnable{
    private int num=100;
    private ReentrantLock lock=new ReentrantLock();
    public void run(){
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
//            synchronized (this){
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ".....sale....." + num--);
                }
//            }
            lock.unlock();
            if(num==0)
                break;
        }
    }
    public static void main(String args[]){
        Ticket t=new Ticket();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);
        Thread t4=new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
