#!/bin/sh
set -ex

cd v1/code/go
export GOPATH=$PWD

# export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/
go run jvmgo/ch01 -version | grep -q "version 0.0.1"
go run jvmgo/ch02 java.lang.Object | grep -q "class data"
go run jvmgo/ch03 java.lang.Object | grep -q "this class: java/lang/Object"
go run jvmgo/ch04 java.lang.Object 2>&1 | grep -q "100"
go run jvmgo/ch05 -cp ../java/example.jar jvmgo.book.ch05.GaussTest 2>&1 | grep -q "5050"
go run jvmgo/ch06 -cp ../java/example.jar jvmgo.book.ch06.MyObject | grep -q "32768"
go run jvmgo/ch07 -cp ../java/example.jar jvmgo.book.ch07.FibonacciTest | grep -q "832040"
go run jvmgo/ch08 -cp ../java/example.jar jvmgo.book.ch01.HelloWorld  | grep -q "Hello, world!"
go run jvmgo/ch08 -cp ../java/example.jar jvmgo.book.ch08.PrintArgs foo bar | tr -d '\n' | grep -q "foobar"
go run jvmgo/ch09 -cp ../java/example.jar jvmgo.book.ch09.GetClassTest | grep -q "Ljava.lang.String;"
go run jvmgo/ch09 -cp ../java/example.jar jvmgo.book.ch09.StringTest | tr -d '\n' | grep -q "truefalsetrue"
go run jvmgo/ch09 -cp ../java/example.jar jvmgo.book.ch09.ObjectTest | tr -d '\n' | grep -q "falsetrue"
go run jvmgo/ch09 -cp ../java/example.jar jvmgo.book.ch09.CloneTest | grep -q "3.14"
go run jvmgo/ch09 -cp ../java/example.jar jvmgo.book.ch09.BoxTest | grep -q "1, 2, 3"
go run jvmgo/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest 123 | grep -q "123"
go run jvmgo/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest abc 2>&1 | grep  'For input string: "abc"'
go run jvmgo/ch10 -cp ../java/example.jar jvmgo.book.ch10.ParseIntTest 2>&1 | grep -q "at jvmgo"
go run jvmgo/ch11 -cp ../java/example.jar jvmgo.book.ch01.HelloWorld  | grep -q "Hello, world!"

echo OK