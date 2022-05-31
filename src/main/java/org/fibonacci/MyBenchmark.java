package org.fibonacci;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class MyBenchmark {
	static int VALUE = 10;

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
	@Fork(1)
	public void arrayFib() {
		arrayFib(VALUE);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
	@Fork(1)
	public void slowFibMemoized() {
		slowFibMemoized(VALUE, new MapMap(VALUE));
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
	@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
	@Fork(1)
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

	public static void main(String[] args) {
		long start = System.nanoTime();
		arrayFib(VALUE);
		System.out.println("array: " + (System.nanoTime() - start) + " ns");
		start = System.nanoTime();
		slowFibMemoized(VALUE, new MapMap(VALUE));
		System.out.println("slow: " + (System.nanoTime() - start) + " ns");
		start = System.nanoTime();
		fastFibMemoized(VALUE, new MapMap(VALUE));
		System.out.println("fast: " + (System.nanoTime() - start) + " ns");
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
