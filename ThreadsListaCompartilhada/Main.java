public class Main {
    public static void main(String[] args) {
        SharedList sharedList = new SharedList();

        Thread t1 = new Thread(new Producer(sharedList), "T1");
        Thread t2 = new Thread(new Consumer(sharedList), "T2");

        t1.start();
        t2.start();
    }
}