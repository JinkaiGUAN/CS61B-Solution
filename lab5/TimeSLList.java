import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        ArrayList<Integer> sizeList = new ArrayList<>();
        ArrayList<Double> totalTimeList = new ArrayList<>();
        ArrayList<Integer> opList = new ArrayList<>();
        sizeList.add(1000);
        opList.add(10000);
        int size = 8;
        for (int i = 1; i < size; i++) {
            sizeList.add(sizeList.get(i-1)*2);
            opList.add(10000);
        }
        for (int i = 0; i < size; i ++) {
            SLList<Integer> slList = new SLList<>();
            for (int j = 0; j < sizeList.get(i); j ++) {
                slList.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            for (int m = 0; m < opList.get(i); m ++){
                slList.getLast();
            }
            double totalTime = sw.elapsedTime();
            totalTimeList.add(totalTime);
        }
        printTimingTable(sizeList, totalTimeList, opList);
    }

}
