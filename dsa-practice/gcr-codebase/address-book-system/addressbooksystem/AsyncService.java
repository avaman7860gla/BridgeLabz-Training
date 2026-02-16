import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// UC17: Multithread 
public class AsyncService{
    ExecutorService ex= Executors.newFixedThreadPool(3);

    public void save(AddressBook b){
        ex.submit(()->FileIOService.write(b,"async.txt"));
        ex.submit(()->CSVService.write(b,"async.csv"));
        ex.submit(()->JSONService.write(b,"async.json"));
    }

    public void shutdown(){
        ex.shutdown();
    }
}