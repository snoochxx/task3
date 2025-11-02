public class Main {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен");

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new MyTask(i + 1));
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван");
            }
        }
        System.out.println("Главный поток завершен");
    }
}

class MyTask implements Runnable {
    private final int id;
    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Поток " + id + " запущен");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Поток " + id + " прерван");
        }
        System.out.println("Поток " + id + " завершен");
    }
}
