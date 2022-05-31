gdu@mbp13 jmh-fibonacci % java -jar target/jmh-fibonacci.jar
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

# Run progress: 0.00% complete, ETA 00:01:42
# Fork: 1 of 1
# Warmup Iteration   1: 21.027 ns/op
# Warmup Iteration   2: 20.580 ns/op
# Warmup Iteration   3: 20.561 ns/op
Iteration   1: 20.647 ns/op
Iteration   2: 20.677 ns/op
Iteration   3: 20.730 ns/op
Iteration   4: 20.777 ns/op
Iteration   5: 20.779 ns/op


Result "org.fibonacci.MyBenchmark.arrayFib":
  20.722 ±(99.9%) 0.228 ns/op [Average]
  (min, avg, max) = (20.647, 20.722, 20.779), stdev = 0.059
  CI (99.9%): [20.494, 20.950] (assumes normal distribution)


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

# Run progress: 33.33% complete, ETA 00:01:08
# Fork: 1 of 1
# Warmup Iteration   1: 88.093 ns/op
# Warmup Iteration   2: 85.778 ns/op
# Warmup Iteration   3: 86.362 ns/op
Iteration   1: 86.245 ns/op
Iteration   2: 86.042 ns/op
Iteration   3: 86.034 ns/op
Iteration   4: 87.821 ns/op
Iteration   5: 98.738 ns/op


Result "org.fibonacci.MyBenchmark.fastFibMemoized":
  88.976 ±(99.9%) 21.210 ns/op [Average]
  (min, avg, max) = (86.034, 88.976, 98.738), stdev = 5.508
  CI (99.9%): [67.766, 110.186] (assumes normal distribution)


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

# Run progress: 66.67% complete, ETA 00:00:34
# Fork: 1 of 1
# Warmup Iteration   1: 92.728 ns/op
# Warmup Iteration   2: 86.377 ns/op
# Warmup Iteration   3: 86.412 ns/op
Iteration   1: 86.464 ns/op
Iteration   2: 88.943 ns/op
Iteration   3: 86.618 ns/op
Iteration   4: 86.732 ns/op
Iteration   5: 86.392 ns/op


Result "org.fibonacci.MyBenchmark.slowFibMemoized":
  87.030 ±(99.9%) 4.150 ns/op [Average]
  (min, avg, max) = (86.392, 87.030, 88.943), stdev = 1.078
  CI (99.9%): [82.880, 91.180] (assumes normal distribution)


# Run complete. Total time: 00:01:42

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

Benchmark                    Mode  Cnt   Score    Error  Units
MyBenchmark.arrayFib         avgt    5  20.722 ±  0.228  ns/op
MyBenchmark.fastFibMemoized  avgt    5  88.976 ± 21.210  ns/op
MyBenchmark.slowFibMemoized  avgt    5  87.030 ±  4.150  ns/op