import java.util.Random;

class FileDownloaderThread extends Thread {
    private String fileName;
    private Random random = new Random();

    // constructor
    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    // override run method
    @Override
    public void run() {
        for (int i = 0; i <= 100; i += 25) {
            System.out.println(Thread.currentThread().getName()+" Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(500 + random.nextInt(500));
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DownloadManagerThread {
    public static void main(String[] args) throws InterruptedException {
        FileDownloaderThread d1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread d2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread d3 = new FileDownloaderThread("Video.mp4");
        d1.start();
        d2.start();
        d3.start();

        d1.join();
        d2.join();
        d3.join();
        System.out.println("All downloads completed");
    }
}
