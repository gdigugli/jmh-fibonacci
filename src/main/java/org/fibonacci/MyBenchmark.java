package org.fibonacci;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {
    static int VALUE = 10;

    @Benchmark
    public void arrayFib() {
        arrayFib(VALUE);
    }

    @Benchmark
    public void slowFibMemoized() {
        slowFibMemoized(VALUE, new MapMap(VALUE));
    }

    @Benchmark
    public void fastFibMemoized() {
        fastFibMemoized(VALUE, new MapMap(VALUE));
    }

    private static long arrayFib(int n) {
        return arrayFib(n, new long[n + 1]);
    }

    private static long arrayFib(int n, long[] memo) {
        if (n < 3)
            return n;
        if (memo[n] != 0)
            return memo[n];
        final long fibn = arrayFib(n - 1, memo) + arrayFib(n - 2, memo);
        memo[n] = fibn;
        return fibn;
    }

    private static long slowFibMemoized(int n, MapMap memo) {
        if (n < 3)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);
        return memo.put(n, slowFibMemoized(n - 1, memo) + slowFibMemoized(n - 2, memo));
    }

    private static long fastFibMemoized(int n, MapMap memo) {
        if (n < 3)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);
        return memo.put(n, fastFibMemoized(n - 1, memo) + slowFibMemoized(n - 2, memo));
    }

    private static final Long[][] Q = new Long[][]{{1L, 1L}, {1L, 0L}};
    public static final int BINET_RANK_LIMIT = 50;

    private static Long[][] multiplyMatrices(Long[][] leftMatrix, Long[][] rightMatrix) {
        return new Long[][]{{
                leftMatrix[0][0] * rightMatrix[0][0] + leftMatrix[0][1] * rightMatrix[1][0],
                leftMatrix[0][0] * rightMatrix[0][1] + leftMatrix[0][1] * rightMatrix[1][1]}, {
                leftMatrix[1][0] * rightMatrix[0][0] + leftMatrix[1][1] * rightMatrix[1][0],
                leftMatrix[1][0] * rightMatrix[0][1] + leftMatrix[1][1] * rightMatrix[1][1]}};
    }

    private static Long[][] fastExponentiation(Long[][] matrix, int power) {
        if (power == 1) return matrix;
        if (power % 2 == 0) {
            var temp = fastExponentiation(matrix, power / 2);
            return multiplyMatrices(temp, temp);
        } else {
            var temp = fastExponentiation(matrix, power - 1);
            return multiplyMatrices(Q, temp);
        }
    }

    private static long binetFormula(int rank) {
        var phi = (1 + Math.sqrt(5)) / 2.;
        return Math.round(Math.pow(phi, rank + 1) / Math.sqrt(5));
    }

    @Benchmark
    public static long fastestFibonacci() {
        return VALUE < BINET_RANK_LIMIT ? binetFormula(VALUE) : fastExponentiation(Q, VALUE)[0][0];
    }

    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
                           .include(MyBenchmark.class.getSimpleName())
                           .forks(1)
                           .build())
                .run();
    }

    record MapMap(long[] values) {

        MapMap(int size) {
            this(new long[size + 1]);
        }

        boolean containsKey(int n) {
            return values[n] != 0;
        }

        long get(int n) {
            return values[n];
        }

        long put(int n, long l) {
            values[n] = l;
            return l;
        }
    }
}
