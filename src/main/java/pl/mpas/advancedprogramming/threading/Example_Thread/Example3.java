package pl.mpas.advancedprogramming.threading.Example_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example3 {

    public static void main(String[] args) {
        int[] arrayToSum = {1, 2, 3, 4, 5, 6};

        int[] arrayToSum2 = new int[100_000];
        for (int i = 0; i < arrayToSum2.length; i++) {
            arrayToSum2[i] = arrayToSum2.length - i;
        }

        System.out.println(sumArray(arrayToSum));
        System.out.println(sumArray(arrayToSum2));
    }

    public static long sumArray(int[] array) {
        // liczy sumę tablicy na dwóch wątkach
        // sumuje dwa rezultaty i zwraca użytkownikowi
        List<Long> partResult = new ArrayList<>();

        ExecutorService remoteWorkers = Executors.newFixedThreadPool(2);
        remoteWorkers.execute(() -> { partSum(array, 0, array.length / 2, partResult);});
        remoteWorkers.execute(() -> { partSum(array, array.length / 2, array.length , partResult);});
        remoteWorkers.shutdown();

        boolean done = false;
        do {
            try {
                done = remoteWorkers.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!done);

//
//        partResult.stream()
//                .mapToLong(value -> value)
//                .sum();

        return partResult.stream()
                .reduce((aLong, aLong2) -> aLong + aLong2).orElse(0L);
    }

    public static void partSum(int[] arrayToSum, int sinceInc,
                               int toExc, List<Long> placeForResult) {
        long result = 0;

        for (int i = sinceInc; i < toExc; i++) {
            result += arrayToSum[i];
        }

        synchronized (placeForResult) {
            placeForResult.add(result);
        }
    }
}
