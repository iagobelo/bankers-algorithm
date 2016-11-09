/**
 * Created by iagobelo on 08/11/2016.
 */
public class Main {
    private static final int i = 1;
    private static final int[] totalResources = new int[]{6, 4, 9, 5};
    private static Process[] processes;
    private static Banker banker;
    private static int[] freeResources = totalResources;

    public static void main(String[] args) {
        banker = new Banker();
        processes = new Process[5];

        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(i, banker);
            processes[i].start();
        }

        //freeResources[1] = totalResources[1] - 3;
        //System.out.println(freeResources[1]);
        //System.out.println(totalResources[1]);
    }
}
