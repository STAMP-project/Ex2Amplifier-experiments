import sys
import json
import argparse


def run(project, flags, onClusty=False, mustClone=True):
    base_cmd_jar = ("~/jdk1.8.0_121/bin/" if onClusty else "") + \
                   "java -jar target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT-jar-with-dependencies.jar"
    date = "january-2018"
    prefix_dataset = "dataset" + "/" + date + "/"
    suffix_json = ".json"
    path_to_json_project_file = prefix_dataset + project + suffix_json

    if onClusty:
        print "export MAVEN_HOME=~/apache-maven-3.3.9/"

    if mustClone:
        cmd_clone = base_cmd_jar + " --clone " + path_to_json_project_file + " --output " + prefix_dataset
        print cmd_clone, "\n"

    base_cmd_run = base_cmd_jar + \
                   " --verbose" + \
                   (" --maven-home ~/apache-maven-3.3.9/" if onClusty else "") + \
                   " --output " + prefix_dataset + \
                   " --run " + path_to_json_project_file + \
                   " --id"

    with open(path_to_json_project_file) as data_file:
        pull_request_data = json.load(data_file)["pullRequests"]

    for pr_data in pull_request_data:
        for mode in ["", "--reverse"]:
            for flag in flags:
                print base_cmd_run, pr_data["id"], mode, flag


if __name__ == '__main__':

    flags = ["--amplifiers"] if "amplifiers" in sys.argv else ["--aampl", "", "--jbse"]
    onClusty = "onClusty" in sys.argv
    mustClone = "mustClone" in sys.argv

    if len(sys.argv) < 2:
        print "usage python run-experiments <project> [onClusty] [mustClone] [amplifiers]"
    else:
        run(project=sys.argv[1],
            flags=flags,
            onClusty=onClusty,
            mustClone=mustClone
            )
