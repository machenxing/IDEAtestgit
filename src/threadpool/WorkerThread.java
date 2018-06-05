package threadpool;

public class WorkerThread implements Runnable{
    private String command;
    public WorkerThread(String s){
        this.command=s;
    }
    private void processCommand(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start.  Command="+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+"End. ");
    }

    @Override
    public String toString() {
        return this.command;
    }
}
