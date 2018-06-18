#!/usr/bin/env bash

docker pull bdanglot/scam18-case-study

cmd="sudo docker run --env CASE_STUDY=${1} --rm bdanglot/scam18-case-study"

echo ${cmd}
eval ${cmd}