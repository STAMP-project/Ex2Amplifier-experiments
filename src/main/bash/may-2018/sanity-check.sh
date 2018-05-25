#!/usr/bin/env bash

project=${1}
pr_id=${2}
module=${3}

pwd=`pwd`
echo ${pwd}

prefix_data="dataset/may-2018/"
prefix_res="results/may-2018/"
prefix_pr_id="${prefix_data}${project}/${pr_id}/"
prefix_pr_id_modified="${prefix_data}${project}/${pr_id}_modified/"

echo ${prefix_pr_id}
echo ${prefix_pr_id_modified}

cd ${prefix_pr_id}
git checkout -- "${module}/src/test/"
mvn clean test
base_on_base=${?}
cp -r "${pwd}/${prefix_pr_id_modified}${module}/src/test/" "${pwd}/${prefix_pr_id}/${module}/src/"
mvn clean test
base_on_head=${?}
git checkout -- "${module}/src/test/"

cd ${pwd}

cd ${prefix_pr_id_modified}
git checkout -- "${module}/src/test/"
mvn clean test
head_on_head=${?}
cp -r "${pwd}/${prefix_pr_id}/${module}/src/" "${pwd}/${prefix_pr_id_modified}${module}/src/"
mvn clean test
head_on_base=${?}
git checkout -- "${module}/src/test/"

cd ${pwd}

echo "${base_on_base};${base_on_head}" > "${prefix_res}${project}/${pr_id}/sanity.csv"
echo "${head_on_base};${head_on_head}" >> "${prefix_res}${project}/${pr_id}/sanity.csv"