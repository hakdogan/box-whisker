#!/bin/bash

main_directory=$(pwd)

cd src/main/java

echo $(pwd)
javac -d $main_directory/out \
$(find . -name "*.java")

cd $main_directory/out

jar -cmf $main_directory/manifest.txt box-whisker.jar .