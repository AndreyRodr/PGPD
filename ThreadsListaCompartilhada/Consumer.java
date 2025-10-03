public record Consumer(SharedList sharedList) implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sharedList.consume();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
