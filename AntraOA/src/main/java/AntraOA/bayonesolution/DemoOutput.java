package AntraOA.bayonesolution;

public class DemoOutput {
    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        threadDemo.start();

        for(int i=0;i<10;i++){
            System.out.println("Value of i is : "+i);
        }
    }
}

class ThreadDemo extends Thread{
    @Override
    public synchronized void start() {
        System.out.println("Inside the start method!!!");
    }

    @Override
    public void run() {
        System.out.println("Inside the run method!!!");
    }
}
