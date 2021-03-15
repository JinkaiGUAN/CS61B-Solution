import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        ArrayList<Integer> sizeList = new ArrayList<>(); // N_list
        ArrayList<Double> totalTimeList = new ArrayList<>();
        sizeList.add(1000);
        int size = 8;
        for (int i = 1; i < size; i ++) {
            sizeList.add(sizeList.get(i-1) * 2);
        }

        for (int i = 0; i < size; i ++) {
            int sizeIndex = sizeList.get(i);
            // Do the addLast() with sizeIndex times
            Stopwatch sw = new Stopwatch();
            AList<Integer> storeList = new AList<>();
            for (int j = 0; j < sizeIndex; j++) {
                storeList.addLast(j);
            }
            double totalTime = sw.elapsedTime();
            totalTimeList.add(totalTime);
        }
        printTimingTable(sizeList, totalTimeList, sizeList);
    }


}
