public class BackgroundJob {
    public static void main(String[] args) {

        // Runnable task
        Runnable job = () -> {
            System.out.println("Background job started");
            // try catch block
            try {
                // Simulating work
                Thread.sleep(2000); 
            } 
            catch (InterruptedException e) {
                System.out.println("Job interrupted");
            }
            System.out.println("Background job completed");
        };

        // Running task in separate thread
        Thread thread = new Thread(job);
        thread.start();

        System.out.println("Main thread continues execution");
    }
}
