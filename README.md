gdu@mbp13 jmh-fibonacci % java -jar target/jmh-fibonacci.jar

```
# JMH version: 1.35
# VM version: JDK 17.0.3, OpenJDK 64-Bit Server VM, 17.0.3+7
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 3 s each
# Measurement: 5 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.fibonacci.MyBenchmark.arrayFib

# Run progress: 0.00% complete, ETA 00:02:50
# Fork: 1 of 1
# Warmup Iteration   1: 19.373 ns/op
# Warmup Iteration   2: 19.020 ns/op
# Warmup Iteration   3: 19.031 ns/op
Iteration   1: 19.018 ns/op
Iteration   2: 19.068 ns/op
Iteration   3: 19.083 ns/op
Iteration   4: 19.092 ns/op
Iteration   5: 19.109 ns/op


Result "org.fibonacci.MyBenchmark.arrayFib":
  19.074 ±(99.9%) 0.134 ns/op [Average]
  (min, avg, max) = (19.018, 19.074, 19.109), stdev = 0.035
  CI (99.9%): [18.940, 19.208] (assumes normal distribution)


# JMH version: 1.35
# VM version: JDK 17.0.3, OpenJDK 64-Bit Server VM, 17.0.3+7
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 3 s each
# Measurement: 5 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.fibonacci.MyBenchmark.fastArrayFib

# Run progress: 20.00% complete, ETA 00:02:16
# Fork: 1 of 1
# Warmup Iteration   1: 12.721 ns/op
# Warmup Iteration   2: 12.360 ns/op
# Warmup Iteration   3: 12.397 ns/op
Iteration   1: 12.381 ns/op
Iteration   2: 12.397 ns/op
Iteration   3: 12.404 ns/op
Iteration   4: 12.410 ns/op
Iteration   5: 12.849 ns/op


Result "org.fibonacci.MyBenchmark.fastArrayFib":
  12.488 ±(99.9%) 0.778 ns/op [Average]
  (min, avg, max) = (12.381, 12.488, 12.849), stdev = 0.202
  CI (99.9%): [11.710, 13.266] (assumes normal distribution)


# JMH version: 1.35
# VM version: JDK 17.0.3, OpenJDK 64-Bit Server VM, 17.0.3+7
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 3 s each
# Measurement: 5 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.fibonacci.MyBenchmark.fastFib

# Run progress: 40.00% complete, ETA 00:01:42
# Fork: 1 of 1
# Warmup Iteration   1: 0.721 ns/op
# Warmup Iteration   2: 0.725 ns/op
# Warmup Iteration   3: 0.743 ns/op
Iteration   1: 0.754 ns/op
Iteration   2: 0.758 ns/op
Iteration   3: 0.749 ns/op
Iteration   4: 0.720 ns/op
Iteration   5: 0.719 ns/op


Result "org.fibonacci.MyBenchmark.fastFib":
  0.740 ±(99.9%) 0.074 ns/op [Average]
  (min, avg, max) = (0.719, 0.740, 0.758), stdev = 0.019
  CI (99.9%): [0.666, 0.814] (assumes normal distribution)


# JMH version: 1.35
# VM version: JDK 17.0.3, OpenJDK 64-Bit Server VM, 17.0.3+7
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 3 s each
# Measurement: 5 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.fibonacci.MyBenchmark.fastFibMemoized

# Run progress: 60.00% complete, ETA 00:01:08
# Fork: 1 of 1
# Warmup Iteration   1: 23.268 ns/op
# Warmup Iteration   2: 23.127 ns/op
# Warmup Iteration   3: 22.658 ns/op
Iteration   1: 22.382 ns/op
Iteration   2: 22.546 ns/op
Iteration   3: 22.951 ns/op
Iteration   4: 22.713 ns/op
Iteration   5: 23.192 ns/op


Result "org.fibonacci.MyBenchmark.fastFibMemoized":
  22.757 ±(99.9%) 1.239 ns/op [Average]
  (min, avg, max) = (22.382, 22.757, 23.192), stdev = 0.322
  CI (99.9%): [21.518, 23.995] (assumes normal distribution)


# JMH version: 1.35
# VM version: JDK 17.0.3, OpenJDK 64-Bit Server VM, 17.0.3+7
# VM invoker: /Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home/bin/java
# VM options: <none>
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 3 iterations, 3 s each
# Measurement: 5 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.fibonacci.MyBenchmark.slowFibMemoized

# Run progress: 80.00% complete, ETA 00:00:34
# Fork: 1 of 1
# Warmup Iteration   1: 23.516 ns/op
# Warmup Iteration   2: 22.958 ns/op
# Warmup Iteration   3: 22.518 ns/op
Iteration   1: 22.431 ns/op
Iteration   2: 22.353 ns/op
Iteration   3: 22.271 ns/op
Iteration   4: 22.510 ns/op
Iteration   5: 22.332 ns/op


Result "org.fibonacci.MyBenchmark.slowFibMemoized":
  22.379 ±(99.9%) 0.357 ns/op [Average]
  (min, avg, max) = (22.271, 22.379, 22.510), stdev = 0.093
  CI (99.9%): [22.022, 22.737] (assumes normal distribution)


# Run complete. Total time: 00:02:51

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark                    Mode  Cnt   Score   Error  Units
MyBenchmark.arrayFib         avgt    5  19.074 ± 0.134  ns/op
MyBenchmark.fastArrayFib     avgt    5  12.488 ± 0.778  ns/op
MyBenchmark.fastFib          avgt    5   0.740 ± 0.074  ns/op
MyBenchmark.fastFibMemoized  avgt    5  22.757 ± 1.239  ns/op
MyBenchmark.slowFibMemoized  avgt    5  22.379 ± 0.357  ns/op

```
