#!/bin/sh
set -ex

cd v1/code/go
export GOPATH=$PWD
go install jvmgo/ch01
go install jvmgo/ch02
go install jvmgo/ch03
go install jvmgo/ch04
go install jvmgo/ch05
go install jvmgo/ch06
go install jvmgo/ch07
go install jvmgo/ch08
go install jvmgo/ch09
go install jvmgo/ch10
go install jvmgo/ch11

# export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/
./bin/ch02 java.lang.Object | grep -q "class data"
./bin/ch03 java.lang.Object | grep -q "this class: java/lang/Object"
./bin/ch04 java.lang.Object 2>&1 | grep -q "100"
./bin/ch05 -cp ../java/example.jar jvmgo.book.ch05.GaussTest 2>&1 | grep -q "5050"
./bin/ch06 -cp ../java/example.jar jvmgo.book.ch06.MyObject | grep -q "32768"
./bin/ch07 -cp ../java/example.jar jvmgo.book.ch07.FibonacciTest | grep -q "832040"
./bin/ch08 -cp ../java/example.jar jvmgo.book.ch01.HelloWorld  | grep -q "Hello, world!"
./bin/ch08 -cp ../java/example.jar jvmgo.book.ch08.PrintArgs foo bar | tr -d '\n' | grep -q "foobar"
./bin/ch09 -cp ../java/example.jar jvmgo.book.ch09.GetClassTest | grep -q "Ljava.lang.String;"
./bin/ch09 -cp ../java/example.jar jvmgo.book.ch09.StringTest | tr -d '\n' | grep -q "truefalsetrue"
./bin/ch09 -cp ../java/example.jar jvmgo.book.ch09.ObjectTest | tr -d '\n' | grep -q "falsetrue"
./bin/ch09 -cp ../java/example.jar jvmgo.book.ch09.CloneTest | grep -q "3.14"
./bin/ch09 -cp ../java/example.jar jvmgo.book.ch09.BoxTest | grep -q "1, 2, 3"
./bin/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest 123 | grep -q "123"
./bin/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest abc 2>&1 | grep  'For input string: "abc"'
./bin/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest 2>&1 | grep -q "at jvmgo"
./bin/ch11 -cp ../java/example.jar jvmgo.book.ch01.HelloWorld  | grep -q "Hello, world!"

echo OK