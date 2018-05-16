import sys
import json
import argparse


def run(project, flags, onClusty=False, mustClone=True, jbse=False, index=[-1]):
    err_out_redirection = "2>&1 | tee -a"
    print "classpath=`" + (
        "~/apache-maven-3.3.9/bin/" if onClusty else "") + "mvn dependency:build-classpath | grep /home`"

    base_cmd_jar = ("~/jdk1.8.0_121/bin/" if onClusty else "") + \
                   "java -Xms16G -Xmx32G -cp target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT.jar:${classpath} eu.stamp.project.Main "
    date = "may-2018"
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

    for i in ((range(0, len(pull_request_data))) if index[0] == -1 else index):
        pr_data = pull_request_data[i]
        print "cd", prefix_dataset + project + "/" + \
                    str(pr_data["id"]), "&&", \
            ("~/apache-maven-3.3.9/bin/" if onClusty else "") \
            + "mvn", "clean", "install", "-DskipTests", "&&", "cd", "../../../.."
        for mode in ["", "--reverse"]:
            for flag in flags:
                output_file_log = "_".join(
                    [str(project), str(pr_data["id"]), str("catg" if flag == "" else flag[2:])]) + (
                                      "_r" if mode == "--reverse" else "") + ".log"
                print base_cmd_run, pr_data["id"], mode, flag, err_out_redirection, output_file_log


if __name__ == '__main__':

    if "amplifiers" in sys.argv:
        flags = ["--amplifiers"]
    else:

        flags = ["--aampl", ""]
onClusty = "onClusty" in sys.argv
mustClone = "mustClone" in sys.argv
if "jbse" in sys.argv:
    flags.append("jbse")
if ',' in sys.argv[-1] and sys.argv[-1][0].isdigit():
    index = [int(x) for x in sys.argv[-1].split(',')]
elif sys.argv[-1][0].isdigit():
    index = [int(sys.argv[-1])]
else:
    index = [-1]

if len(sys.argv) < 2:
    print "usage python run-experiments <project> [onClusty] [mustClone] [amplifiers] [indexOfPR]"
else:
    run(
        project=sys.argv[1],
        flags=flags,
        onClusty=onClusty,
        mustClone=mustClone,
        index=index
    )
