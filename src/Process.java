/**
 * Created by iagobelo on 08/11/2016.
 */
public class Process extends Thread {
    private int id;
    private Banker banker;
    private int[] necessaryResources;

    public Process(int id, Banker banker) {
        this.id = id;
        this.banker = banker;
    }

    @Override
    public synchronized void start() {
        try {
            necessaryResources = createNecessaryResources();
            banker.getResources(id, necessaryResources);
            process();
        } finally {
            banker.returnResources(id, necessaryResources);
        }
    }

    private void process() {
        System.out.println("Thread #" + id + " processando.");
        try {
            sleep(1000 * (int) (Math.random() * 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread #" + id + " terminou de processar.");
    }

    private int[] createNecessaryResources() {
        return new int[]{
                (int) (Math.random() * 8),
                (int) (Math.random() * 8),
                (int) (Math.random() * 8),
                (int) (Math.random() * 8)
        };
    }
}
