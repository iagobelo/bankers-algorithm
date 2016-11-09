/**
 * Created by iagobelo on 08/11/2016.
 */
public class Main {
    private static Process[] processes;
    private static Banker banker;

    public static void main(String[] args) {
        banker = new Banker();
        processes = new Process[5];

        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(i, banker);
            processes[i].start();
        }
    }
}
