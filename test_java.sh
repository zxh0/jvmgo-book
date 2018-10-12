#!/bin/sh
set -ex

cd v1/code/java/jvmgo_java

# export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/
sh gradlew ch01:run --args ' -version' | grep -q "1.8.0"
sh gradlew ch02:run --args ' java.lang.Object' | grep -q "class data"
sh gradlew ch03:run --args ' java.lang.Object' | grep -q "this class: java/lang/Object"
# sh gradlew ch04:run --args ' java.lang.Object' 2>&1 | grep -q "100"
# sh gradlew ch05:run --args ' -cp ../java/example.jar jvmgo.book.ch05.GaussTest' 2>&1 | grep -q "5050"
# sh gradlew ch06:run --args ' -cp ../java/example.jar jvmgo.book.ch06.MyObject' | grep -q "32768"
# sh gradlew ch07:run --args ' -cp ../java/example.jar jvmgo.book.ch07.FibonacciTest' | grep -q "832040"
# sh gradlew ch08:run --args ' -cp ../java/example.jar jvmgo.book.ch01.HelloWorld' | grep -q "Hello, world!"
# sh gradlew ch08:run --args ' -cp ../java/example.jar jvmgo.book.ch08.PrintArgs foo bar' | tr -d '\n' | grep -q "foobar"
# sh gradlew ch09:run --args ' -cp ../java/example.jar jvmgo.book.ch09.GetClassTest' | grep -q "Ljava.lang.String;"
# sh gradlew ch09:run --args ' -cp ../java/example.jar jvmgo.book.ch09.StringTest' | tr -d '\n' | grep -q "truefalsetrue"
# sh gradlew ch09:run --args ' -cp ../java/example.jar jvmgo.book.ch09.ObjectTest' | tr -d '\n' | grep -q "falsetrue"
# sh gradlew ch09:run --args ' -cp ../java/example.jar jvmgo.book.ch09.CloneTest' | grep -q "3.14"
# sh gradlew ch09:run --args ' -cp ../java/example.jar jvmgo.book.ch09.BoxTest' | grep -q "1, 2, 3"
# sh gradlew ch10:run --args ' -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest 123' | grep -q "123"
# sh gradlew ch10:run --args ' -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest abc' 2>&1 | grep  'For input string: "abc"'
# sh gradlew ch10:run --args ' -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest' 2>&1 | grep -q "at jvmgo"
# sh gradlew ch11:run --args ' -cp ../java/example.jar jvmgo.book.ch01.HelloWorld' | grep -q "Hello, world!"

echo OK