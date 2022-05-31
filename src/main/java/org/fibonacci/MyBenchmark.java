/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

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

	static class MapMap {
		private final long[] values;

		public MapMap(int size) {
			values = new long[size + 1];
		}

		public boolean containsKey(int n) {
			return values[n] != 0;
		}

		public long get(int n) {
			return values[n];
		}

		public long put(int n, long l) {
			values[n] = l;
			return l;
		}
	}
}
