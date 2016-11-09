/**
 * Created by iagobelo on 08/11/2016.
 */
public interface IPrint {
    //void printAlocationStatus(int processId, int[] resources);

    void resourcesStatus(int[] totalResources, int[] allocatedResources, int[] freeResources);

    void resourcesRequisitation(int threadId, int[] necessaryResources);
}
