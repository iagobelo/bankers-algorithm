/**
 * Created by iagobelo on 08/11/2016.
 */
public class Banker {

    // Constantes
    private final int A = 0,
            B = 1,
            C = 2,
            D = 3;
    private final int[] totalResources = new int[]{8, 8, 8, 8};

    private int[] freeResources = new int[]{8, 8, 8, 8};

    public Banker() {

    }

    public synchronized void getResources(int threadId, int[] necessaryResources) {
        printStatus();
        printRequest(threadId, necessaryResources);

        if (necessaryResources[A] <= freeResources[A]
                && necessaryResources[B] <= freeResources[B]
                && necessaryResources[C] <= freeResources[C]
                && necessaryResources[D] <= freeResources[D]) {

            printRequest(true, threadId);

            for (int i = 0; i < freeResources.length; i++) {
                freeResources[i] -= necessaryResources[i];
            }
            printStatus();
        } else {
            try {
                printRequest(false, threadId);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void returnResources(int threadId, int[] resources) {
        printResourcesReturn(threadId);

        for (int i = 0; i < resources.length; i++) {
            freeResources[i] += resources[i];
        }
        notify();
    }

    private int[] getAllocatedResources() {
        int[] allocatedResources = new int[4];

        for (int i = 0; i < allocatedResources.length; i++) {
            allocatedResources[i] = totalResources[i] - freeResources[i];
        }
        return allocatedResources;
    }

    private void printStatus() {
        int[] allocated = getAllocatedResources();

        System.out.println("Status dos recursos: \n" +
                "         A B C D\n" +
                "Total:   " + totalResources[A] + " " + totalResources[B] + " " + totalResources[C] + " " + totalResources[D] + "\n" +
                "Alocado: " + allocated[A] + " " + allocated[B] + " " + allocated[C] + " " + allocated[D] + "\n" +
                "Livre:   " + freeResources[A] + " " + freeResources[B] + " " + freeResources[C] + " " + freeResources[D] +
                "\n"
        );
    }

    private void printRequest(int threadId, int[] resources) {
        System.out.println("Thread #: " + threadId + "\n" +
                "Solicitando: " + "A B C D\n" +
                "             " + resources[A] + " " + resources[B] + " " + resources[C] + " " + resources[D] +
                "\n"
        );
    }

    private void printRequest(boolean request, int threadId) {
        System.out.println("Solicitação: " + (request ? "aceita." : "negada. Thread #" + threadId + " em espera.") + "\n");
    }

    private void printResourcesReturn(int threadId) {
        System.out.println("Thread #" + threadId + " retornou os recursos!" + "\n");
    }
}
