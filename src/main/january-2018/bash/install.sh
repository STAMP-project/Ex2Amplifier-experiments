#!/usr/bin/env bash

git clone https://github.com/STAMP-project/dspot.git
cd dspot
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..

git clone https://github.com/STAMP-project/Ex2Amplifier.git
cd Ex2Amplifier
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..

wget http://cvc4.cs.stanford.edu/downloads/builds/x86_64-linux-opt/cvc4-1.4-x86_64-linux-opt
{ echo "catg.cvc4Command=" ; echo $(pwd); echo "/" ; echo $(ls | grep cvc4); } | sed ':a;N;s/\n//;ba' >> lib/catg.conf
chmod +x cvc4-1.4-x86_64-linux-opt