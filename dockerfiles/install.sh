#!/usr/bin/env bash

# clone and launch the install script of Ex2Amplifier-experiments

cd /root/
git clone https://github.com/STAMP-project/Ex2Amplifier-experiments.git -b scam-18-branch
cd Ex2Amplifier-experiments

# cloning DSpot
git clone https://github.com/danglotb/dspot.git -b speed-up-input-amplification
cd dspot
mvn install -DskipTests
cd ..

# building experiments project
mvn install -DskipTests