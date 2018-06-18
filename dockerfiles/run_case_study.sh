#!/usr/bin/env bash

echo "Running case study number ${CASE_STUDY}"

cd /root/Ex2Amplifier-experiments/
dependencies=`mvn dependency:build-classpath | grep /root/.m2/`
echo ${dependencies}

classpath="target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT.jar:${dependencies}"
echo ${classpath}

# CASE STUDY 1 is protostuff#167
if [ "$CASE_STUDY" -eq 1 ]
then
    echo "Running experiments on Protostuff#167..."
    echo "Cloning both version in dataset/june-2018/protostuff/167 and dataset/june-2018/protostuff/167_modified"

    cmd_clone="java -cp ${classpath} eu.stamp_project.Main --clone dataset/june-2018/protostuff.json --output dataset/june-2018/ --id 167"
    echo ${cmd_clone}
    eval ${cmd_clone}

    echo "Running Assertion amplification (AAMPL) in protostuff#167..."

    cmd_run="java -cp ${classpath} eu.stamp_project.Main --run dataset/june-2018/protostuff.json --id 167 --verbose --aampl"
    echo ${cmd_run}
    eval ${cmd_run}
# CASE STUDY 2 is javapoet#550
elif [ "$CASE_STUDY" -eq 2 ]
then
    echo "Running experiments on javapoet#550..."
    echo "Cloning both version in dataset/june-2018/javapoet/550 and dataset/june-2018/javapoet/550_modified"

    cmd_clone="java -cp ${classpath} eu.stamp_project.Main --clone dataset/june-2018/javapoet.json --output dataset/june-2018/ --id 550"
    echo ${cmd_clone}
    eval ${cmd_clone}

    echo "Running Search-base amplification (SBAMPL) in javapoet#550..."

    cmd_run="java -cp ${classpath} eu.stamp_project.Main --run dataset/june-2018/javapoet.json --id 550 --verbose --amplifiers"
    echo ${cmd_run}
    eval ${cmd_run}
# CASE STUDY 3 is javapoet#608
elif [ "$CASE_STUDY" -eq 3 ]
then
    echo "Running experiments on javapoet#608..."
    echo "Cloning both version in dataset/june-2018/javapoet/608 and dataset/june-2018/javapoet/608_modified"

    cmd_clone="java -cp ${classpath} eu.stamp_project.Main --clone dataset/june-2018/javapoet.json --output dataset/june-2018/ --id 608"
    echo ${cmd_clone}
    eval ${cmd_clone}

    echo "Running Search-base amplification (SBAMPL) in javapoet#608..."

    cmd_run="java -cp ${classpath} eu.stamp_project.Main --run dataset/june-2018/javapoet.json --id 608 --verbose --amplifiers"
    echo ${cmd_run}
    eval ${cmd_run}
fi
