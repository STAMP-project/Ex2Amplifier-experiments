#!/usr/bin/env bash

# cloning DSpot
git clone https://github.com/danglotb/dspot.git -b speed-up-input-amplification
cd dspot
mvn install -DskipTests
cd ..

# building experiments project
mvn install -DskipTests