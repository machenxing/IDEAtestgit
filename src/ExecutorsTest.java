import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
    public static void main(String[] args) {
        // ����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        // ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        // ���̷߳�����н���ִ��
        pool.execute(t1);
        // ʹ���ӳ�ִ�з��ķ���
        pool.schedule(t2, 1000, TimeUnit.MILLISECONDS);
        pool.schedule(t3, 10, TimeUnit.MILLISECONDS);
        pool.schedule(t4, 500, TimeUnit.MILLISECONDS);
        pool.schedule(t5, 1500, TimeUnit.MILLISECONDS);

        // �ر��̳߳�
        pool.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
    }
}
