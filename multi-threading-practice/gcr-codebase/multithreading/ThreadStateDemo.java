import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

class TaskRunner extends Thread {
    // constructor
    public TaskRunner(String name) {
        super(name);
    }

    // override run method
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 1000000; i++) { }
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StateMonitor extends Thread {
    private TaskRunner[] tasks;
    private Set<Thread.State> states = new HashSet<>();

    // constructor
    public StateMonitor(TaskRunner[] tasks) {
        this.tasks = tasks;
    }

    // override run method
    @Override
    public void run() {
        boolean running = true;

        while (running) {
            running = false;
            for (TaskRunner t : tasks) {
                Thread.State state = t.getState();
                states.add(state);
                System.out.println(t.getName() +" is in " + state +" state at " + LocalTime.now());
                if (state != Thread.State.TERMINATED) {
                    running = true;
                }
            }

            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Observed " + states.size() + " states");
    }
}

public class ThreadStateDemo {
    public static void main(String[] args) {
        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");
        StateMonitor monitor = new StateMonitor(new TaskRunner[]{t1, t2});
        monitor.start();
        t1.start();
        t2.start();
    }
}
