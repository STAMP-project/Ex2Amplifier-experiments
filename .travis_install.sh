#!/usr/bin/env bash

git clone https://github.com/STAMP-project/dspot
cd dspot
mvn clean install -DskipTests
cd ..

git clone http://github.com/danglotb/jbse -b pre-java8
cd jbse
mvn install -DskipTests

git clone https://github.com/STAMP-project/Ex2Amplifier
cd Ex2Amplifier
mvn clean install -DskipTests

cd ..

wget http://cvc4.cs.stanford.edu/downloads/builds/x86_64-linux-opt/cvc4-1.4-x86_64-linux-opt
{ echo "catg.cvc4Command=" ; echo $(pwd); echo "/" ; echo $(ls | grep cvc4); } | sed ':a;N;s/\n//;ba' >> lib/catg.conf
chmod +x cvc4-1.4-x86_64-linux-opt