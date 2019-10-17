package java8inaction.part3;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    //要操作一个数组, 由于不能多线程竞争, 因此引入数组的开始与结束的变量, 以合理拆分数组给各个线程
    private final long[] numbers;
    private final int start;
    private final int end;

    //不拆分的最小值
    public static final long THRESHOLD = 10_000;

    //私有构造器, 由于仅仅是在内部创建线程, 因此不暴露给外界
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    //工具方法, 用于汇总numbers数组指定的区域
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];

        }
        return sum;
    }

    //核心的compute方法, 将当前的任务分解为两个任务, 分解方法是分解索引, 然后将分解后的索引和同一个数组对象分成两个任务
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        //左半边任务
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length / 2);
        //左半边任务交给新的线程
        leftTask.fork();
        //右半边任务, 直接在当前线程内启动
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        //等待左半边任务的结束, 然后合并结果
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers, 0, numbers.length);
        //使用多个新建的ForkJoinPool是没有什么意义的, 只要复用同一个即可
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        long result = forkJoinSum(999);
        System.out.println(result);
    }
}
