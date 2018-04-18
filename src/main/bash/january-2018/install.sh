#!/usr/bin/env bash

# this script is used on Clusty, the cluster of Inria.
# this is why we have ~/apache-maven-3.3.9/bin/mvn to reach maven

# cloning DSpot
git clone https://github.com/STAMP-project/dspot.git
cd dspot
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..


# cloning Ex2Amplifier
git clone https://github.com/STAMP-project/Ex2Amplifier.git
cd Ex2Amplifier
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..

# getting cvc4
wget http://cvc4.cs.stanford.edu/downloads/builds/x86_64-linux-opt/cvc4-1.4-x86_64-linux-opt
{ echo "catg.cvc4Command=" ; echo $(pwd); echo "/" ; echo $(ls | grep cvc4); } | sed ':a;N;s/\n//;ba' >> lib/catg.conf
chmod +x cvc4-1.4-x86_64-linux-opt

# building experiments project
~/apache-maven-3.3.9/bin/mvn install -DskipTests