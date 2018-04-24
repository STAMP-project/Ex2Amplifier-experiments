#!/usr/bin/env bash

git clone https://github.com/STAMP-project/dspot
cd dspot/dspot
mvn clean install -DskipTests
cd ../..

git clone https://github.com/STAMP-project/Ex2Amplifier
cd Ex2Amplifier
mvn clean install -DskipTests

cd ..