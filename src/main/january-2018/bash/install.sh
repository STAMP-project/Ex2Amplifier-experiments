#!/usr/bin/env bash

git clone https://github.com/STAMP-project/dspot.git
cd dspot
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..

git clone https://github.com/STAMP-project/Ex2Amplifier.git
cd Ex2Amplifier
~/apache-maven-3.3.9/bin/mvn install -DskipTests
cd ..