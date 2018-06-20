/**
 * 利用多核CPU计算很大LIST中所有整数的和
 * 把一个大任务分割成若干个小任务进行窃取执行
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinLargeListSum {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = IntStream.rangeClosed(0, 10000000).toArray();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountSumTask task = new CountSumTask(0, array.length, 10000, array);
        Future<Integer> future = forkJoinPool.submit(task);
        System.out.println("计算结果为："+future.get());
        forkJoinPool.shutdown();
    }

    static class CountSumTask extends RecursiveTask<Integer> {
        private int high, low;
        private int threshold;
        private int[] array;

        CountSumTask(int low, int high, int threshold, int[] array) {
            this.array = array;
            this.low = low;
            this.high = high;
            this.threshold = threshold;
        }

        @Override
        protected Integer compute() {
            if (high - low <= threshold) {
                int sum = 0;
                for (int i = low; i < high; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int middle = (high - low) / 2 + low;
                CountSumTask leftHandTask = new CountSumTask(low, middle, threshold, array);
                CountSumTask rightHandTask = new CountSumTask(middle, high, threshold, array);
                leftHandTask.fork();
                rightHandTask.fork();
                return leftHandTask.join() + rightHandTask.join();
            }
        }
    }
}
