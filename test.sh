#!/bin/sh
set -ex

cd v1/code/go
export GOPATH=$PWD
# export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/

go install jvmgo/ch01

go install jvmgo/ch02
./bin/ch02 java.lang.Object | grep -q "class data"